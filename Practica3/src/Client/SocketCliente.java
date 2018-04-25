/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import data.GameObservable;
import data.MainFrame;
import data.Protocolo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hectormediero
 */
public class SocketCliente extends Thread implements Protocolo{

    private boolean parar = true;
    static DataOutputStream flujo_salida;
    DataInputStream flujo_entrada;
    OutputStream auxout;
    InputStream auxin;
    Socket sCliente;

    public SocketCliente() {

    }

    public boolean incializar(String host, int puerto) {
        try {
            sCliente = new Socket(host, puerto);
            auxout = sCliente.getOutputStream();
            flujo_salida = new DataOutputStream(auxout);
            auxin = sCliente.getInputStream();
            flujo_entrada = new DataInputStream(auxin);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /*  public String conexion() {
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
     }*/
    public void enviar(String mensaje) {
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
        String mensaje = "";
        while (parar) {
            try {
                mensaje = flujo_entrada.readUTF();
                StringTokenizer st = new StringTokenizer(mensaje, ";");
                int tipo_mensaje = Integer.parseInt(st.nextToken());

                switch (tipo_mensaje) {
                    case IDC:
                        ClienteExec.setIdCliente(Integer.parseInt(st.nextToken()));
                        break;
                    case ERR:

                        break;
                    case FIN:

                        break;
                    case MOV:

                        break;
                    case PTS:

                        break;
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);

            }
        }

    }
}
