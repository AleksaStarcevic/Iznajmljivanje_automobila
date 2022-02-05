/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import controller.Kontroler;
import domen.Automobil;
import domen.TipAutomobila;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aleks
 */
public class IzmenaAutomobila extends javax.swing.JDialog {
Automobil pretrazenAuto;
    /**
     * Creates new form NewJDialog
     */
    public IzmenaAutomobila(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        txtRegistarskiBroj = new javax.swing.JTextField();
        lblErrorRegBroj = new javax.swing.JLabel();
        lblMarka = new javax.swing.JLabel();
        lblErrorMarka = new javax.swing.JLabel();
        txtMarka = new javax.swing.JTextField();
        lblModel = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        lblErrorModel = new javax.swing.JLabel();
        lblTip = new javax.swing.JLabel();
        cmbTip = new javax.swing.JComboBox();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblRegistarskiBroj.setText("Registarski broj:");

        txtRegistarskiBroj.setEditable(false);

        lblErrorRegBroj.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorRegBroj.setText("jLabel1");

        lblMarka.setText("Marka:");

        lblErrorMarka.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorMarka.setText("jLabel2");

        lblModel.setText("Model:");

        lblErrorModel.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorModel.setText("jLabel3");

        lblTip.setText("Tip:");

        cmbTip.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnIzmeni.setText("Izmeni");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblErrorRegBroj)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblErrorMarka)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTip)
                                .addGap(125, 125, 125)
                                .addComponent(cmbTip, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblRegistarskiBroj)
                                .addGap(55, 55, 55)
                                .addComponent(txtRegistarskiBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMarka)
                                .addGap(109, 109, 109)
                                .addComponent(txtMarka))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblErrorModel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblModel)
                                .addGap(109, 109, 109)
                                .addComponent(txtModel)))
                        .addGap(105, 105, 105))))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRegistarskiBroj)
                    .addComponent(txtRegistarskiBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorRegBroj)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMarka))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorMarka)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblModel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorModel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTip)
                    .addComponent(cmbTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        try {
            String regBroj = txtRegistarskiBroj.getText();
            String marka = txtMarka.getText();
            String model = txtModel.getText();

            if(validacija(regBroj, marka, model)){
                return;
            }

            TipAutomobila tip = (TipAutomobila) cmbTip.getSelectedItem();
            Automobil auto = new Automobil(regBroj, model, marka, tip);

            Kontroler.getInstanca().izmeniAutomobil(auto);
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

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
            java.util.logging.Logger.getLogger(IzmenaAutomobila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IzmenaAutomobila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IzmenaAutomobila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IzmenaAutomobila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IzmenaAutomobila dialog = new IzmenaAutomobila(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
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
            Logger.getLogger(UnosAutomobilaZaBrisanje.class.getName()).log(Level.SEVERE, null, ex);
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

    void setPretrazenAuto(Automobil pretrazenAuto) {
      this.pretrazenAuto = pretrazenAuto;
      txtRegistarskiBroj.setText(pretrazenAuto.getRegistracioniBroj());
      txtMarka.setText(pretrazenAuto.getMarka());
      txtModel.setText(pretrazenAuto.getModel());
      cmbTip.setSelectedItem(pretrazenAuto.getTip());
              
    }



}