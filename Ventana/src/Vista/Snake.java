package Vista;

import javax.swing.*;
import Vista.JIndex;
import java.awt.Rectangle;

public class Snake extends Thread {

    public final static int UP = 0;
    public final static int RIGHT = 1;
    public final static int DOWN = 2;
    public final static int LEFT = 3;

    private int direction;
    JLabel label;
    boolean pause;

    public Snake(JLabel label) {
        this.label = label;
        this.pause = false;
        this.direction = Snake.RIGHT;
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
        Rectangle rec = JIndex.panelEscenario.getBounds();
        if (label.getX() >= rec.width || label.getX() <= 0 || 
            label.getY() >= rec.height || label.getY() <= 0 || 
            label.getText().equals("GAME OVER")) {
                label.setText("GAME OVER");
                label.setLocation(450, 250);
        } else {
            switch (direction) {
                case Snake.UP:
                    label.setLocation(label.getX(), label.getY() + 10);
                    break;
                case Snake.RIGHT:
                    label.setLocation(label.getX() + 10, label.getY());
                    break;
                case Snake.DOWN:
                    label.setLocation(label.getX(), label.getY() - 10);
                    break;
                case Snake.LEFT:
                    label.setLocation(label.getX() - 10, label.getY());
                    break;
            }
            actualizarCamposXY();
        }

    }

    private void actualizarCamposXY() {
        JIndex.tfY.setText("" + label.getY());
        JIndex.tfX.setText("" + label.getX());
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
}
