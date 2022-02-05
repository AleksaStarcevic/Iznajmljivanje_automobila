/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

/**
 *
 * @author aleks
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuAutomobil = new javax.swing.JMenu();
        itemDodajAutomobil = new javax.swing.JMenuItem();
        itemPretraziAutomobil = new javax.swing.JMenuItem();
        menuVozac = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuPotvrda = new javax.swing.JMenu();
        itemPotvrda = new javax.swing.JMenuItem();
        itemPrikaz = new javax.swing.JMenuItem();
        itemTabelaPotvrda = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuAutomobil.setText("Automobil");

        itemDodajAutomobil.setText("Dodaj novi");
        itemDodajAutomobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDodajAutomobilActionPerformed(evt);
            }
        });
        menuAutomobil.add(itemDodajAutomobil);

        itemPretraziAutomobil.setText("Pretrazi automobil");
        itemPretraziAutomobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPretraziAutomobilActionPerformed(evt);
            }
        });
        menuAutomobil.add(itemPretraziAutomobil);

        jMenuBar1.add(menuAutomobil);

        menuVozac.setText("Vozac");

        jMenuItem1.setText("Dodaj novog vozaca");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuVozac.add(jMenuItem1);

        jMenuItem2.setText("Pretrazi vozaca");
        menuVozac.add(jMenuItem2);

        jMenuBar1.add(menuVozac);

        menuPotvrda.setText("Potvrda");

        itemPotvrda.setText("Dodaj novu");
        itemPotvrda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPotvrdaActionPerformed(evt);
            }
        });
        menuPotvrda.add(itemPotvrda);

        itemPrikaz.setText("Prikaz");
        itemPrikaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPrikazActionPerformed(evt);
            }
        });
        menuPotvrda.add(itemPrikaz);

        itemTabelaPotvrda.setText("Tabela potvrda");
        itemTabelaPotvrda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTabelaPotvrdaActionPerformed(evt);
            }
        });
        menuPotvrda.add(itemTabelaPotvrda);

        jMenuItem6.setText("Pretrazi potvrdu");
        menuPotvrda.add(jMenuItem6);

        jMenuBar1.add(menuPotvrda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemPotvrdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPotvrdaActionPerformed
        new UnosPotvrde().setVisible(true);
    }//GEN-LAST:event_itemPotvrdaActionPerformed

    private void itemPrikazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPrikazActionPerformed
       new PrikazPotvrda(this, true).setVisible(true);
    }//GEN-LAST:event_itemPrikazActionPerformed

    private void itemTabelaPotvrdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTabelaPotvrdaActionPerformed
        new FrmPotvrdaTM(this, true).setVisible(true);
    }//GEN-LAST:event_itemTabelaPotvrdaActionPerformed

    private void itemDodajAutomobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDodajAutomobilActionPerformed
      new UnosAutomobila(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_itemDodajAutomobilActionPerformed

    private void itemPretraziAutomobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPretraziAutomobilActionPerformed
       new PretragaAutomobila().setVisible(true);
    }//GEN-LAST:event_itemPretraziAutomobilActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       new UnosVozaca().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemDodajAutomobil;
    private javax.swing.JMenuItem itemPotvrda;
    private javax.swing.JMenuItem itemPretraziAutomobil;
    private javax.swing.JMenuItem itemPrikaz;
    private javax.swing.JMenuItem itemTabelaPotvrda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu menuAutomobil;
    private javax.swing.JMenu menuPotvrda;
    private javax.swing.JMenu menuVozac;
    // End of variables declaration//GEN-END:variables
}