/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.SocketCliente;
import data.Protocolo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author hectormediero
 */
public class JugadorServer extends Thread implements Protocolo {

    int codigoCliente;
    private boolean parar = true;

    private Socket skCliente;
    private InputStream inputStream;
    private DataInputStream flujo_entrada;
    private OutputStream outputStream;
    static DataOutputStream flujo_salida;

    public JugadorServer(Socket sCliente, int codCliente) throws IOException {
        this.skCliente = sCliente;
        this.codigoCliente = codCliente;
        inputStream = skCliente.getInputStream();
        flujo_entrada = new DataInputStream(inputStream);
        outputStream = skCliente.getOutputStream();
        flujo_salida = new DataOutputStream(outputStream);
        enviarMensaje(IDC + ";" + codCliente);

    }

    static void enviarMensaje(String mensaje) throws IOException {
        flujo_salida.writeUTF(mensaje);
        flujo_salida.flush();
    }

    void cerrarConexion() throws IOException {
        flujo_salida.close();
        outputStream.close();
        flujo_entrada.close();
        inputStream.close();
        skCliente.close();
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

            }

        }
    }

}
