/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author aleks
 */
public class PotvrdaOIznajmljivanju implements Serializable{
    private int potvrdaID;
    private Date datumOD;
    private Date datumDO;
    private double cena;
    private Automobil automobil;
    private Vozac vozac;
    private Korisnik korisnik;

    public PotvrdaOIznajmljivanju() {
    }

    public PotvrdaOIznajmljivanju(int potvrdaID, Date datumOD, Date datumDO, double cena, Automobil automobil, Vozac vozac, Korisnik korisnik) {
        this.potvrdaID = potvrdaID;
        this.datumOD = datumOD;
        this.datumDO = datumDO;
        this.cena = cena;
        this.automobil = automobil;
        this.vozac = vozac;
        this.korisnik = korisnik;
    }

   

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getPotvrdaID() {
        return potvrdaID;
    }

    public void setPotvrdaID(int potvrdaID) {
        this.potvrdaID = potvrdaID;
    }

    public Date getDatumOD() {
        return datumOD;
    }

    public void setDatumOD(Date datumOD) {
        this.datumOD = datumOD;
    }

    public Date getDatumDO() {
        return datumDO;
    }

    public void setDatumDO(Date datumDO) {
        this.datumDO = datumDO;
    }

    public Automobil getAutomobil() {
        return automobil;
    }

    public void setAutomobil(Automobil automobil) {
        this.automobil = automobil;
    }

    public Vozac getVozac() {
        return vozac;
    }

    public void setVozac(Vozac vozac) {
        this.vozac = vozac;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public String toString() {
        return "PotvrdaOIznajmljivanju{" + "potvrdaID=" + potvrdaID + ", datumOD=" + datumOD + ", datumDO=" + datumDO + ", cena=" + cena + ", automobil=" + automobil + ", vozac=" + vozac + ", korisnik=" + korisnik + '}';
    }

   

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.potvrdaID;
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
        final PotvrdaOIznajmljivanju other = (PotvrdaOIznajmljivanju) obj;
        if (this.potvrdaID != other.potvrdaID) {
            return false;
        }
        return true;
    }
    

    

   
    
    
}
