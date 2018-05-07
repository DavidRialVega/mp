/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import data.GameObservable;
import data.Protocolo;
import data.Traductor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hectormediero
 */
public class ServerExec implements Protocolo {

    static ArrayList<JugadorServer> jugadores = new ArrayList();
    private static PanelDeJuego panelDeJuego;
    private static GameObservable gameObservable;
    private static boolean partidaActiva;
    private static MainFrameServer mfServer;

    public static void main(String[] arg) {
        mfServer = new MainFrameServer();
        mfServer.setVisible(true);
        try {
            partidaActiva = false;
            ServerSocket skServidor = new ServerSocket(2000);
            Socket sCliente;
            int numcli = 1;
            gameObservable = new GameObservable();            
            while (true) {
                sCliente = skServidor.accept();
                jugadores.add(new JugadorServer(sCliente, numcli));
                jugadores.get(jugadores.size() - 1).start();
                numcli++;
                System.out.println("jugadores: " + jugadores.size());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void iniciarTablero(int xTablero, int yTablero) {
        panelDeJuego = new PanelDeJuego(gameObservable, xTablero, yTablero);
        
    }
    public static GameObservable getGameObservable() {
        return gameObservable;
    }
    
    public static void empezarPartida() throws IOException{
        System.out.println("Empiezo la partida");
        ActualizadorPanel actualizador = new ActualizadorPanel();
        ServerExec.broadcast(EMP_PAR + "");
        ServerExec.panelDeJuego.inciarGeneradoComida();
        ServerExec.gameObservable.empezarPartida();
        actualizador.start();
        ServerExec.gameObservable.empezarPartida();
    }

    public static void comprobarJugadoresActivos() throws IOException {
        int cont = 0;

        for (JugadorServer jugador : jugadores) {
            if (jugador.isListoJugar()) {
                cont++;
            }
        }
        if (cont >= 1) {
            ServerExec.empezarPartida();
        } else {
            System.out.println("No hay suficientes jugadores");
        }
    }
     
   /* public static int comprobarJugadoresActivos() throws IOException {
        int cont = 0;

        for (JugadorServer jugador : jugadores) {
            if (jugador.isListoJugar()) {
                cont++;
            }
        }
        return cont;
    }*/

    public static void broadcast(String mensaje) throws IOException {
        for (JugadorServer jugador : jugadores) {
            jugador.enviarMensaje(mensaje);
        }
    }

    public static boolean isPartidaActiva() {
        return partidaActiva;
    }

    public static PanelDeJuego getPanelDeJuego() {
        return panelDeJuego;
    }
    
    public static void eviarEstadoPanel(){
        Traductor t = new Traductor();
        try {
            broadcast(PANEL + ";" + t.tableroToString(panelDeJuego.getJp()));
        } catch (IOException ex) {
            System.err.println("Error al enviar el panel");
        }
    }
}
