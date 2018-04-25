/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author DavidR
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameObserver observer = new GameObserver();
        MainFrame mf = new MainFrame(observer);
        mf.setVisible(true);
    }
    
}
