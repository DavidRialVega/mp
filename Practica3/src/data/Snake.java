package data;

import Client.SocketCliente;
import Server.ServerExec;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Snake extends Thread implements Protocolo {

    public final static int UP = 0;
    public final static int RIGHT = 1;
    public final static int DOWN = 2;
    public final static int LEFT = 3;

    private int direction;
    JPanel[][] jpanel;
    int[][] tablero;
    JPanel jpanelPosicion;
    int x, y;
    boolean pause;
    public GameObservable observer;
    GenerarComida gc;
    int idSnake;

    int[] primeraPosicion = new int[2];
    private ArrayList<int[]> arrayPosiciones = new ArrayList();

    public Snake(int xTabl, int yTabl, int idSnake){
        Random r = new Random();
        this.x = r.nextInt(xTabl);
        this.y = r.nextInt(yTabl);
        this.direction = r.nextInt(4);
        tablero = ServerExec.getPanelDeJuego().getJp();
        primeraPosicion[0] = x;
        primeraPosicion[1] = y;
        this.arrayPosiciones.add(primeraPosicion);
        this.idSnake = idSnake;
    }    
    
    public Snake(JPanel[][] panel, int x, int y, GameObservable observer, GenerarComida gc) {
        this.jpanel = panel;
        this.pause = false;
        this.direction = Snake.RIGHT;
        this.x = x;
        this.y = y;
        jpanelPosicion = jpanel[x][y];
        primeraPosicion[0] = x;
        primeraPosicion[1] = y;
        this.arrayPosiciones.add(primeraPosicion);
        this.observer = observer;
        this.gc = gc;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Soy la serpiente: " + this.idSnake + " Mis coordenadas: " + arrayPosiciones.get(0)[0] + " - " + arrayPosiciones.get(0)[1]);
                Thread.sleep(200);
                moverSerpiente();               
            } catch (InterruptedException ex) {
                Logger.getLogger(Snake.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*public void moveLabel() {
        Color on = Color.RED;
        Color off = Color.WHITE;
        detectarComida();
        try {
            switch (direction) {
                case Snake.UP:
                    for (int cont = arrayPosiciones.size() - 1; cont >= 0; cont--) {
                        int[] posicion = new int[2];
                        posicion[0] = arrayPosiciones.get(cont)[0];
                        posicion[1] = arrayPosiciones.get(cont)[1];
                        if (cont == 0 && arrayPosiciones.size() > 1) {
                            jpanel[posicion[0] - 1][posicion[1]].setBackground(on);
                            arrayPosiciones.get(cont)[0] = posicion[0] - 1;
                        } else if (cont == 0) {
                            jpanel[posicion[0]][posicion[1]].setBackground(off);
                            jpanel[posicion[0] - 1][posicion[1]].setBackground(on);
                            arrayPosiciones.get(cont)[0] = posicion[0] - 1;
                        } else if (cont == arrayPosiciones.size() - 1) {
                            jpanel[posicion[0]][posicion[1]].setBackground(off);

                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        } else {
                            jpanel[arrayPosiciones.get(cont - 1)[0]][arrayPosiciones.get(cont - 1)[1]].setBackground(on);
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        }

                    }
//               

                    break;
                case Snake.RIGHT:
                    for (int cont = arrayPosiciones.size() - 1; cont >= 0; cont--) {
                        int[] posicion = new int[2];
                        posicion[0] = arrayPosiciones.get(cont)[0];
                        posicion[1] = arrayPosiciones.get(cont)[1];
                        if (cont == 0 && arrayPosiciones.size() > 1) {
                            jpanel[posicion[0]][posicion[1] + 1].setBackground(on);
                            arrayPosiciones.get(cont)[1] = posicion[1] + 1;
                        } else if (cont == 0) {
                            jpanel[posicion[0]][posicion[1]].setBackground(off);
                            jpanel[posicion[0]][posicion[1] + 1].setBackground(on);
                            arrayPosiciones.get(cont)[1] = posicion[1] + 1;

                        } else if (cont == arrayPosiciones.size() - 1) {
                            jpanel[posicion[0]][posicion[1]].setBackground(off);
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];

                        } else {
                            jpanel[arrayPosiciones.get(cont - 1)[0]][arrayPosiciones.get(cont - 1)[1]].setBackground(on);
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        }

                    }
//                
                    break;
                case Snake.DOWN:
                    for (int cont = arrayPosiciones.size() - 1; cont >= 0; cont--) {
                        int[] posicion = new int[2];
                        posicion[0] = arrayPosiciones.get(cont)[0];
                        posicion[1] = arrayPosiciones.get(cont)[1];
                        if (cont == 0 && arrayPosiciones.size() > 1) {
                            jpanel[posicion[0] + 1][posicion[1]].setBackground(on);
                            arrayPosiciones.get(cont)[0] = posicion[0] + 1;

                        } else if (cont == 0) {
                            jpanel[posicion[0]][posicion[1]].setBackground(off);
                            jpanel[posicion[0] + 1][posicion[1]].setBackground(on);
                            arrayPosiciones.get(cont)[0] = posicion[0] + 1;

                        } else if (cont == arrayPosiciones.size() - 1) {
                            jpanel[posicion[0]][posicion[1]].setBackground(off);
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];

                        } else {
                            jpanel[arrayPosiciones.get(cont - 1)[0]][arrayPosiciones.get(cont - 1)[1]].setBackground(on);
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        }

                    }
//            
                    break;
                case Snake.LEFT:
                    for (int cont = arrayPosiciones.size() - 1; cont >= 0; cont--) {
                        int[] posicion = new int[2];
                        posicion[0] = arrayPosiciones.get(cont)[0];
                        posicion[1] = arrayPosiciones.get(cont)[1];
                        if (cont == 0 && arrayPosiciones.size() > 1) {
                            jpanel[posicion[0]][posicion[1] - 1].setBackground(on);
                            arrayPosiciones.get(cont)[1] = posicion[1] - 1;
                        } else if (cont == 0) {
                            jpanel[posicion[0]][posicion[1]].setBackground(off);
                            jpanel[posicion[0]][posicion[1] - 1].setBackground(on);

                            arrayPosiciones.get(cont)[1] = posicion[1] - 1;
                        } else if (cont == arrayPosiciones.size() - 1) {
                            jpanel[posicion[0]][posicion[1]].setBackground(off);
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        } else {
                            jpanel[arrayPosiciones.get(cont - 1)[0]][arrayPosiciones.get(cont - 1)[1]].setBackground(on);
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        }

                    }
//               
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            JOptionPane.showMessageDialog(null, "Game Over");
            MainFrame.runningApp = false;

        } catch (ArrayStoreException ex) {
            JOptionPane.showMessageDialog(null, "Game Over");
            MainFrame.runningApp = false;

        }

    }*/
    
    public void moverSerpiente(){
        Color on = Color.RED;
        Color off = Color.WHITE;
        try {
            switch (direction) {
                case Snake.UP:
                    for (int cont = arrayPosiciones.size() - 1; cont >= 0; cont--) {
                        int[] posicion = new int[2];
                        posicion[0] = arrayPosiciones.get(cont)[0];
                        posicion[1] = arrayPosiciones.get(cont)[1];
                        if (cont == 0 && arrayPosiciones.size() > 1) {
                            tablero[posicion[0] - 1][posicion[1]] = this.idSnake;
                            arrayPosiciones.get(cont)[0] = posicion[0] - 1;
                        } else if (cont == 0) {
                            tablero[posicion[0]][posicion[1]] = 0;
                            tablero[posicion[0] - 1][posicion[1]] = this.idSnake;
                            arrayPosiciones.get(cont)[0] = posicion[0] - 1;
                        } else if (cont == arrayPosiciones.size() - 1) {
                            tablero[posicion[0]][posicion[1]] = 0;
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        } else {
                            tablero[arrayPosiciones.get(cont - 1)[0]][arrayPosiciones.get(cont - 1)[1]] = this.idSnake;
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        }
                    }
                    break;
                case Snake.RIGHT:
                    for (int cont = arrayPosiciones.size() - 1; cont >= 0; cont--) {
                        int[] posicion = new int[2];
                        posicion[0] = arrayPosiciones.get(cont)[0];
                        posicion[1] = arrayPosiciones.get(cont)[1];
                        if (cont == 0 && arrayPosiciones.size() > 1) {
                            tablero[posicion[0]][posicion[1] + 1] = this.idSnake;
                            arrayPosiciones.get(cont)[1] = posicion[1] + 1;
                        } else if (cont == 0) {
                            tablero[posicion[0]][posicion[1]] = 0;
                            tablero[posicion[0]][posicion[1] + 1] = this.idSnake;
                            arrayPosiciones.get(cont)[1] = posicion[1] + 1;

                        } else if (cont == arrayPosiciones.size() - 1) {
                            tablero[posicion[0]][posicion[1]] = 0;
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];

                        } else {
                            tablero[arrayPosiciones.get(cont - 1)[0]][arrayPosiciones.get(cont - 1)[1]] = this.idSnake;
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        }
                    }
                    break;
                case Snake.DOWN:
                    for (int cont = arrayPosiciones.size() - 1; cont >= 0; cont--) {
                        int[] posicion = new int[2];
                        posicion[0] = arrayPosiciones.get(cont)[0];
                        posicion[1] = arrayPosiciones.get(cont)[1];
                        if (cont == 0 && arrayPosiciones.size() > 1) {
                            tablero[posicion[0] + 1][posicion[1]] = this.idSnake;
                            arrayPosiciones.get(cont)[0] = posicion[0] + 1;

                        } else if (cont == 0) {
                            tablero[posicion[0]][posicion[1]] = 0;
                            tablero[posicion[0] + 1][posicion[1]] = this.idSnake;
                            arrayPosiciones.get(cont)[0] = posicion[0] + 1;

                        } else if (cont == arrayPosiciones.size() - 1) {
                            tablero[posicion[0]][posicion[1]] = 0;
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];

                        } else {
                            tablero[arrayPosiciones.get(cont - 1)[0]][arrayPosiciones.get(cont - 1)[1]] = this.idSnake;
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        }
                    }
                    break;
                case Snake.LEFT:
                    for (int cont = arrayPosiciones.size() - 1; cont >= 0; cont--) {
                        int[] posicion = new int[2];
                        posicion[0] = arrayPosiciones.get(cont)[0];
                        posicion[1] = arrayPosiciones.get(cont)[1];
                        if (cont == 0 && arrayPosiciones.size() > 1) {
                            tablero[posicion[0]][posicion[1] - 1] = this.idSnake;
                            arrayPosiciones.get(cont)[1] = posicion[1] - 1;
                        } else if (cont == 0) {
                            tablero[posicion[0]][posicion[1]] = 0;
                            tablero[posicion[0]][posicion[1] - 1] = this.idSnake;
                            arrayPosiciones.get(cont)[1] = posicion[1] - 1;
                        } else if (cont == arrayPosiciones.size() - 1) {
                            tablero[posicion[0]][posicion[1]] = 0;
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        } else {
                            tablero[arrayPosiciones.get(cont - 1)[0]][arrayPosiciones.get(cont - 1)[1]] = 1;
                            arrayPosiciones.get(cont)[0] = arrayPosiciones.get(cont - 1)[0];
                            arrayPosiciones.get(cont)[1] = arrayPosiciones.get(cont - 1)[1];
                        }
                    }               
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            //JOptionPane.showMessageDialog(null, "Game Over");
            //MainFrame.runningApp = false;

        } catch (ArrayStoreException ex) {
            //JOptionPane.showMessageDialog(null, "Game Over");
            //MainFrame.runningApp = false;

        }
    }

    public void setDirection(int direction) {
        //this.direction = direction;
        if (this.direction == 0 && ((direction == 1) || (direction == 3))) {
            this.direction = direction;
        }
        if (this.direction == 1 && ((direction == 2) || (direction == 0))) {
            this.direction = direction;
        }
        if (this.direction == 2 && ((direction == 3) || (direction == 1))) {
            this.direction = direction;
        }
        if (this.direction == 3 && ((direction == 0) || (direction == 2))) {
            this.direction = direction;
        }
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    private void detectarComida() {
        int[] nuevaPosicion = new int[2];
        int posicionABorrar = -1;
        for (int i = 0; i < gc.getArrLComidas().size(); i++) {
            if (primeraPosicion[0] == gc.getArrLComidas().get(i)[0] && primeraPosicion[1] == gc.getArrLComidas().get(i)[1]) {
                nuevaPosicion[0] = x;
                nuevaPosicion[1] = y;
                arrayPosiciones.add(nuevaPosicion);
                posicionABorrar = i;
                break;
            }
        }
        if (posicionABorrar != -1) {
            gc.arrLComidas.remove(posicionABorrar);
        }

    }

}
