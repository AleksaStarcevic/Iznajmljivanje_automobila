/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma;

import kontroler.Kontroler;
import domen.Automobil;
import domen.Korisnik;
import domen.PotvrdaOIznajmljivanju;
import domen.TerminVoznje;
import domen.Vozac;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tabele.TableModelTermini;


/**
 *
 * @author aleks
 */
public class IzmenaPotvrde extends javax.swing.JDialog {

    PotvrdaOIznajmljivanju potvrdaPretrazena;
    private ArrayList<TerminVoznje> termini;
    private TableModelTermini modelTermini;
    private Date datumOd;
    private Date datumDo;
    private int potvrdaId;

    /**
     * Creates new form IzmenaPotvrde
     */
    public IzmenaPotvrde(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
         this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        prepareView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbVozac = new javax.swing.JComboBox();
        txtCena = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        lblErrorID = new javax.swing.JLabel();
        lblErrorDatumOd = new javax.swing.JLabel();
        lblErrorDatumDo = new javax.swing.JLabel();
        lblErrorCena = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        cmbRegistracioniBroj = new javax.swing.JComboBox();
        datumOD = new com.toedter.calendar.JDateChooser();
        datumDO = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dan = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        cmbVreme = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTermini = new javax.swing.JTable();
        btnDodajTermin = new javax.swing.JButton();
        btnObrisiTermin = new javax.swing.JButton();
        lblErrorDan = new javax.swing.JLabel();
        btnPotvrdi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbVozac.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbVozac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVozacActionPerformed(evt);
            }
        });

        txtCena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCenaActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        lblErrorID.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorID.setText("jLabel7");

        lblErrorDatumOd.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorDatumOd.setText("jLabel8");

        lblErrorDatumDo.setForeground(new java.awt.Color(255, 51, 51));
        lblErrorDatumDo.setText("jLabel9");

        lblErrorCena.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorCena.setText("jLabel10");

        jLabel1.setText("ID:");

        jLabel2.setText("Registracioni broj:");

        jLabel3.setText("Vozac:");

        jLabel4.setText("Datum od:");

        jLabel5.setText("Datum do:");

        jLabel6.setText("Cena:");

        cmbRegistracioniBroj.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos termina voznje"));

        jLabel8.setText("Dan voznje: ");

        jLabel9.setText("Vreme:");

        cmbVreme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tblTermini.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblTermini);

        btnDodajTermin.setText("Dodaj");
        btnDodajTermin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajTerminActionPerformed(evt);
            }
        });

        btnObrisiTermin.setText("Obrisi");
        btnObrisiTermin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiTerminActionPerformed(evt);
            }
        });

        lblErrorDan.setForeground(new java.awt.Color(255, 0, 0));
        lblErrorDan.setText("jLabel10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDodajTermin)
                    .addComponent(btnObrisiTermin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(dan, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblErrorDan))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbVreme, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbVreme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(btnDodajTermin)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisiTermin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblErrorDan)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPotvrdi.setText("Potvrdi");
        btnPotvrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotvrdiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 135, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(datumDO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(datumOD, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cmbRegistracioniBroj, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbVozac, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(155, 155, 155))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblErrorCena)
                        .addGap(167, 167, 167)
                        .addComponent(btnPotvrdi)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrorDatumDo, javax.swing.GroupLayout.Alignment.LEADING))
                        .addComponent(jLabel1)
                        .addComponent(lblErrorID)
                        .addComponent(lblErrorDatumOd))
                    .addContainerGap(505, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbRegistracioniBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cmbVozac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(datumOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(datumDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblErrorCena))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPotvrdi)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblErrorID, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel2)
                    .addGap(16, 16, 16)
                    .addComponent(jLabel3)
                    .addGap(55, 55, 55)
                    .addComponent(lblErrorDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel5)
                    .addGap(10, 10, 10)
                    .addComponent(lblErrorDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(419, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCenaActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        if (validacija()) {
            return;
        }

        int id = Integer.parseInt(txtID.getText());
        Automobil auto = (Automobil) cmbRegistracioniBroj.getSelectedItem();
        Vozac vozac = (Vozac) cmbVozac.getSelectedItem();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date datumOd = datumOD.getDate();
        Date datumDo = datumDO.getDate();
        double cena = Double.parseDouble(txtCena.getText());

        try {
            Korisnik korisnik = Kontroler.getInstanca().getUlogovaniKorisnik();
              termini = modelTermini.getTermini();
            PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju(id, datumOd, datumDo, cena, auto, vozac, korisnik,termini);
            Kontroler.getInstanca().izmeniPotvrdu(potvrda);
            JOptionPane.showMessageDialog(this, "Potvrda je uspesno izmenjena!");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "Neuspesna izmena potvrde!\n" + e.getMessage(), "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnDodajTerminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajTerminActionPerformed

        Date danDatum = dan.getDate();
        String v = (String) cmbVreme.getSelectedItem();
        TerminVoznje termin = new TerminVoznje();
        PotvrdaOIznajmljivanju potvrdaOIznajmljivanju = new PotvrdaOIznajmljivanju();
        potvrdaOIznajmljivanju.setPotvrdaID(potvrdaId);
        termin.setPotvrda(potvrdaOIznajmljivanju);
        termin.setDan(danDatum);
        termin.setVreme(v);

        if (modelTermini.getTermini().contains(termin)) {
            JOptionPane.showMessageDialog(this, "Ne mogu se uneti termini sa istim datumom i vremenom!");
            return;
        }

        modelTermini.dodajTermin(termin);
    }//GEN-LAST:event_btnDodajTerminActionPerformed

    private void btnObrisiTerminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiTerminActionPerformed
        int selektovanRed = tblTermini.getSelectedRow();
        if (selektovanRed != -1) {
            modelTermini.obrisiElement(selektovanRed);

        } else {
            JOptionPane.showMessageDialog(this, "Red mora biti selektovan!");
        }
    }//GEN-LAST:event_btnObrisiTerminActionPerformed

    private void btnPotvrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotvrdiActionPerformed
        if (validacija()) {
            return;
        }
        datumOd = datumOD.getDate();
        datumDo = datumDO.getDate();
        potvrdaId = Integer.parseInt(txtID.getText());

        dan.setMinSelectableDate(datumOd);
        dan.setMaxSelectableDate(datumDo);
    }//GEN-LAST:event_btnPotvrdiActionPerformed

    private void cmbVozacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVozacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVozacActionPerformed

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajTermin;
    private javax.swing.JButton btnObrisiTermin;
    private javax.swing.JButton btnPotvrdi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbRegistracioniBroj;
    private javax.swing.JComboBox cmbVozac;
    private javax.swing.JComboBox<String> cmbVreme;
    private com.toedter.calendar.JDateChooser dan;
    private com.toedter.calendar.JDateChooser datumDO;
    private com.toedter.calendar.JDateChooser datumOD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblErrorCena;
    private javax.swing.JLabel lblErrorDan;
    private javax.swing.JLabel lblErrorDatumDo;
    private javax.swing.JLabel lblErrorDatumOd;
    private javax.swing.JLabel lblErrorID;
    private javax.swing.JTable tblTermini;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables

    void setPotvrda(PotvrdaOIznajmljivanju potvrdaPretrazena) {
        this.potvrdaPretrazena = potvrdaPretrazena;
        txtID.setEnabled(false);
        txtID.setText(String.valueOf(potvrdaPretrazena.getPotvrdaID()));
        txtCena.setText(String.valueOf(potvrdaPretrazena.getCena()));
        System.out.println(potvrdaPretrazena.getDatumOD() + "");
        datumOD.setDate(potvrdaPretrazena.getDatumOD());
        datumDO.setDate(potvrdaPretrazena.getDatumDO());
        
        popuniTermine();
    }

    private void prepareView() {
        try {
            lblErrorDan.setVisible(false);
            lblErrorID.setVisible(false);
            lblErrorCena.setVisible(false);
            lblErrorDatumDo.setVisible(false);
            lblErrorDatumOd.setVisible(false);
            popuniCmbAutomobili();
            popuniCmbVozaci();
            popuniCmbVreme();

        } catch (SQLException ex) {
            Logger.getLogger(UnosPotvrde.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void popuniCmbAutomobili() throws SQLException {
        cmbRegistracioniBroj.removeAllItems();
        List<Automobil> autombili;
        try {
            autombili = Kontroler.getInstanca().getStorageAutomobili();
            for (Automobil automobil : autombili) {
                cmbRegistracioniBroj.addItem(automobil);

            }
        } catch (Exception ex) {
            Logger.getLogger(IzmenaPotvrde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void popuniCmbVozaci() throws SQLException {
        cmbVozac.removeAllItems();
        List<Vozac> vozaci;
        try {
            vozaci = Kontroler.getInstanca().getStorageVozac();
            for (Vozac vozac : vozaci) {
                cmbVozac.addItem(vozac);

            }
        } catch (Exception ex) {
            Logger.getLogger(IzmenaPotvrde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean validacija() {
        lblErrorID.setVisible(false);
        lblErrorCena.setVisible(false);
        lblErrorDatumDo.setVisible(false);
        lblErrorDatumOd.setVisible(false);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        boolean prazno = false;
        if (txtID.getText().isEmpty()) {
            lblErrorID.setText("ID je obavezan!");
            lblErrorID.setVisible(true);
            prazno = true;
        }

        if (txtCena.getText().isEmpty()) {
            lblErrorCena.setText("Cena je obavezano polje!");
            lblErrorCena.setVisible(true);
            prazno = true;
        } else if (Double.parseDouble(txtCena.getText()) <= 0) {
            lblErrorCena.setText("Cena ne sme biti manja od 0!");
            lblErrorCena.setVisible(true);
            prazno = true;
        }

        if (datumOD.getDate().before(new Date())) {
            lblErrorDatumOd.setText("Datum mora biti tekuci!");
            lblErrorDatumOd.setVisible(true);
            prazno = true;
        }

        if (datumDO.getDate().before(new Date())) {
            lblErrorDatumDo.setText("Datum mora biti tekuci!");
            lblErrorDatumDo.setVisible(true);
            prazno = true;
        }

        if (datumDO.getDate().before(datumOD.getDate())) {
            lblErrorDatumOd.setText("Datum od ne sme biti veci od datuma do!");
            lblErrorDatumOd.setVisible(true);
            prazno = true;
        }

        return prazno;
    }
    
    private void popuniCmbVreme() {
        cmbVreme.removeAllItems();
        cmbVreme.addItem("16:00");
        cmbVreme.addItem("17:00");
        cmbVreme.addItem("18:00");
        cmbVreme.addItem("19:00");
        cmbVreme.addItem("20:00");
        cmbVreme.addItem("21:00");
        cmbVreme.addItem("22:00");
    }

    public void popuniTermine() {

        ArrayList<TerminVoznje> terminii = (ArrayList<TerminVoznje>) potvrdaPretrazena.getTermini();
        modelTermini = new TableModelTermini(terminii);
        tblTermini.setModel(modelTermini);

    }

}
