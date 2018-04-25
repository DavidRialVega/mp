/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import data.GameObservable;
import data.Protocolo;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hectormediero
 */
public class ServerExec implements Protocolo{

    static ArrayList<JugadorServer> jugadores = new ArrayList();
    private static PanelDeJuego panelDeJuego;
    private static GameObservable gameObservable;
    private static int tamanio = 39;
   

    public static void main(String[] arg) {       
        try {            
            ServerSocket skServidor = new ServerSocket(2000);
            Socket sCliente;
            int numcli = 1;            
            gameObservable = new GameObservable();
            panelDeJuego = new PanelDeJuego(gameObservable);     
            broadcast(PANEL + ";" + ServerExec.panelDeJuego.jp);
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

    public static GameObservable getGameObservable() {
        return gameObservable;
    }
    
    public static void empezarPartida() throws IOException{
        ServerExec.broadcast(EMP_PAR + "");
        ServerExec.gameObservable.empezarPartida();
    }
    
    public static void broadcast(String mensaje) throws IOException{
        for (JugadorServer jugador : jugadores) {
            jugador.enviarMensaje(mensaje);
        }
    }

    public static int getTamanio() {
        return tamanio;
    }
}
