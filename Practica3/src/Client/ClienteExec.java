/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import data.GameObserver;
import data.MainFrame;

/**
 *
 * @author hectormediero
 */
public class ClienteExec {
    
    private static String ipServidor;
    private static String nombreUsuario;
    private static int puertoServidor;
    private static SocketCliente socketCliente;

    public static void main(String[] args) {
        VentanaInicialCliente vInicialCliente = new VentanaInicialCliente();
        vInicialCliente.setVisible(true);
        socketCliente = new SocketCliente();
//        SocketCliente ac = new SocketCliente();
//        ac.conexion(); 
//        
//        GameObserver observer = new GameObserver();
//        MainFrame mf = new MainFrame(observer);
//        mf.setVisible(true);
//        MainFrame.numeroClientes++;
//        
//        ac.start();
    }
    
    public static void intentaLogin(){
        if (socketCliente.incializar(ClienteExec.ipServidor, ClienteExec.puertoServidor)) {
            System.out.println("Conectado al servidor");
        }else {
            System.out.println("Error en la conexion");
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
}
