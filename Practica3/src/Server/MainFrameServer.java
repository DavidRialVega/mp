package Server;


public class MainFrameServer extends javax.swing.JFrame {

    public MainFrameServer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTamTablero = new javax.swing.JLabel();
        jlAnchoTablero = new javax.swing.JLabel();
        jtfAnchoTablero = new javax.swing.JTextField();
        jlAltoTablero = new javax.swing.JLabel();
        jtfAltoTablero = new javax.swing.JTextField();
        jbIniciarServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(200, 100, 400, 400));

        jlTamTablero.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTamTablero.setText("Tamaño del tablero de juego:");

        jlAnchoTablero.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlAnchoTablero.setText("Ancho (x): ");

        jtfAnchoTablero.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jlAltoTablero.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlAltoTablero.setText("Alto (y):");

        jtfAltoTablero.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jbIniciarServer.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jbIniciarServer.setText("Iniciar Servidor");
        jbIniciarServer.setActionCommand("Iniciar Servidor");
        jbIniciarServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbIniciarServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTamTablero)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlAnchoTablero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfAnchoTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlAltoTablero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfAltoTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jbIniciarServer)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTamTablero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAnchoTablero)
                    .addComponent(jtfAnchoTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlAltoTablero)
                    .addComponent(jtfAltoTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbIniciarServer)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbIniciarServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarServerActionPerformed
        int x = Integer.parseInt(jtfAnchoTablero.getText());
        int y = Integer.parseInt(jtfAltoTablero.getText());
        jtfAltoTablero.setEnabled(false);
        jtfAnchoTablero.setEnabled(false);
        jbIniciarServer.setEnabled(false);
        ServerExec.iniciarTablero(x, y);
    }//GEN-LAST:event_jbIniciarServerActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbIniciarServer;
    private javax.swing.JLabel jlAltoTablero;
    private javax.swing.JLabel jlAnchoTablero;
    private javax.swing.JLabel jlTamTablero;
    private javax.swing.JTextField jtfAltoTablero;
    private javax.swing.JTextField jtfAnchoTablero;
    // End of variables declaration//GEN-END:variables
}
