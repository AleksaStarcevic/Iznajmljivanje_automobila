/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author aleks
 */
public class TerminVoznje {
    private PotvrdaOIznajmljivanju potvrda;
    private int redniBroj;
    private Date dan;
    private String vreme;

    public TerminVoznje() {
    }

    public TerminVoznje(PotvrdaOIznajmljivanju potvrda, int redniBroj, Date dan, String vreme) {
        this.potvrda = potvrda;
        this.redniBroj = redniBroj;
        this.dan = dan;
        this.vreme = vreme;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public PotvrdaOIznajmljivanju getPotvrda() {
        return potvrda;
    }

    public void setPotvrda(PotvrdaOIznajmljivanju potvrda) {
        this.potvrda = potvrda;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public Date getDan() {
        return dan;
    }

    public void setDan(Date dan) {
        this.dan = dan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final TerminVoznje other = (TerminVoznje) obj;
        if (!Objects.equals(this.dan, other.dan)) {
            return false;
        }
        if (!Objects.equals(this.vreme, other.vreme)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TerminVoznje{" + "potvrda=" + potvrda.getPotvrdaID() + ", redniBroj=" + redniBroj + ", dan=" + dan + ", vreme=" + vreme + '}';
    }

    
    
    
    
}
