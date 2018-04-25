/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author hectormediero
 */
public class PanelDeJuego extends JPanel implements Observer, ActionListener {

    private GameObserver observer;
    public JPanel[][] jp = new JPanel[39][39];

    public PanelDeJuego(GameObserver observador) {
        this.observer = observador;
        this.setPreferredSize(new java.awt.Dimension(390, 390));
        this.setLayout(new java.awt.GridLayout(39, 39, 1, 1));
        for (int i = 0; i < 39; i++) {
            for (int j = 0; j < 39; j++) {
                jp[i][j] = new JPanel();
                jp[i][j].setBackground(Color.white);
                this.add(jp[i][j]);
            }
        }
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                actualiza(e.getKeyCode(), true);
            }

        });
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void actualiza(int keyCode, boolean pressed) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                observer.setDireccion(Snake.UP);
                break;
            case KeyEvent.VK_DOWN:
                observer.setDireccion(Snake.DOWN);
                break;

            case KeyEvent.VK_LEFT:
                observer.setDireccion(Snake.LEFT);
                break;

            case KeyEvent.VK_RIGHT:
                observer.setDireccion(Snake.RIGHT);
                break;
        }
    }

}
