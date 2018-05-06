package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class GameObservable extends Observable{
    private int selectedColor;
    private String color;
    private HashMap<Integer,Snake> snakes;    
    
    public GameObservable() {
        snakes = new HashMap<>();
    }
    
    public void startLabel() {
        //snake.update(this,1);
        setChanged();
        notifyObservers();
    }
    
    public void setDireccion(int direction) {
        //snake.setDirection(direction);
    }
    
    public void updatear() {
        //snake.moveLabel();
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
    
    public void addSnake(int idJugador, Snake snake){
        snakes.put(idJugador, snake);
    }

    public void empezarPartida() {                
        snakes.forEach((k,v) -> v.start());
        //snakes.forEach((k,v) -> System.out.println("Haaala"));
    }
}
