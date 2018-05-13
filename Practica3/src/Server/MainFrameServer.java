package Server;

import javax.swing.JOptionPane;


public class MainFrameServer extends javax.swing.JFrame {

    public MainFrameServer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTamTablero = new javax.swing.JLabel();
        jlAnchoTablero = new javax.swing.JLabel();
        jtfDimTablero = new javax.swing.JTextField();
        jbIniciarServer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(200, 100, 400, 400));

        jlTamTablero.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlTamTablero.setText("Tamaño del tablero de juego:");

        jlAnchoTablero.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlAnchoTablero.setText("Dimensiones:");

        jtfDimTablero.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jbIniciarServer.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jbIniciarServer.setText("Iniciar Servidor");
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
                                .addComponent(jlAnchoTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfDimTablero, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jbIniciarServer)))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTamTablero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAnchoTablero)
                    .addComponent(jtfDimTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbIniciarServer)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbIniciarServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbIniciarServerActionPerformed
        int dim = Integer.parseInt(jtfDimTablero.getText());        
        if (dim >= 20 && dim <= 50) {
            jtfDimTablero.setEnabled(false);
            jbIniciarServer.setEnabled(false);
            ServerExec.iniciarTablero(dim);
        }else{
            JOptionPane.showConfirmDialog(this, "Por favor introduzca unas dimensiones validas (30 - 50)");
        }
        
    }//GEN-LAST:event_jbIniciarServerActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbIniciarServer;
    private javax.swing.JLabel jlAnchoTablero;
    private javax.swing.JLabel jlTamTablero;
    private javax.swing.JTextField jtfDimTablero;
    // End of variables declaration//GEN-END:variables
}
