package Server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class GameObservable extends Observable {

    private int selectedColor;
    private String color;
    private HashMap<Integer, Snake> snakes;
    int i=0;
    public GameObservable() {
        snakes = new HashMap<>();
    }

//    public void startLabel() {
//        //snake.update(this,1);
//        setChanged();
//        notifyObservers();
//    }

    public void setDireccion(int direction) {
        //snake.setDirection(direction);
    }

    public void updatear() {
     
        setChanged();
        notifyObservers();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
    }

    public int getSelectedColor() {
        return this.selectedColor;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setSnake(Snake snake) {
        // this.snake = snake;
    }

    public void addSnake(int idJugador, Snake snake) {
        snakes.put(idJugador, snake);
    }

    public void empezarPartida() {
        snakes.forEach((k, v) -> v.start());
    }
    
    public void startSnake(int idSnake){
        snakes.get(idSnake).start();
    }

    public void cambiarDireccionSnake(int idSnake, int direccion) {
        snakes.get(idSnake).setDirection(direccion);
    }

    public int tamSnake(int idCliente) {
        return this.snakes.get(idCliente).arrayPosiciones.size();
    }
    
    public void borrarSerpiente(int idSnake){
        snakes.remove(idSnake);
    }

    public HashMap<Integer, Snake> getSnakes() {
        return snakes;
    }
    
    public Snake getSnake(int idSnake){
        return snakes.get(idSnake);
    }
}
