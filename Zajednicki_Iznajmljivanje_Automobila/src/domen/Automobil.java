/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author aleks
 */
public class Automobil implements Serializable, OpstiDomenskiObjekat {

    private String registracioniBroj;
    private String model;
    private String marka;
    private TipAutomobila tip;

    public Automobil() {
    }

    public Automobil(String registracioniBroj, String model, String marka, TipAutomobila tip) {
        this.registracioniBroj = registracioniBroj;
        this.model = model;
        this.marka = marka;
        this.tip = tip;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getRegistracioniBroj() {
        return registracioniBroj;
    }

    public void setRegistracioniBroj(String registracioniBroj) {
        this.registracioniBroj = registracioniBroj;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return registracioniBroj;
    }

    public TipAutomobila getTip() {
        return tip;
    }

    public void setTip(TipAutomobila tip) {
        this.tip = tip;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Automobil other = (Automobil) obj;
        if (!Objects.equals(this.registracioniBroj, other.registracioniBroj)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return (registracioniBroj == null ? null : "'" + registracioniBroj + "'") + ", " + (model == null ? null : "'" + model + "'") + ", " + (marka == null ? null : "'" + marka + "'") + ", " + (tip == null ? null :tip.getTipID());
    }

    @Override
    public String postaviVrednostAtrbuta() {
        return "registracioniBroj=" + (registracioniBroj == null ? null : "'" + registracioniBroj + "'") + ", model=" + (model == null ? null : "'" + model + "'") + ", marka=" + (marka == null ? null : "'" + marka + "'") + ", tip=" + (tip == null ? null :tip.getTipID());
    }

    @Override
    public String vratiImeKlase() {
        return "Automobil";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "registracioniBroj=" + "'" + registracioniBroj + "'";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        Automobil a = new Automobil();
        try {
            while (rs.next()) {
                TipAutomobila tip = new TipAutomobila();
                tip.setTipID(rs.getInt("tipID"));
                tip.setNazivTipa(rs.getString("nazivTipa"));
                
                String regBroj = rs.getString("registracioniBroj");
                String model = rs.getString("model");
                String marka = rs.getString("marka");
                
                a = new Automobil(regBroj, model, marka, tip);
                
            }
            return a;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom uzimanja vednosti iz baze.");
        }
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                TipAutomobila tip = new TipAutomobila();
                tip.setTipID(rs.getInt("tipID"));
                tip.setNazivTipa(rs.getString("nazivTipa"));
                
                String regBroj = rs.getString("registracioniBroj");
                String model = rs.getString("model");
                String marka = rs.getString("marka");
                
                Automobil auto = new Automobil(regBroj, model, marka, tip);
                lista.add(auto);
            }
            return lista;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom uzimanja vednosti iz baze.");
        }
    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
       return " a JOIN tipautomobila t ON a.tip=t.tipID";
       
    }

}
