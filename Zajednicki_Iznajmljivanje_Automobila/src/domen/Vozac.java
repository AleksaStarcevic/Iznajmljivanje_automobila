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
public class Vozac implements Serializable, OpstiDomenskiObjekat {

    private int vozacID;
    private String ime;
    private String prezime;
    private String email;
    private String adresa;

    public Vozac() {
    }

    public Vozac(int vozacID, String ime, String prezime, String email, String adresa) {
        this.vozacID = vozacID;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.adresa = adresa;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getVozacID() {
        return vozacID;
    }

    public void setVozacID(int vozacID) {
        this.vozacID = vozacID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
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
        final Vozac other = (Vozac) obj;
        if (this.vozacID != other.vozacID) {
            return false;
        }
        return true;
    }

   

   

    @Override
    public String vratiVrednostiAtributa() {
        return vozacID + ", " + (ime == null ? null : "'" + ime + "'") + ", " + (prezime == null ? null : "'" + prezime + "'") + ", " + (email == null ? null : "'" + email + "'") + ", " + (adresa == null ? null : "'" + adresa + "'");
    }

    @Override
    public String postaviVrednostAtrbuta() {
        return "vozacID=" + vozacID + ", ime=" + (ime == null ? null : "'" + ime + "'") + ", prezime=" + (prezime == null ? null : "'" + prezime + "'") + ", email=" + (email == null ? null : "'" + email + "'") + ", adresa=" + (adresa == null ? null : "'" + adresa + "'");
    }

    @Override
    public String vratiImeKlase() {
        return "Vozac";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "vozacID="+vozacID;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        Vozac vozac = new Vozac();
        try {
            while (rs.next()) {
                int id = rs.getInt("vozacID");
                String ime = rs.getString("ime");
                String prezime = rs.getString("prezime");
                String email = rs.getString("email");
                String adresa = rs.getString("adresa");

                vozac = new Vozac(id, ime, prezime, email, adresa);

            }
            return vozac;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom uzimanja vrednosti iz baze");
        }

    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                lista.add(new Vozac(rs.getInt("vozacID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("adresa")));

            }
            return lista;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom uzimanja vrednosti iz baze");
        }

    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
       return "";
    }

}
