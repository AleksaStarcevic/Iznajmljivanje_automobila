/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;


import domen.Vozac;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aleks
 */
public class TableModelVozaci extends AbstractTableModel{
    ArrayList<Vozac> vozaci;
    Vozac pronadjen;

    public TableModelVozaci(ArrayList<Vozac> vozaci) {
        this.vozaci = vozaci;
      
    }

    public TableModelVozaci(Vozac pronadjen) {
        this.pronadjen = pronadjen;
    }
    
    
    
    @Override
    public int getRowCount() {
        return vozaci.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Vozac vozac = vozaci.get(row);
        switch (col) {
            case 0:
                return vozac.getVozacID();
            case 1:
                return vozac.getIme();
            case 2:
                return vozac.getPrezime();
            case 3:
                return vozac.getEmail();
            case 4:
                return vozac.getAdresa();
            
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int col) {
         switch (col) {
             case 0:
                return "ID";
            case 1:
                return "Ime";
            case 2:
                return "Prezime";
            case 3:
                return "Email";
            case 4:
                return "Adresa";
            
            default:
                return "n/a";
        }
    }
    
    
    
}
