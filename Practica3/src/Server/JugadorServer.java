/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Client.SocketCliente;
import data.Protocolo;
import data.Snake;
import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
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
    private boolean parar = false;

    private Socket skCliente;
    private InputStream inputStream;
    private DataInputStream flujo_entrada;
    private OutputStream outputStream;
    private DataOutputStream flujo_salida;
    private boolean listoJugar;
    private Color colorCliente;
    private String nombreCliente;

    public JugadorServer(Socket sCliente, int codCliente) throws IOException {
        this.skCliente = sCliente;
        this.codigoJugador = codCliente;
        inputStream = skCliente.getInputStream();
        flujo_entrada = new DataInputStream(inputStream);
        outputStream = skCliente.getOutputStream();
        flujo_salida = new DataOutputStream(outputStream);
        listoJugar = false;
        enviarMensajesIniciales();
        ServerExec.getGameObservable().addSnake(this.codigoJugador, new Snake(ServerExec.getPanelDeJuego().getxTabl(), ServerExec.getPanelDeJuego().getyTabl(), this.codigoJugador));
    }

    private void enviarMensajesIniciales() {
        enviarMensaje(IDC + ";" + this.codigoJugador);
        this.enviarMensaje(TAM_TABL + ";" + ServerExec.getPanelDeJuego().getxTabl() + ";" + ServerExec.getPanelDeJuego().getyTabl());
    }

    public void enviarMensaje(String mensaje) {
        try {
            flujo_salida.writeUTF(mensaje);
            flujo_salida.flush();
        } catch (SocketException ex) {
            try {
                this.flujo_entrada.close();
                this.flujo_salida.close();
                this.skCliente.close();
            } catch (IOException ex1) {
                System.out.println("Fallo al cerrar el socket");
            }
        } catch (IOException ex) {
            System.out.println("Fallo de IO al enviar mensaje");
        }
    }

    void cerrarConexion() throws IOException {
        enviarMensaje(FIN + "");
        flujo_salida.close();
        outputStream.close();
        flujo_entrada.close();
        inputStream.close();
        skCliente.close();
    }

    @Override
    public void run() {
        String mensaje = "";
        while (!parar) {
            try {
                mensaje = flujo_entrada.readUTF();
                StringTokenizer st = new StringTokenizer(mensaje, ";");
                int tipo_mensaje = Integer.parseInt(st.nextToken());
                switch (tipo_mensaje) {
                    case INICIALIZAR:
                        setColorCliente(Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken()));
                        setNombreCliente(st.nextToken());
                        break;
                    case IDC:

                        break;
                    case ERR:

                        break;
                    case FIN:
                        parar = true;
                        ServerExec.matarSerpiente(this.codigoJugador);
                        break;
                    case DIR:
                        int direccion = Integer.parseInt(st.nextToken());
                        ServerExec.getGameObservable().cambiarDireccionSnake(this.codigoJugador, direccion);
                        break;
                    case MOV:

                        break;
                    case PTS:

                        break;
                    case EMP_PAR:
                        this.listoJugar = true;
                        if (ServerExec.isPartidaActiva()) {
                            enviarMensaje(EMP_PAR + "");
                            ServerExec.getGameObservable().startSnake(codigoJugador);
                        } else {
                            ServerExec.comprobarJugadoresActivos();
                        }
                        break;

                }
            } catch (IOException ex) {
                try {
                    ServerExec.matarSerpiente(codigoJugador);
                    parar = true;
                } catch (InterruptedException ex1) {
                    Logger.getLogger(JugadorServer.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(JugadorServer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public boolean isListoJugar() {
        return listoJugar;
    }

    public Color getColorCliente() {
        return colorCliente;
    }

    public void setColorCliente(Integer r, Integer g, Integer b) {
        this.colorCliente = new Color(r, g, b);
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreElegido) {
        this.nombreCliente = nombreElegido;
    }

}
