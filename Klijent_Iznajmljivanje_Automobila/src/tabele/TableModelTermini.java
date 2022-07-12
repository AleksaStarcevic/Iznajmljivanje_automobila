/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabele;

import domen.TerminVoznje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aleks
 */
public class TableModelTermini extends AbstractTableModel {

    private ArrayList<TerminVoznje> termini;
    private String[] kolone = {"Redni broj", "Dan", "Vreme"};

    public TableModelTermini(ArrayList<TerminVoznje> termini) {
        this.termini = termini;
    }

    public ArrayList<TerminVoznje> getTermini() {
        return termini;
    }

    @Override
    public int getRowCount() {
        return termini.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int col) {
        TerminVoznje t = termini.get(row);

        switch (col) {
            case 0:
                return t.getRedniBroj();
            case 1: {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
                String datumNovi = sdf.format(t.getDan());
                return datumNovi;
            }
            case 2: {
//                SimpleDateFormat sdf2 = new SimpleDateFormat("kk:mm");
//                String vremeNovo = sdf2.format(t.getVreme());
                return t.getVreme();
            }
            default:
                return "";
        }
    }

    public void dodajTermin(TerminVoznje t) {
        t.setRedniBroj(termini.size() + 1);
        termini.add(t);
        fireTableDataChanged();

    }

    public void obrisiElement(int red) {
        termini.remove(red);
        int rbr = 1;
        for (TerminVoznje termin : termini) {
            termin.setRedniBroj(rbr++);
        }

        fireTableDataChanged();
    }

}
