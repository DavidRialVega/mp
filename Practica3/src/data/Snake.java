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
    boolean viva = true;

    int[] primeraPosicion = new int[2];
    public ArrayList<int[]> arrayPosiciones = new ArrayList();

    public Snake(int xTabl, int yTabl, int idSnake) {
        Random r = new Random();
        this.x = r.nextInt(xTabl / 2) + xTabl / 4;
        this.y = r.nextInt(yTabl / 2) + yTabl / 4;
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
        while (this.viva) {
            try {
                //System.out.println("Soy la serpiente: " + this.idSnake + " Mis coordenadas: " + arrayPosiciones.get(0)[0] + " - " + arrayPosiciones.get(0)[1]);
                Thread.sleep(200);
                moverSerpiente();
            } catch (InterruptedException ex) {
                this.viva = false;
                ServerExec.matarSerpiente(this.idSnake);
            }
        }
    }

    public void moverSerpiente() {
        detectarComida();
        try {
            switch (direction) {
                case Snake.UP:
                    if (tablero[arrayPosiciones.get(0)[0] - 1][arrayPosiciones.get(0)[1]] == 0 || tablero[arrayPosiciones.get(0)[0] - 1][arrayPosiciones.get(0)[1]] == -1) {
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
                    } else {
                        this.viva = false;
                        ServerExec.matarSerpiente(this.idSnake);
                    }
                    break;
                case Snake.RIGHT:
                    if (tablero[arrayPosiciones.get(0)[0]][arrayPosiciones.get(0)[1] + 1] == 0 || tablero[arrayPosiciones.get(0)[0]][arrayPosiciones.get(0)[1] + 1] == -1) {
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
                    } else {
                        this.viva = false;
                        ServerExec.matarSerpiente(this.idSnake);
                    }
                    break;
                case Snake.DOWN:
                    if (tablero[arrayPosiciones.get(0)[0] + 1][arrayPosiciones.get(0)[1]] == 0 || tablero[arrayPosiciones.get(0)[0] + 1][arrayPosiciones.get(0)[1]] == -1) {
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
                    } else {
                        this.viva = false;
                        ServerExec.matarSerpiente(this.idSnake);
                    }
                    break;
                case Snake.LEFT:
                    if (tablero[arrayPosiciones.get(0)[0]][arrayPosiciones.get(0)[1] - 1] == 0 || tablero[arrayPosiciones.get(0)[0]][arrayPosiciones.get(0)[1] - 1] == -1) {
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
                    } else {
                        this.viva = false;
                        ServerExec.matarSerpiente(this.idSnake);
                    }
                    break;
            }
        } catch (ArrayIndexOutOfBoundsException | ArrayStoreException exc) {
            this.viva = false;
            ServerExec.matarSerpiente(this.idSnake);
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
        ArrayList<int[]> arrLComidas = ServerExec.getPanelDeJuego().getGeneradorDeComida().getArrLComidas();
        for (int i = 0; i < arrLComidas.size(); i++) {
            if (primeraPosicion[0] == arrLComidas.get(i)[0] && primeraPosicion[1] == arrLComidas.get(i)[1]) {
                nuevaPosicion[0] = x;
                nuevaPosicion[1] = y;
                arrayPosiciones.add(nuevaPosicion);
                posicionABorrar = i;
                break;
            }
        }
        if (posicionABorrar != -1) {
            arrLComidas.remove(posicionABorrar);
        }

    }

    public void setViva(boolean viva) {
        this.viva = viva;
    }
}
