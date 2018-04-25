/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import data.GameObserver;
import data.MainFrame;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hectormediero
 */
public class SocketCliente extends Thread {

    private boolean parar = true;

    final String HOST = "localhost";
    final int Puerto = 2000;
    static DataOutputStream flujo_salida;
    DataInputStream flujo_entrada;
    OutputStream auxout;
    InputStream auxin;
    Socket sCliente;

    private String mensaje = "CONECTAR";

    public SocketCliente() {
        try {
            sCliente = new Socket(HOST, Puerto);
            auxout = sCliente.getOutputStream();
            flujo_salida = new DataOutputStream(auxout);
            auxin = sCliente.getInputStream();
            flujo_entrada = new DataInputStream(auxin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String conexion() {
        String respuestaInicial = "";
        try {
            flujo_salida.writeUTF(mensaje);
            flujo_salida.flush();
            respuestaInicial = flujo_entrada.readUTF();    //Duerme hasta que recibe la respuesta 
            System.out.println("1: [Establecida conexión con el servidor]");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return respuestaInicial;
    }

    void setMensaje(String orden) {
        this.mensaje = orden;
    }

    public static void enviar(String mensaje) {
        try {
            flujo_salida.writeUTF(mensaje);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            System.out.println("Fin del juego...");
            flujo_salida.close();
            auxout.close();
            flujo_entrada.close();
            auxout.close();
            sCliente.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        String respuesta = "";
        while (parar) {
            try {
                respuesta = flujo_entrada.readUTF();
                String[] mensajes = ((String) respuesta).split(";");
                System.out.println(Arrays.toString(mensajes));
                switch (mensajes[0]) {
                    case "ESPERAR_JUGADORES":
//                        synchronized (this) {
//                            try {
//                                this.wait();
//                            } catch (InterruptedException ex) {
//                                Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                        }
                        break;
                    case "EMPEZAR_JUEGO":

                        break;
                    default:
                        System.out.println("NO HEMOS PODIDO INTERPRETAR SU MENSAJE");
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }
}
