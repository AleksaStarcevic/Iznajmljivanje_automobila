/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import domen.Automobil;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aleks
 */
public class TableModelAutomobili extends AbstractTableModel{
    ArrayList<Automobil> automobili;
    Automobil pronadjen;

    public TableModelAutomobili(ArrayList<Automobil> automobili) {
        this.automobili = automobili;
    }

    public TableModelAutomobili(Automobil pronadjen) {
        
        this.pronadjen = pronadjen;
    }
    
    
    
    
    public void setRegistarskiBroj(Automobil a){
        pronadjen = a;
    } 
    
    @Override
    public int getRowCount() {
       return automobili.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col) {
  
         
        
         Automobil automobil = automobili.get(row);
        switch (col) {
            case 0:
                return automobil.getRegistracioniBroj();
            case 1:
                return automobil.getMarka();
            case 2:
                return automobil.getModel();
            case 3:
                return automobil.getTip().getNazivTipa();
            
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int col) {
         switch (col) {
            case 0:
                return "Registracioni broj";
            case 1:
                return "Model";
            case 2:
                return "Marka";
            case 3:
                return "Tip";
            
            default:
                return "n/a";
        }
    }
    
   
    
   

   
    
    
    
    
}
