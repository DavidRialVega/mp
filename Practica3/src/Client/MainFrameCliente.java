package Client;

import Server.Snake;
import Server.GameObservable;
import data.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

public class MainFrameCliente extends javax.swing.JFrame implements Protocolo {

    public static boolean runningApp;
    public JPanel[][] jp;
    private GameObservable gameObservable;

    public MainFrameCliente(GameObservable gameObservable) {
        initComponents();
        this.gameObservable = gameObservable;
//
//        gc = new GenerarComida(jp);
//        snake = new Snake(jp, 15, 15, observer, gc);
//
//        observer.setSnake(snake);
        startButton.setEnabled(false);
        finPartidaButton.setEnabled(true);
        
        upDirection.setEnabled(true);
        rightDirection.setEnabled(true);
        leftDirection.setEnabled(true);
        bottomDirection.setEnabled(true);
        
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                actualiza(e.getKeyCode(), true);
            }

            private void actualiza(int keyCode, boolean pressed) {
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        ClienteExec.getSocketCliente().cambiarDireccion(Snake.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        ClienteExec.getSocketCliente().cambiarDireccion(Snake.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("Izquierdaaaa");
                        ClienteExec.getSocketCliente().cambiarDireccion(Snake.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        ClienteExec.getSocketCliente().cambiarDireccion(Snake.RIGHT);
                        break;
                }
            }
        });
        setFocusable(true);
    }

    public void iniciaTablero(int x, int y) {
        jp = new JPanel[x][y];
        gameScene.setLayout(new GridLayout(x, y, 1, 1));
        gameScene.setSize(new java.awt.Dimension(390, 390));
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                jp[i][j] = new JPanel();
                jp[i][j].setBackground(Color.white);
                gameScene.add(jp[i][j]);
            }
        }
        gameScene.setVisible(true);
        this.setBounds(this.getX(), this.getY() + 10, this.getWidth(), this.getHeight() + 10);
        
    }

    public void iniciarSerpientes(int x, int y) {
        //Snake snake = new Snake(x, y);
        //gameObservable.addSnake(ClienteExec.getIdCliente(), snake);
    }

    public void fin() {
        //JOptionPane.showInternalConfirmDialog(this, "Game Over");
        //MainFrameCliente.runningApp = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameScene = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        xLabel = new javax.swing.JLabel();
        xTextfield = new javax.swing.JTextField();
        yLabel = new javax.swing.JLabel();
        yTextfield = new javax.swing.JTextField();
        finPartidaButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        increaseSpeedButton = new javax.swing.JButton();
        decreaseSpeedButton = new javax.swing.JButton();
        jlNombreUsuario = new javax.swing.JLabel();
        controllsPanel = new javax.swing.JPanel();
        upDirection = new javax.swing.JButton();
        rightDirection = new javax.swing.JButton();
        leftDirection = new javax.swing.JButton();
        bottomDirection = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 650));

        gameScene.setPreferredSize(new java.awt.Dimension(390, 390));
        gameScene.setLayout(new java.awt.GridLayout(39, 39, 1, 1));

        infoPanel.setFocusable(false);

        xLabel.setText("X: ");
        xLabel.setFocusable(false);

        xTextfield.setText("--");
        xTextfield.setEnabled(false);
        xTextfield.setFocusable(false);

        yLabel.setText("Y: ");
        yLabel.setFocusable(false);

        yTextfield.setText("--");
        yTextfield.setEnabled(false);
        yTextfield.setFocusable(false);

        finPartidaButton.setText("Fin Partida");
        finPartidaButton.setEnabled(false);
        finPartidaButton.setFocusable(false);
        finPartidaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finPartidaButtonActionPerformed(evt);
            }
        });

        startButton.setText("Inicio");
        startButton.setFocusable(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        increaseSpeedButton.setText("+");
        increaseSpeedButton.setEnabled(false);
        increaseSpeedButton.setFocusable(false);
        increaseSpeedButton.setPreferredSize(new java.awt.Dimension(45, 45));

        decreaseSpeedButton.setText("-");
        decreaseSpeedButton.setEnabled(false);
        decreaseSpeedButton.setFocusable(false);

        jlNombreUsuario.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlNombreUsuario.setText("Nombre de usuario");
        jlNombreUsuario.setFocusable(false);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(finPartidaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decreaseSpeedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(increaseSpeedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(xLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(yLabel)
                        .addGap(18, 18, 18)
                        .addComponent(yTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addComponent(jlNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jlNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xLabel)
                    .addComponent(xTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yLabel)
                    .addComponent(yTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(finPartidaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(increaseSpeedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(decreaseSpeedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        controllsPanel.setFocusable(false);

        upDirection.setText("↑");
        upDirection.setEnabled(false);
        upDirection.setFocusable(false);

        rightDirection.setText("→");
        rightDirection.setEnabled(false);
        rightDirection.setFocusable(false);

        leftDirection.setText("←");
        leftDirection.setEnabled(false);
        leftDirection.setFocusable(false);

        bottomDirection.setText("↓");
        bottomDirection.setEnabled(false);
        bottomDirection.setFocusable(false);

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
        
        
//        if (startButton.getText() == "Reanudar") {
//            synchronized (snake) {
//                snake.notify();
//            }
//        } else {
//
//            runningApp = true;
//            gc.start();
//            snake.start();
//            startButton.setText("Reanudar");
//
//        }        

    }//GEN-LAST:event_startButtonActionPerformed

    private void finPartidaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finPartidaButtonActionPerformed
//        this.runningApp = false;
//        //SocketCliente.enviar("FIN;");
//     
//        startButton.setEnabled(true);
//        finPartidaButton.setEnabled(false);
//        upDirection.setEnabled(false);
//        rightDirection.setEnabled(false);
//        leftDirection.setEnabled(false);
//        bottomDirection.setEnabled(false);
        ClienteExec.getSocketCliente().enviar(FIN + "");
        ClienteExec.gameOver();
    }//GEN-LAST:event_finPartidaButtonActionPerformed

    public void setTextJlNombreUsuario(String nombreUsuario) {
        this.jlNombreUsuario.setText(nombreUsuario);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottomDirection;
    private javax.swing.JPanel controllsPanel;
    private javax.swing.JButton decreaseSpeedButton;
    private javax.swing.JButton finPartidaButton;
    private javax.swing.JPanel gameScene;
    private javax.swing.JButton increaseSpeedButton;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jlNombreUsuario;
    private javax.swing.JButton leftDirection;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JButton rightDirection;
    private javax.swing.JButton startButton;
    private javax.swing.JButton upDirection;
    private javax.swing.JLabel xLabel;
    private javax.swing.JTextField xTextfield;
    private javax.swing.JLabel yLabel;
    private javax.swing.JTextField yTextfield;
    // End of variables declaration//GEN-END:variables
}
