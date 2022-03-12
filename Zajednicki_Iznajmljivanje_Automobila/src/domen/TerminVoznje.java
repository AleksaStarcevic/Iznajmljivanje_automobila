/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author aleks
 */
public class TerminVoznje implements Serializable, OpstiDomenskiObjekat {

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

    @Override
    public String vratiVrednostiAtributa() {
        return potvrda.getPotvrdaID() + ", " + redniBroj + ", " + (dan == null ? null : "'" + new java.sql.Date(dan.getTime()) + "'") + ", " + (vreme == null ? null : "'" + vreme + "'");
    }

    @Override
    public String postaviVrednostAtrbuta() {
        return "potvrdaID=" + (potvrda == null ? null : potvrda.getPotvrdaID()) + ", redniBroj=" + redniBroj + ", dan=" + (dan == null ? null : "'" + dan + "'") + ", vreme=" + (vreme == null ? null : "'" + vreme + "'");
    }

    @Override
    public String vratiImeKlase() {
        return "Termini_Voznje";
    }

    @Override
    public String vratiUslovZaNadjiSlog() {
        return " potvrdaID=" + potvrda.getPotvrdaID();
    }

    @Override
    public String vratiUslovZaNadjiSlogove() {
        return " potvrdaID=" + potvrda.getPotvrdaID();
    }

    @Override
    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception {
        PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();
        ArrayList<TerminVoznje> termini = new ArrayList<>();
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

                TerminVoznje termin = new TerminVoznje();
                termin.setPotvrda(potvrda);
                termin.setRedniBroj(rs.getInt("redniBroj"));
                termin.setDan(rs.getDate("dan"));
                termin.setVreme(rs.getString("vreme"));
                termini.add(termin);

                potvrda.setAutomobil(automobil);
                potvrda.setVozac(vozac);
                potvrda.setKorisnik(korisnik);
                potvrda.setTermini(termini);

            }
            return potvrda;
        } catch (Exception ex) {
            throw new Exception("Greska prilikom uzimanja vednosti iz baze.");

        }
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet rsT) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();

        while (rsT.next()) {

            PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();

            potvrda.setPotvrdaID(rsT.getInt("potvrdaID"));
            potvrda.setDatumOD(rsT.getDate("datumOD"));
            potvrda.setDatumDO(rsT.getDate("datumDO"));
            potvrda.setCena(rsT.getDouble("cena"));

            TipAutomobila tip = new TipAutomobila();
            tip.setTipID(rsT.getInt("tipID"));
            tip.setNazivTipa(rsT.getString("nazivTipa"));

            Automobil automobil = new Automobil();
            automobil.setRegistracioniBroj(rsT.getString("automobil"));
            automobil.setModel(rsT.getString("model"));
            automobil.setMarka(rsT.getString("marka"));
            automobil.setTip(tip);

            Korisnik korisnik = new Korisnik();
            korisnik.setKorisnikID(rsT.getInt("korisnikID"));
            korisnik.setKorisnickoIme(rsT.getString("korisnickoIme"));
            korisnik.setSifra(rsT.getString("sifra"));

            Vozac vozac = new Vozac();
            vozac.setVozacID(rsT.getInt("vozacID"));
            vozac.setIme(rsT.getString("ime"));
            vozac.setPrezime(rsT.getString("prezime"));
            vozac.setEmail(rsT.getString("email"));
            vozac.setAdresa(rsT.getString("adresa"));

            potvrda.setAutomobil(automobil);
            potvrda.setVozac(vozac);
            potvrda.setKorisnik(korisnik);
         

            TerminVoznje termin = new TerminVoznje();
            termin.setPotvrda(potvrda);
            termin.setRedniBroj(rsT.getInt("redniBroj"));
            termin.setDan(rsT.getDate("dan"));
            termin.setVreme(rsT.getString("vreme"));
            lista.add(termin);
        }
        return lista;

    }

    @Override
    public String vratiTabeluSaUslovomSpajanja() {
        return " tr JOIN potvrdaoiznajmljivanju p ON tr.potvrdaID=p.potvrdaID "
                + "JOIN automobil a ON p.automobil = a.registracioniBroj "
                + "JOIN vozac v ON p.vozac = v.vozacID "
                + "JOIN korisnik k ON p.korisnik=k.korisnikID "
                + "JOIN tipautomobila t ON a.tip=t.tipID";
    }

}
