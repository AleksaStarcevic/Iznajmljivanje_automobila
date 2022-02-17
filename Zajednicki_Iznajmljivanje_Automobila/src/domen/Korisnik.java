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
public class Korisnik implements Serializable,OpstiDomenskiObjekat{
    private int korisnikID;
    private String korisnickoIme;
    private String sifra;

    public Korisnik() {
    }

    public Korisnik(int korisnikID, String korisnickoIme, String sifra) {
        this.korisnikID = korisnikID;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }
    
    public Korisnik( String korisnickoIme, String sifra) {
      
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }
    

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    @Override
    public String toString() {
       return korisnickoIme;
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
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.sifra, other.sifra)) {
            return false;
        }
        return true;
    }

    @Override
    public String vratiVrednostiAtributa() {
        return korisnikID + ", " + (korisnickoIme == null ? null : "'" + korisnickoIme + "'") + ", " + (sifra == null ? null : "'" + sifra + "'");
    }

    @Override
    public String postaviVrednostAtrbuta() {
        return "korisnikID=" + korisnikID + ", korisnickoIme=" + (korisnickoIme == null ? null : "'" + korisnickoIme + "'") + ", sifra=" + (sifra == null ? null : "'" + sifra + "'") ;
    }

    @Override
    public String vratiImeKlase() {
       return "Korisnik";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "/";
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
         Korisnik korisnik = new Korisnik();
        try {
            while (rs.next()) {
               int id = rs.getInt("korisnikID");
                String ime=rs.getString("korisnickoIme");
                String sifra = rs.getString("sifra");
                korisnik = new Korisnik(id, ime, sifra);

            }
            return korisnik;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom uzimanja vrednosti iz baze");
        }
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet rs) throws Exception {
          ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
               int id = rs.getInt("korisnikID");
                String ime=rs.getString("korisnickoIme");
                String sifra = rs.getString("sifra");
                Korisnik korisnik = new Korisnik(id, ime, sifra);
                lista.add(korisnik);

            }
            return lista;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom uzimanja vrednosti iz baze");
        }
    }


    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
