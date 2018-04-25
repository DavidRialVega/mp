/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import data.GameObservable;
import data.Snake;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author hectormediero
 */
public class PanelDeJuego implements Observer {

    public ArrayList<int[]> jp = new ArrayList<int[]>();
    public GameObservable observable;    
    
    public PanelDeJuego(GameObservable gameObservable) {
        this.observable = gameObservable;
        for(int i = 0; i < 40 ; i++){
            int[] arraux = new int [39];
            jp.add(arraux);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
