package data;

import Client.SocketCliente;
import Server.JugadorServer;
import Server.ServerExec;
import static data.Protocolo.DIR;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends javax.swing.JFrame implements Protocolo {
    
    public static boolean runningApp;
    private GameObservable observer;
    private Snake snake;
    GenerarComida gc;
    public static int numeroClientes = 0;
    
    public MainFrame(GameObservable observer) {
        initComponents();
        JPanel[][] jp = new JPanel[39][39];
        this.observer = observer;
        for (int i = 0; i < 39; i++) {
            for (int j = 0; j < 39; j++) {
                jp[i][j] = new JPanel();
                jp[i][j].setBackground(Color.white);
                gameScene.add(jp[i][j]);
            }
        }

        snake = new Snake(jp, 15, 15, observer, gc);
        
        observer.setSnake(snake);
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                actualiza(e.getKeyCode(), true);
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
        });
        setFocusable(true);
        
    }
    
    public void fin() {
        JOptionPane.showInternalConfirmDialog(this, "Game Over");
        MainFrame.runningApp = false;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameScene = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        playerNameEditable = new javax.swing.JTextField();
        playerLabel = new javax.swing.JLabel();
        playerName = new javax.swing.JTextField();
        xLabel = new javax.swing.JLabel();
        xTextfield = new javax.swing.JTextField();
        yLabel = new javax.swing.JLabel();
        yTextfield = new javax.swing.JTextField();
        pauseButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        increaseSpeedButton = new javax.swing.JButton();
        decreaseSpeedButton = new javax.swing.JButton();
        controllsPanel = new javax.swing.JPanel();
        upDirection = new javax.swing.JButton();
        rightDirection = new javax.swing.JButton();
        leftDirection = new javax.swing.JButton();
        bottomDirection = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 650));
        setSize(new java.awt.Dimension(600, 650));

        gameScene.setPreferredSize(new java.awt.Dimension(390, 390));
        gameScene.setLayout(new java.awt.GridLayout(39, 39, 1, 1));

        playerNameEditable.setText("Introduce el nombre de jugador");

        playerLabel.setText("Jugador: ");

        playerName.setText("Nombre");
        playerName.setEnabled(false);

        xLabel.setText("X: ");

        xTextfield.setText("--");
        xTextfield.setEnabled(false);

        yLabel.setText("Y: ");

        yTextfield.setText("--");
        yTextfield.setEnabled(false);

        pauseButton.setText("Pausar");
        pauseButton.setEnabled(false);
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        startButton.setText("Inicio");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        increaseSpeedButton.setText("+");
        increaseSpeedButton.setEnabled(false);
        increaseSpeedButton.setPreferredSize(new java.awt.Dimension(45, 45));

        decreaseSpeedButton.setText("-");
        decreaseSpeedButton.setEnabled(false);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerNameEditable)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(playerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playerName))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(xLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(yLabel)
                        .addGap(18, 18, 18)
                        .addComponent(yTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(pauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decreaseSpeedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(increaseSpeedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerNameEditable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerLabel)
                    .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xLabel)
                    .addComponent(xTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yLabel)
                    .addComponent(yTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pauseButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(increaseSpeedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(decreaseSpeedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        upDirection.setText("↑");
        upDirection.setEnabled(false);

        rightDirection.setText("→");
        rightDirection.setEnabled(false);

        leftDirection.setText("←");
        leftDirection.setEnabled(false);

        bottomDirection.setText("↓");
        bottomDirection.setEnabled(false);

        javax.swing.GroupLayout controllsPanelLayout = new javax.swing.GroupLayout(controllsPanel);
        controllsPanel.setLayout(controllsPanelLayout);
        controllsPanelLayout.setHorizontalGroup(
            controllsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controllsPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(leftDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(rightDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controllsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controllsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controllsPanelLayout.createSequentialGroup()
                        .addComponent(bottomDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controllsPanelLayout.createSequentialGroup()
                        .addComponent(upDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))))
        );
        controllsPanelLayout.setVerticalGroup(
            controllsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controllsPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(upDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controllsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(bottomDirection, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controllsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(controllsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gameScene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gameScene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        //startButton.setEnabled(false);
        if (startButton.getText() == "Reanudar") {
            synchronized (snake) {
                snake.notify();
            }
        } else {
            try {
                if (ServerExec.comprobarJugadoresActivos() >= 2) {
                    System.out.println("holaaaaaaaaaaaa");
                    this.startButton.setEnabled(true);
                    runningApp = true;
                    gc.start();
                    snake.start();
                    startButton.setText("Reanudar");
                }
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        pauseButton.setEnabled(true);
        startButton.setEnabled(false);
        upDirection.setEnabled(true);
        rightDirection.setEnabled(true);
        leftDirection.setEnabled(true);
        bottomDirection.setEnabled(true);

    }//GEN-LAST:event_startButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        snake.setPause(true);
        startButton.setEnabled(true);
        pauseButton.setEnabled(false);
        upDirection.setEnabled(false);
        rightDirection.setEnabled(false);
        leftDirection.setEnabled(false);
        bottomDirection.setEnabled(false);
    }//GEN-LAST:event_pauseButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottomDirection;
    private javax.swing.JPanel controllsPanel;
    private javax.swing.JButton decreaseSpeedButton;
    private javax.swing.JPanel gameScene;
    private javax.swing.JButton increaseSpeedButton;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JButton leftDirection;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JButton pauseButton;
    private javax.swing.JLabel playerLabel;
    private javax.swing.JTextField playerName;
    private javax.swing.JTextField playerNameEditable;
    private javax.swing.JButton rightDirection;
    private javax.swing.JButton startButton;
    private javax.swing.JButton upDirection;
    private javax.swing.JLabel xLabel;
    private javax.swing.JTextField xTextfield;
    private javax.swing.JLabel yLabel;
    private javax.swing.JTextField yTextfield;
    // End of variables declaration//GEN-END:variables
}
