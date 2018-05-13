/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import data.GameObservable;
import data.GenerarComida;
import data.Snake;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author hectormediero
 */
public class PanelDeJuego implements Observer{

    public int[][] jp;
    public GameObservable observable;    
    private int xTabl;
    private int yTabl;
    private GenerarComida generadorDeComida;
    
    public PanelDeJuego(GameObservable gameObservable, int dim) {
        this.xTabl = dim;
        this.yTabl = dim;
        this.jp= new int[dim][dim];
        this.observable = gameObservable;
        this.observable.addObserver(this);
        generadorDeComida= new GenerarComida(this);
    }

    public int getxTabl() {
        return xTabl;
    }

    public int getyTabl() {
        return yTabl;
    }

    public int[][] getJp() {
        return jp;
    }     
    
    public void inciarGeneradoComida(){
        this.generadorDeComida.start();
    }

    public GenerarComida getGeneradorDeComida() {
        return generadorDeComida;
    }

    void borrarSerpiente(int idSnake) {
        System.out.println("IdSnake: " + idSnake);
        for (int i = 0; i < jp.length; i++) {
            for (int j = 0; j < jp.length; j++) {                
                if (jp[i][j] == idSnake) {
                    jp[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < jp.length; i++) {
            for (int j = 0; j < jp.length; j++) {                
                if (jp[i][j] == 1) {
                    System.out.println("Esto no deberia pasar");
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            ServerExec.eviarEstadoPanel();
            ServerExec.enviarPuntuaciones();
        } catch (IOException ex) {
            Logger.getLogger(PanelDeJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
