/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Objects;

/**
 *
 * @author aleks
 */
public class Automobil {
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
    
    
    
    
}
