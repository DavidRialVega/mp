package data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author hectormediero
 */
public class GenerarComida extends Thread {

    private boolean noFin = true;
    private Integer x = 0, y = 0;
    public JPanel[][] paneles;
    public Integer numeroComidas = 0;
    public ArrayList<int[]> arrLComidas = new ArrayList();
    public int tamaño = 39;

    @Override
    public void run() {
        Random r = new Random();
        while (noFin) {

            x = r.nextInt(tamaño);
            y = r.nextInt(tamaño);
            generarComida();

        }
    }

    public Integer getNumeroComidas() {
        return numeroComidas;
    }

    public void setNumeroComidas(Integer numeroComidas) {
        this.numeroComidas = numeroComidas;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public GenerarComida(JPanel[][] paneles) {
        this.paneles = paneles;
    }

    public ArrayList<int[]> getArrLComidas() {
        return arrLComidas;
    }

    public void setArrLComidas(ArrayList<int[]> arrLComidas) {
        this.arrLComidas = arrLComidas;
    }

    private void generarComida() {
        if (arrLComidas.size() < 5) {
            this.paneles[x][y].setBackground(Color.GREEN);
            int[] nuevaComidita = new int[2];
            nuevaComidita[0] = x;
            nuevaComidita[1] = y;
            arrLComidas.add(nuevaComidita);
            numeroComidas++;
        }
    }

}
