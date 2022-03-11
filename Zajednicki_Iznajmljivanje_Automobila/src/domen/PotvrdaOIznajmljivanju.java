/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aleks
 */
public class PotvrdaOIznajmljivanju implements Serializable, OpstiDomenskiObjekat {

    private int potvrdaID;
    private Date datumOD;
    private Date datumDO;
    private double cena;
    private Automobil automobil;
    private Vozac vozac;
    private Korisnik korisnik;
    private List<TerminVoznje> termini;

    public PotvrdaOIznajmljivanju() {
        termini = new ArrayList<>();
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

    public PotvrdaOIznajmljivanju(int potvrdaID, Date datumOD, Date datumDO, double cena, Automobil automobil, Vozac vozac, Korisnik korisnik, List<TerminVoznje> termini) {
        this.potvrdaID = potvrdaID;
        this.datumOD = datumOD;
        this.datumDO = datumDO;
        this.cena = cena;
        this.automobil = automobil;
        this.vozac = vozac;
        this.korisnik = korisnik;
        this.termini = termini;
    }

    public List<TerminVoznje> getTermini() {
        return termini;
    }

    public void setTermini(List<TerminVoznje> termini) {
        this.termini = termini;
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
        return "PotvrdaOIznajmljivanju{" + "potvrdaID=" + potvrdaID + ", datumOD=" + datumOD + ", datumDO=" + datumDO + ", cena=" + cena + ", automobil=" + automobil + ", vozac=" + vozac + ", korisnik=" + korisnik + ", termini=" + termini + '}';
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

    @Override
    public String vratiVrednostiAtributa() {
        return potvrdaID + ", " + (datumOD == null ? null : "'" + new java.sql.Date(datumOD.getTime()) + "'") + ", " + (datumDO == null ? null : "'" + new java.sql.Date(datumDO.getTime()) + "'") + ", " + (cena < 0 ? null : cena) + ", " + (automobil == null ? null : "'" + automobil.getRegistracioniBroj() + "'") + ", " + (vozac == null ? null : vozac.getVozacID()) + ", " + (korisnik == null ? null : korisnik.getKorisnikID());
    }

    @Override
    public String postaviVrednostAtrbuta() {
        return "potvrdaID=" + potvrdaID + ", datumOD=" + (datumOD == null ? null : "'" + new java.sql.Date(datumOD.getTime()) + "'") + ", datumDO=" + (datumDO == null ? null : "'" + new java.sql.Date(datumDO.getTime()) + "'") + ", cena=" + (cena < 0 ? null : cena) + ", automobil=" + (automobil == null ? null : "'" + automobil.getRegistracioniBroj() + "'") + ", vozac=" + (vozac == null ? null : vozac.getVozacID()) + ", korisnik=" + (korisnik == null ? null : korisnik.getKorisnikID());
    }

    @Override
    public String vratiImeKlase() {
        return "PotvrdaOIznajmljivanju";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return "potvrdaID=" + potvrdaID;
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return "";
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();
        try {

            while (rs.next()) {

                potvrda.setPotvrdaID(rs.getInt("potvrdaID"));
                potvrda.setDatumOD(rs.getDate("datumOD"));
                potvrda.setDatumDO(rs.getDate("datumDO"));
                potvrda.setCena(rs.getDouble("cena"));

                TipAutomobila tip = new TipAutomobila();
                tip.setTipID(rs.getInt("tipID"));
                tip.setNazivTipa(rs.getString("nazivTipa"));

                Automobil automobil = new Automobil();
                automobil.setRegistracioniBroj(rs.getString("automobil"));
                automobil.setModel(rs.getString("model"));
                automobil.setMarka(rs.getString("marka"));
                automobil.setTip(tip);

                Korisnik korisnik = new Korisnik();
                korisnik.setKorisnikID(rs.getInt("korisnikID"));
                korisnik.setKorisnickoIme(rs.getString("korisnickoIme"));
                korisnik.setSifra(rs.getString("sifra"));

                Vozac vozac = new Vozac();
                vozac.setVozacID(rs.getInt("vozacID"));
                vozac.setIme(rs.getString("ime"));
                vozac.setPrezime(rs.getString("prezime"));
                vozac.setEmail(rs.getString("email"));
                vozac.setAdresa(rs.getString("adresa"));

                potvrda.setAutomobil(automobil);
                potvrda.setVozac(vozac);
                potvrda.setKorisnik(korisnik);

            }
            return potvrda;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom uzimanja vednosti iz baze.");

        }
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet rs) throws Exception {
        ArrayList<OpstiDomenskiObjekat> potvrde = new ArrayList<>();
        try {

            while (rs.next()) {
                PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();
                potvrda.setPotvrdaID(rs.getInt("potvrdaID"));
                potvrda.setDatumOD(rs.getDate("datumOD"));
                potvrda.setDatumDO(rs.getDate("datumDO"));
                potvrda.setCena(rs.getDouble("cena"));

                TipAutomobila tip = new TipAutomobila();
                tip.setTipID(rs.getInt("tipID"));
                tip.setNazivTipa(rs.getString("nazivTipa"));

                Automobil automobil = new Automobil();
                automobil.setRegistracioniBroj(rs.getString("automobil"));
                automobil.setModel(rs.getString("model"));
                automobil.setMarka(rs.getString("marka"));
                automobil.setTip(tip);

                Korisnik korisnik = new Korisnik();
                korisnik.setKorisnikID(rs.getInt("korisnikID"));
                korisnik.setKorisnickoIme(rs.getString("korisnickoIme"));
                korisnik.setSifra(rs.getString("sifra"));

                Vozac vozac = new Vozac();
                vozac.setVozacID(rs.getInt("vozacID"));
                vozac.setIme(rs.getString("ime"));
                vozac.setPrezime(rs.getString("prezime"));
                vozac.setEmail(rs.getString("email"));
                vozac.setAdresa(rs.getString("adresa"));

                potvrda.setAutomobil(automobil);
                potvrda.setVozac(vozac);
                potvrda.setKorisnik(korisnik);

                potvrde.add(potvrda);

            }
            return potvrde;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom uzimanja vednosti iz baze.");

        }

    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return " p JOIN automobil a ON p.automobil = a.registracioniBroj "
                + "JOIN vozac v ON p.vozac = v.vozacID "
                + "JOIN korisnik k ON p.korisnik=k.korisnikID "
                + "JOIN tipautomobila t ON a.tip=t.tipID";
    }

}
