package Client;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JOptionPane;

public class VentanaInicialCliente extends javax.swing.JFrame {

    public VentanaInicialCliente() {
        initComponents();
    }

    private Color cambiarColor() {
        int r, g, b;
        r = SliderRed.getValue();
        g = SliderGreen.getValue();
        b = SliderBlue.getValue();

        return new Color(r, g, b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitleSnake = new javax.swing.JLabel();
        jlUsuario = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jlDirIp = new javax.swing.JLabel();
        jtfDirIp = new javax.swing.JTextField();
        jlPuerto = new javax.swing.JLabel();
        jtfPuerto = new javax.swing.JTextField();
        jbAceptar = new javax.swing.JButton();
        SliderRed = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ColorPanel = new javax.swing.JPanel();
        SliderBlue = new javax.swing.JSlider();
        SliderGreen = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(300, 200, 600, 400));
        setPreferredSize(new java.awt.Dimension(676, 460));
        setSize(new java.awt.Dimension(600, 400));

        jlTitleSnake.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jlTitleSnake.setText("SNAKE");

        jlUsuario.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlUsuario.setText("Usuario: ");

        jtfUsuario.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jlDirIp.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlDirIp.setText("Dirección IP:");

        jtfDirIp.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jlPuerto.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jlPuerto.setText("Puerto: ");

        jtfPuerto.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N

        jbAceptar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jbAceptar.setText("Aceptar");
        jbAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAceptarActionPerformed(evt);
            }
        });

        SliderRed.setMajorTickSpacing(50);
        SliderRed.setMaximum(255);
        SliderRed.setPaintLabels(true);
        SliderRed.setSnapToTicks(true);
        SliderRed.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderRedStateChanged(evt);
            }
        });

        jLabel1.setText("RED");

        jLabel2.setText("GREEN");

        jLabel3.setText("BLUE");

        javax.swing.GroupLayout ColorPanelLayout = new javax.swing.GroupLayout(ColorPanel);
        ColorPanel.setLayout(ColorPanelLayout);
        ColorPanelLayout.setHorizontalGroup(
            ColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        ColorPanelLayout.setVerticalGroup(
            ColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        SliderBlue.setMajorTickSpacing(50);
        SliderBlue.setMaximum(255);
        SliderBlue.setPaintLabels(true);
        SliderBlue.setSnapToTicks(true);
        SliderBlue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderBlueStateChanged(evt);
            }
        });

        SliderGreen.setMajorTickSpacing(50);
        SliderGreen.setMaximum(255);
        SliderGreen.setPaintLabels(true);
        SliderGreen.setSnapToTicks(true);
        SliderGreen.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SliderGreenStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlDirIp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfDirIp, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlPuerto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfPuerto))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jlTitleSnake)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SliderRed, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SliderBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(SliderGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(ColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(523, Short.MAX_VALUE)
                .addComponent(jbAceptar)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitleSnake, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlUsuario))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDirIp)
                    .addComponent(jtfDirIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPuerto)
                    .addComponent(jtfPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SliderRed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SliderGreen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SliderBlue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(ColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAceptarActionPerformed
        try {
            ClienteExec.setIpServidor(jtfDirIp.getText());
            ClienteExec.setPuertoServidor(Integer.parseInt(jtfPuerto.getText()));
            ClienteExec.setNombreUsuario(jtfUsuario.getText());
            ClienteExec.setPuntos("0");
            ClienteExec.intentaLogin();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Por favor Introduzca los datos correctamente");
        }

    }//GEN-LAST:event_jbAceptarActionPerformed

    private void SliderRedStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderRedStateChanged
        ColorPanel.setBackground(cambiarColor());
    }//GEN-LAST:event_SliderRedStateChanged

    private void SliderGreenStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderGreenStateChanged
        ColorPanel.setBackground(cambiarColor());
    }//GEN-LAST:event_SliderGreenStateChanged

    private void SliderBlueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SliderBlueStateChanged
        ColorPanel.setBackground(cambiarColor());
    }//GEN-LAST:event_SliderBlueStateChanged

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicialCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicialCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ColorPanel;
    private javax.swing.JSlider SliderBlue;
    private javax.swing.JSlider SliderGreen;
    private javax.swing.JSlider SliderRed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jbAceptar;
    private javax.swing.JLabel jlDirIp;
    private javax.swing.JLabel jlPuerto;
    private javax.swing.JLabel jlTitleSnake;
    private javax.swing.JLabel jlUsuario;
    private javax.swing.JTextField jtfDirIp;
    private javax.swing.JTextField jtfPuerto;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
