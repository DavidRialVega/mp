/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.SocketCliente;
import data.Protocolo;
import data.Snake;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hectormediero
 */
public class JugadorServer extends Thread implements Protocolo {

    int codigoJugador;
    private boolean parar = true;

    private Socket skCliente;
    private InputStream inputStream;
    private DataInputStream flujo_entrada;
    private OutputStream outputStream;
    private DataOutputStream flujo_salida;
    private boolean listoJugar;

    public JugadorServer(Socket sCliente, int codCliente) throws IOException {
        this.skCliente = sCliente;
        this.codigoJugador = codCliente;
        inputStream = skCliente.getInputStream();
        flujo_entrada = new DataInputStream(inputStream);
        outputStream = skCliente.getOutputStream();
        flujo_salida = new DataOutputStream(outputStream);
        listoJugar = false;     
        enviarMensajesIniciales();
        ServerExec.getGameObservable().addSnake(this.codigoJugador, new Snake(ServerExec.getPanelDeJuego().getxTabl(), ServerExec.getPanelDeJuego().getyTabl()));
    }
    
    private void enviarMensajesIniciales(){
        enviarMensaje(IDC + ";" + this.codigoJugador);
        this.enviarMensaje(TAM_TABL + ";" + ServerExec.getPanelDeJuego().getxTabl() + ";" + ServerExec.getPanelDeJuego().getyTabl());
    }

    public void enviarMensaje(String mensaje) {
        try {
            flujo_salida.writeUTF(mensaje);
            flujo_salida.flush();
        } catch (IOException ex) {
            Logger.getLogger(JugadorServer.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    case EMP_PAR:
                        this.listoJugar = true;
                        if (ServerExec.isPartidaActiva()) {
                            enviarMensaje(EMP_PAR + "");                            
                        }else {
                            //ServerExec.comprobarJugadoresActivos();
                        }
                        break;

                }
            } catch (IOException ex) {

            }

        }
    }

    public boolean isListoJugar() {
        return listoJugar;
    }
}
