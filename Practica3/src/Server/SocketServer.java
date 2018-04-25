/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.SocketCliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author hectormediero
 */
public class SocketServer extends Thread {

    static final int Puerto = 2000;

    public static ArrayList<SocketServer> listaClientes = new ArrayList();

    int codigoCliente;
    private boolean parar = true;

    private Socket skCliente;
    private InputStream auxin;
    private DataInputStream flujo_entrada;
    private OutputStream auxout;
    static DataOutputStream flujo_salida;

    public SocketServer(Socket sCliente, int codCliente) throws IOException {
        this.skCliente = sCliente;
        this.codigoCliente = codCliente;
        auxin = skCliente.getInputStream();
        flujo_entrada = new DataInputStream(auxin);
        auxout = skCliente.getOutputStream();
        flujo_salida = new DataOutputStream(auxout);
        synchronized (listaClientes) {
            listaClientes.add(this);
        }

        System.out.println("clientes en juego: " + this.listaClientes.size());
    }

    static void enviarServidor(String mensaje) throws IOException {
        flujo_salida.writeUTF(mensaje);
        flujo_salida.flush();
    }

    void cerrarConexion() throws IOException {
        flujo_salida.close();
        auxout.close();
        flujo_entrada.close();
        auxin.close();
        skCliente.close();
    }

    private void saludarJugador() {
        System.out.println("HOLA JUGADOR");
    }

    @Override
    public void run() {
        String mensaje = "CONECTAR";
        while (parar) {
            try {
                mensaje = flujo_entrada.readUTF();
                String[] men = ((String) mensaje).split(";");
                switch (men[0]) {
                    case "CONECTAR":
                        enviarServidor("EMPEZAR_JUEGO");
                        break;
                }
            } catch (IOException ex) {

            }

        }
    }

}
