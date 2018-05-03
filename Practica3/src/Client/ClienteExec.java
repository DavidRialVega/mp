/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import data.GameObservable;
import java.awt.Color;

import javax.swing.JOptionPane;

/**
 *
 * @author hectormediero
 */
public class ClienteExec {

    private static String ipServidor;
    private static String nombreUsuario;
    private static int puertoServidor;
    private static SocketCliente socketCliente;
    private static VentanaInicialCliente vInicialCliente;
    private static MainFrameCliente vPrincipalCliente;
    private static GameObservable gameObsevable = new GameObservable();
    private static int idCliente;
    private static int xTablero;
    private static int yTablero;

    public static void main(String[] args) {
        vInicialCliente = new VentanaInicialCliente();
        vInicialCliente.setVisible(true);
        socketCliente = new SocketCliente();
        vPrincipalCliente = new MainFrameCliente(gameObsevable);
    }

    public static void intentaLogin() {
        if (socketCliente.incializar(ClienteExec.ipServidor, ClienteExec.puertoServidor)) {
            socketCliente.start();
            ClienteExec.vInicialCliente.dispose();
            vPrincipalCliente.setTextJlNombreUsuario(nombreUsuario);
            vPrincipalCliente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(vInicialCliente, "Login erroneo por favor cambie la direccion ip o el puerto, "
                    + "o intentelo más tarde", "Problema de red", JOptionPane.ERROR_MESSAGE);
        }
    }

     public static void actualizaPanel(int arrayPosiciones[][]) {
        for (int i = 0; i < arrayPosiciones.length; i++) {
            for (int j = 0; j < arrayPosiciones[0].length; j++) {
                switch (arrayPosiciones[i][j]) {
                    case -1:
                        getvPrincipalCliente().jp[i][j].setBackground(Color.GREEN);
                        break;
                    case 0:
                        break;
                    default:

                        break;
                }
            }

        }
    }
     
    public static String getIpServidor() {
        return ipServidor;
    }

    public static String getNombreUsuario() {
        return nombreUsuario;
    }

    public static int getPuertoServidor() {
        return puertoServidor;
    }

    public static void setIpServidor(String ipServidor) {
        ClienteExec.ipServidor = ipServidor;
    }

    public static void setNombreUsuario(String nombreUsuario) {
        ClienteExec.nombreUsuario = nombreUsuario;
    }

    public static void setPuertoServidor(int puertoServidor) {
        ClienteExec.puertoServidor = puertoServidor;
    }

    public static void setIdCliente(int idCliente) {
        ClienteExec.idCliente = idCliente;
    }

    public static int getIdCliente() {
        return idCliente;
    }

    public static SocketCliente getSocketCliente() {
        return socketCliente;
    }

    public static void setxTablero(int xTablero) {
        ClienteExec.xTablero = xTablero;
    }

    public static void setyTablero(int yTablero) {
        ClienteExec.yTablero = yTablero;
    }

    public static int getxTablero() {
        return xTablero;
    }

    public static int getyTablero() {
        return yTablero;
    }

    public static MainFrameCliente getvPrincipalCliente() {
        return vPrincipalCliente;
    }

   

}
