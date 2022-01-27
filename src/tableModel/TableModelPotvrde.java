/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import domen.Automobil;
import domen.PotvrdaOIznajmljivanju;
import domen.Vozac;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aleks
 */
public class TableModelPotvrde extends AbstractTableModel {
    
    private List<PotvrdaOIznajmljivanju> potvrde;
    private String[] kolone = {"ID", "Registracioni broj", "Vozac", "Cena", "Datum od", "Datum do"};
     SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    
    public TableModelPotvrde(List<PotvrdaOIznajmljivanju> potvrde) {
        this.potvrde = potvrde;
    }
    
    @Override
    public int getRowCount() {
        if (potvrde == null) {
            return 0;
        } else {
            return potvrde.size();
        }
    }
    
    @Override
    public int getColumnCount() {
        return kolone.length;
    }
    
    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    
    @Override
    public Object getValueAt(int row, int col) { //punimo tabelu iz liste
        PotvrdaOIznajmljivanju potvrda = potvrde.get(row);
        switch (col) {
            case 0:
                return potvrda.getPotvrdaID();
            case 1:
                return potvrda.getAutomobil();
            case 2:
                return potvrda.getVozac();
            case 3:
                return potvrda.getCena();
            case 4:
                return potvrda.getDatumOD();  //sdf.format(potvrda.getDatumOD())
            case 5:
                return potvrda.getDatumDO();  //sdf.format(potvrda.getDatumDO())
            default:
                return "n/a";
        }
    }
    
    @Override
    public void setValueAt(Object o, int row, int col) { // stavljamo iz tabele u listu
        PotvrdaOIznajmljivanju potvrda = potvrde.get(row);
       
        switch (col) {
            case 0:
                potvrda.setPotvrdaID(Integer.parseInt(o.toString()));
                break;
            case 1:
                potvrda.setAutomobil((Automobil) o);
                break;
            case 2:
                potvrda.setVozac((Vozac) o);
                break;
            case 3:
                potvrda.setCena(Double.parseDouble(o.toString()));
                break;
            case 4: {
                try {
                    potvrda.setDatumOD(sdf.parse(o.toString()));
                } catch (ParseException ex) {
                    Logger.getLogger(TableModelPotvrde.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 5: {
                try {
                    potvrda.setDatumDO(sdf.parse(o.toString()));
                } catch (ParseException ex) {
                    Logger.getLogger(TableModelPotvrde.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            
        }
        
    }
    
    @Override
    public boolean isCellEditable(int i, int i1) {
        return true;
    }
    
    public void dodajUTabelu(PotvrdaOIznajmljivanju potvrda) {
        potvrde.add(potvrda);
        fireTableDataChanged();
    }
    
    public void obrisiIzTabele(int row) {
        potvrde.remove(row);
        fireTableDataChanged();
    }
    
    public List<PotvrdaOIznajmljivanju> getPotvrdeIzTabele() {
        return potvrde;
    }
    
}
