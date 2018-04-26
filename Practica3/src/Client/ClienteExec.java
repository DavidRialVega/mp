/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import data.GameObservable;
import data.MainFrame;
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
    private static int idCliente;

    public static void main(String[] args) {
        vInicialCliente = new VentanaInicialCliente();
        vInicialCliente.setVisible(true);
        socketCliente = new SocketCliente();        
    }
    
    public static void intentaLogin(){
        if (socketCliente.incializar(ClienteExec.ipServidor, ClienteExec.puertoServidor)) {
            socketCliente.start();
            ClienteExec.vInicialCliente.dispose();
            vPrincipalCliente = new MainFrameCliente();            
            vPrincipalCliente.setTextJlNombreUsuario(nombreUsuario);
            vPrincipalCliente.setVisible(true);            
        }else {
            JOptionPane.showMessageDialog(vInicialCliente,"Login erroneo por favor cambie la direccion ip o el puerto, "
                + "o intentelo más tarde","Problema de red", JOptionPane.ERROR_MESSAGE);
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
    
}
