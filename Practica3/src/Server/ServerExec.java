/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hectormediero
 */
public class ServerExec {

    static ArrayList<JugadorServer> jugadores = new ArrayList();
    private static String comenzar;
    private static Scanner sc;

    public static void main(String[] arg) {
        sc = new Scanner(System.in);
        try {
            ServerSocket skServidor = new ServerSocket(2000);
            Socket sCliente;
            int numcli = 1;
            System.out.println("1: [Servidor listo] Esperando a un nuevo cliente...");
            while (true) {
                sCliente = skServidor.accept();
                System.out.println("2: [Conexión establecida, el cliente " + numcli + " está jugando]");
                jugadores.add(new JugadorServer(sCliente, numcli));
                jugadores.get(jugadores.size() - 1).start();
                numcli++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
