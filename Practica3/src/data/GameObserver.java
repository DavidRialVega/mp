package data;

import java.util.Observable;

public class GameObserver extends Observable{
    private int selectedColor;
    private String color;
    Snake snake;
    
    public GameObserver() {
        //this.snake = snake;
    }
    
    public void startLabel() {
        snake.update(this,1);
        setChanged();
        notifyObservers();
    }
    
    public void setDireccion(int direction) {
        snake.setDirection(direction);
    }
    
    public void updatear() {
        snake.moveLabel();
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
        this.snake = snake;
    }
}
