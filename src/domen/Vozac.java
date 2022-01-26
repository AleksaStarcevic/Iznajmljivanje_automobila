/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author aleks
 */
public class Vozac {
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
        return ime+" "+prezime;
    }
    
    
}
