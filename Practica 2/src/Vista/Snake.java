package Vista;

import javax.swing.*;
import Vista.JIndex;
import java.awt.Color;
import java.awt.Rectangle;

public class Snake extends Thread {

    public final static int UP = 0;
    public final static int RIGHT = 1;
    public final static int DOWN = 2;
    public final static int LEFT = 3;

    private int direction;
    JPanel[][] jpanel;
    JPanel jpanelPosicion;
    int x, y;
    boolean pause;

    public Snake(JPanel[][] panel, int x, int y) {
        this.jpanel = panel;
        this.pause = false;
        this.direction = Snake.RIGHT;
        this.x = x;
        this.y = y;
        jpanelPosicion = jpanel[x][y];
    }

    @Override
    public void run() {
        while (JIndex.runningApp) {
            if (!pause) {
                try {
                    Thread.sleep(300);
                    moveLabel();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void moveLabel() {
        Color on = Color.RED;
        Color off = Color.WHITE;
        switch (direction) {
            case Snake.UP:
                jpanelPosicion.setBackground(off);
                jpanel[x - 1][y].setBackground(on);
                jpanelPosicion = jpanel[x - 1][y];
                x = x - 1;
                break;
            case Snake.RIGHT:                
                jpanelPosicion.setBackground(off);
                jpanel[x][y + 1].setBackground(on);
                jpanelPosicion = jpanel[x][y + 1];
                y = y + 1;
                break;
            case Snake.DOWN:
                jpanelPosicion.setBackground(off);
                jpanel[x + 1][y].setBackground(on);
                jpanelPosicion = jpanel[x +1][y];
                x = x + 1;
               
                break;
            case Snake.LEFT:
                 jpanelPosicion.setBackground(off);
                jpanel[x][y - 1].setBackground(on);
                jpanelPosicion = jpanel[x][y - 1];
                y = y - 1;
                
                break;
        }
        actualizarCamposXY();
    }

    private void actualizarCamposXY() {
        JIndex.tfY.setText("" + jpanelPosicion.getY());
        JIndex.tfX.setText("" + jpanelPosicion.getX());
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
}