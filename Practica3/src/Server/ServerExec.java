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
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hectormediero
 */
public class ServerExec implements Protocolo {

    public static ArrayList<JugadorServer> jugadores = new ArrayList();
    private static PanelDeJuego panelDeJuego;
    private static GameObservable gameObservable;
    private static boolean partidaActiva;
    private static MainFrameServer mfServer;
    private static Traductor traductor = new Traductor();

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

    public static void empezarPartida() throws IOException {
        System.out.println("Empiezo la partida");
        ServerExec.broadcast(EMP_PAR + "");
        ServerExec.panelDeJuego.inciarGeneradoComida();
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
            ServerExec.setPartidaActiva(true);
            ServerExec.empezarPartida();
        } else {
            System.out.println("No hay suficientes jugadores");
        }
    }

    public static void enviarMensajeDeTodosLosColores() {
        int[][] arrayColores = new int[(jugadores.get(jugadores.size() - 1).codigoJugador) + 1][3];
        for (int i = 0; i < jugadores.size(); i++) {
            for (int j = 0; j < arrayColores.length; j++) {
                if (j + 1 == jugadores.get(i).codigoJugador) {
                    arrayColores[j + 1][0] = jugadores.get(i).getColorCliente().getRed();
                    arrayColores[j + 1][1] = jugadores.get(i).getColorCliente().getGreen();
                    arrayColores[j + 1][2] = jugadores.get(i).getColorCliente().getBlue();
                    break;
                }
            }
        }
        try {
            System.out.println(traductor.tableroToString(arrayColores));
            broadcast(GETCOLOR_ID + ";" + traductor.tableroToString(arrayColores));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

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

    public static void eviarEstadoPanel() {
        Traductor t = new Traductor();
        try {
            enviarMensajeDeTodosLosColores();
            broadcast(PANEL + ";" + t.tableroToString(panelDeJuego.getJp()));

        } catch (IOException ex) {
            System.err.println("Error al enviar el panel");
        }
    }

    public static void enviarPuntuaciones() throws IOException {
        String mensaje = "";
        for (int i = 0; i < jugadores.size(); i++) {
            if (i != 0) {
                mensaje += ":";
            }
            mensaje += jugadores.get(i).codigoJugador + "_" + gameObservable.tamSnake(jugadores.get(i).codigoJugador);
        }
        broadcast(PUNTUACIONES + ";" + mensaje);

    }

    public static void matarSerpiente(int idSnake) throws InterruptedException {
        ServerExec.getGameObservable().getSnake(idSnake).setViva(false);
        ServerExec.getGameObservable().borrarSerpiente(idSnake);

        for (int i = 0; i < ServerExec.jugadores.size(); i++) {
            if (ServerExec.jugadores.get(i).codigoJugador == idSnake) {
                try {
                    ServerExec.jugadores.get(i).cerrarConexion();
                    ServerExec.jugadores.remove(i);
                } catch (IOException ex) {
                    System.out.println("Fallo al cerrar la conexion en el game over");
                }
            }
        }
        Thread.sleep(1000);
        ServerExec.panelDeJuego.borrarSerpiente(idSnake);
    }

    public static void setPartidaActiva(boolean partidaActiva) {
        ServerExec.partidaActiva = partidaActiva;
    }

}
