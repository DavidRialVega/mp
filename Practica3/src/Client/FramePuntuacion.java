/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Server.ServerExec;
import Server.GameObservable;
import java.awt.Color;
import java.util.ArrayList;
import static javafx.application.Platform.exit;
import javax.swing.JLabel;

/**
 *
 * @author juanma
 */
public class FramePuntuacion extends javax.swing.JFrame {

    /**
     * Creates new form FramePuntuacion
     */
    private GameObservable gameObservable;
    ArrayList<JLabel> label = new ArrayList<JLabel>();
    private static JLabel jlabelId;
    private static JLabel jLabelPuntuacion;

    public FramePuntuacion(GameObservable gameObservable) {
        initComponents();
        this.gameObservable = gameObservable;
        this.setLocation(650, 0);
        this.setSize(500, 500);

    }

    public void actualizar(String panelPuntuacion) {
        // this.removeAll();
        String fila[] = panelPuntuacion.split(":");
        for (int i = 0; i < fila.length; i++) {
            String columna[] = fila[i].split("_");
            jlabelId = new JLabel("jlabelId" + i);
            jlabelId.setText(columna[0]);
            jlabelId.setBounds(10, 30 + 30 * i, 40, 40);
            jlabelId.setBackground(ClienteExec.getHashMapColores().get(i+1));
            jlabelId.setOpaque(true);
            label.add(jlabelId);

            jLabelPuntuacion = new JLabel("jLabelPuntuacion" + i);
            jLabelPuntuacion.setText(columna[1]);
            jLabelPuntuacion.setBounds(300, 30 + 30 * i, 40, 40);
            jLabelPuntuacion.setBackground(ClienteExec.getHashMapColores().get(i+1));
            jLabelPuntuacion.setOpaque(true);
            label.add(jLabelPuntuacion);
        }

        for (JLabel j : label) {
            // this.jPanelChulo.remove(j);
            this.jPanelChulo.add(j);

        }
        //this.add(jPanelChulo);
        jlabelId.repaint();
        jLabelPuntuacion.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelChulo = new javax.swing.JPanel();
        jButtonCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Jugador");

        jLabel2.setText("Puntuacion");

        javax.swing.GroupLayout jPanelChuloLayout = new javax.swing.GroupLayout(jPanelChulo);
        jPanelChulo.setLayout(jPanelChuloLayout);
        jPanelChuloLayout.setHorizontalGroup(
            jPanelChuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChuloLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jButtonCerrar)
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(jPanelChuloLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(78, 78, 78))
        );
        jPanelChuloLayout.setVerticalGroup(
            jPanelChuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelChuloLayout.createSequentialGroup()
                .addGroup(jPanelChuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(jButtonCerrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelChulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelChulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanelChulo;
    // End of variables declaration//GEN-END:variables
}
