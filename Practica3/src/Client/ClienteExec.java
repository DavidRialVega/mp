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

    public static void main(String[] args) {
        SocketCliente ac = new SocketCliente();
        ac.conexion(); 
        
        GameObserver observer = new GameObserver();
        MainFrame mf = new MainFrame(observer);
        mf.setVisible(true);
        MainFrame.numeroClientes++;
        
        ac.start();
    }
}
