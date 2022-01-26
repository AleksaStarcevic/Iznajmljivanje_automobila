/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import controller.Kontroler;
import domen.Automobil;
import domen.TipAutomobila;
import exception.ValidacijaException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aleks
 */
public class UnosAutomobila extends javax.swing.JFrame {

    /**
     * Creates new form UnosAutomobila
     */
    public UnosAutomobila() {
        initComponents();
        popuniComboTipova();
        lblErrorRegBroj.setVisible(false);
        lblErrorMarka.setVisible(false);
        lblErrorModel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRegistarskiBroj = new javax.swing.JLabel();
        lblMarka = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        cmbTip = new javax.swing.JComboBox();
        lblTip = new javax.swing.JLabel();
        txtRegistarskiBroj = new javax.swing.JTextField();
        txtMarka = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        lblErrorRegBroj = new javax.swing.JLabel();
        lblErrorMarka = new javax.swing.JLabel();
        lblErrorModel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRegistarskiBroj.setText("Registarski broj:");

        lblMarka.setText("Marka:");

        lblModel.setText("Model:");

        cmbTip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblTip.setText("Tip:");

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        lblErrorRegBroj.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorRegBroj.setText("jLabel1");

        lblErrorMarka.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMarka.setText("jLabel2");

        lblErrorModel.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorModel.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErrorModel)
                    .addComponent(lblErrorRegBroj)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblRegistarskiBroj)
                                .addComponent(lblMarka, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblModel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTip, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(lblErrorMarka))
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRegistarskiBroj)
                            .addComponent(txtMarka)
                            .addComponent(txtModel)
                            .addComponent(cmbTip, 0, 102, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistarskiBroj)
                    .addComponent(txtRegistarskiBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorRegBroj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarka)
                    .addComponent(txtMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorMarka)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModel)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(lblErrorModel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTip))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        
        try {
            String regBroj = txtRegistarskiBroj.getText();
            String marka = txtMarka.getText();
            String model = txtModel.getText();
            
           if(validacija(regBroj, marka, model)){
               return;
           }
            
            TipAutomobila tip = (TipAutomobila) cmbTip.getSelectedItem();
            Automobil auto = new Automobil(regBroj, model, marka, tip);

            Kontroler.getInstanca().dodajAutomobil(auto);
            JOptionPane.showMessageDialog(this, "Automobil je uspesno sacuvan!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Neuspesan unos automobila!\n" + ex.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnSacuvajActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(UnosAutomobila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UnosAutomobila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UnosAutomobila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UnosAutomobila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UnosAutomobila().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbTip;
    private javax.swing.JLabel lblErrorMarka;
    private javax.swing.JLabel lblErrorModel;
    private javax.swing.JLabel lblErrorRegBroj;
    private javax.swing.JLabel lblMarka;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblRegistarskiBroj;
    private javax.swing.JLabel lblTip;
    private javax.swing.JTextField txtMarka;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtRegistarskiBroj;
    // End of variables declaration//GEN-END:variables

    private void popuniComboTipova() {
        try {
            ArrayList<TipAutomobila> tipovi = (ArrayList<TipAutomobila>) Kontroler.getInstanca().getStorageTipovi();
            cmbTip.removeAllItems();
            for (TipAutomobila tipAutomobila : tipovi) {
                cmbTip.addItem(tipAutomobila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UnosAutomobila.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean validacija(String regBroj, String marka, String model) {
        lblErrorMarka.setVisible(false);
        lblErrorRegBroj.setVisible(false);
         lblErrorModel.setVisible(false);
        boolean prazno = false;
        if(regBroj.isEmpty()){
            prazno = true;
            lblErrorRegBroj.setVisible(true);
            lblErrorRegBroj.setText("Registracioni broj je obavezno polje");
        }
        
          if(marka.isEmpty()){
              prazno = true;
            lblErrorMarka.setVisible(true);
            lblErrorMarka.setText("Marka ne sme biti prazno polje");
        }
          
          if(model.isEmpty()){
              prazno = true;
            lblErrorModel.setVisible(true);
            lblErrorModel.setText("Model ne sme biti prazno polje");
        }
          return prazno;
    }

   
}
