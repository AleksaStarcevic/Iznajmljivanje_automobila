/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Automobil;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.PotvrdaOIznajmljivanju;
import domen.TipAutomobila;
import domen.Vozac;


import java.util.ArrayList;
import java.util.List;
import so.AbstractSO;
import so.automobil.AddCarSO;
import so.automobil.DeleteCarSO;
import so.automobil.EditCarSO;
import so.automobil.FindCarSO;
import so.automobil.GetAllCarsSO;
import so.korisnik.KorisniciSO;
import so.potvrda.AddPotvrdaSO;
import so.potvrda.DeletePotvrdaSO;
import so.potvrda.EditPotvrdaSO;
import so.potvrda.FindPotvrdaSO;
import so.potvrda.GetPotvrdeSO;
import so.tipovi.GetTipoviSO;
import so.vozac.AddVozacSO;
import so.vozac.EditVozacSO;
import so.vozac.FindVozacSO;
import so.vozac.GetVozaciSO;

/**
 *
 * @author aleks
 */
public class Kontroler {

    private static Kontroler instanca;


    private Korisnik ulogovaniKorisnik;
    private List<Korisnik> prijavljeni;

    private Kontroler() {
        this.prijavljeni = new ArrayList<>();
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public List<Korisnik> getPrijavljeni() {
        return prijavljeni;
    }

    public void setUlogovaniKorisnik(Korisnik ulogovaniKorisnik) {
        this.ulogovaniKorisnik = ulogovaniKorisnik;
    }

    public Korisnik getUlogovaniKorisnik() {
        return ulogovaniKorisnik;
    }

    public OpstiDomenskiObjekat login(Korisnik k) throws Exception {

        KorisniciSO korisniciSO = new KorisniciSO();
        korisniciSO.execute(k);
        ArrayList<OpstiDomenskiObjekat> korisnici = korisniciSO.getListaKorisnika();

        for (OpstiDomenskiObjekat opstiDomenskiObjekat : korisnici) {
            if (opstiDomenskiObjekat.equals(k)) {
                return opstiDomenskiObjekat;
            }
        }

        throw new Exception("Nepoznat korisnik!");

    }

    public void dodajAutomobil(Automobil a) throws Exception {
        try {
            AbstractSO dodajAutomobilSO = new AddCarSO();
            dodajAutomobilSO.execute(a);

        } catch (Exception e) {
            throw new Exception("Automobil sa registarskom oznakom:" + a.getRegistracioniBroj() + " vec postoji u sistemu!");
        }
      
    }

    public void obrisiAutomobil(Automobil a) throws Exception {
        try {
            AbstractSO obrisiAutomobilSO = new DeleteCarSO();
            obrisiAutomobilSO.execute(a);

        } catch (Exception e) {
            throw e;
        }       
    }

    public void izmeniAutomobil(Automobil a) throws Exception {
        try {
            AbstractSO izmeniAutomobilSO = new EditCarSO();
            izmeniAutomobilSO.execute(a);

        } catch (Exception e) {
            throw e;
        }
      
    }

    public ArrayList<OpstiDomenskiObjekat> getStorageAutomobili(Automobil a) throws Exception {
        GetAllCarsSO vratiSveAutomobileSO = new GetAllCarsSO();
        try {
            vratiSveAutomobileSO.execute(a);
        } catch (Exception e) {
            throw e;
        }
        return vratiSveAutomobileSO.getListaAutomobila();
    }

    public List<OpstiDomenskiObjekat> getStorageVozac(Vozac v) throws Exception {
        GetVozaciSO vratiSveVozaceSO = new GetVozaciSO();
        try {
            vratiSveVozaceSO.execute(v);
        } catch (Exception e) {
            throw e;
        }
        return vratiSveVozaceSO.getListaVozaca();
    }

    public List<OpstiDomenskiObjekat> getStorageTipovi(TipAutomobila t) throws Exception {
        GetTipoviSO vratiSveTipove = new GetTipoviSO();
        try {
            vratiSveTipove.execute(t);
        } catch (Exception e) {
            throw e;
        }
        return vratiSveTipove.getListaTipova();
    }

    public OpstiDomenskiObjekat getAutomobilByRegBroj(Automobil a) throws Exception {
        FindCarSO nadjiAuto = new FindCarSO();
        try {
            nadjiAuto.execute(a);
        } catch (Exception e) {
            throw new Exception("Automobil sa registracionim brojem " + a.getRegistracioniBroj() + " ne postoji u sistemu!");
        }
        return nadjiAuto.getAutomobil();
       
    }

    public void dodaj(PotvrdaOIznajmljivanju potvrda) throws Exception {
        try {
            AbstractSO dodajPotvrduSO = new AddPotvrdaSO();
            dodajPotvrduSO.execute(potvrda);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Potvrda sa id: " + potvrda.getPotvrdaID() + " vec postoji u sistemu!");
        }       

    }

    public OpstiDomenskiObjekat getPotvrdaByID(PotvrdaOIznajmljivanju p) throws Exception {
        FindPotvrdaSO pronadjiPotvrduSO = new FindPotvrdaSO();
        try {
            pronadjiPotvrduSO.execute(p);

        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Potvrda sa ID:" + p.getPotvrdaID() + " ne postoji u sistemu");
        }
        return pronadjiPotvrduSO.getPotvrda();

    }

    public void izmeniPotvrdu(PotvrdaOIznajmljivanju potvrda) throws Exception {
        try {
            AbstractSO izmeniPotvrduSO = new EditPotvrdaSO();
            izmeniPotvrduSO.execute(potvrda);

        } catch (Exception e) {
            throw e;
        }
      
    }

    public void obrisiPotvrdu(PotvrdaOIznajmljivanju p) throws Exception {
        try {
            AbstractSO izbrisiPotvrduSO = new DeletePotvrdaSO();
            izbrisiPotvrduSO.execute(p);

        } catch (Exception e) {
            throw e;
        }
      
    }

    public List<OpstiDomenskiObjekat> getPotvrde(PotvrdaOIznajmljivanju p) throws Exception {
        GetPotvrdeSO vratiPotvrdeSO = new GetPotvrdeSO();
        try {
            vratiPotvrdeSO.execute(p);

        } catch (Exception e) {
            throw e;
        }
        return vratiPotvrdeSO.getListaPotvrda();
    }

    public void dodajVozaca(Vozac v) throws Exception {
        try {
            AbstractSO dodajVozacaSO = new AddVozacSO();
            dodajVozacaSO.execute(v);

        } catch (Exception e) {
            throw new Exception("Vozac sa id: " + v.getVozacID()+ " vec postoji u sistemu!");
        }
    }

    public OpstiDomenskiObjekat pronadjiVozaca(Vozac vozac) throws Exception {
        FindVozacSO pronadjiVozacaSO = new FindVozacSO();
        try {
            pronadjiVozacaSO.execute(vozac);

        } catch (Exception e) {
            throw new Exception("Vozac sa id:" + vozac.getVozacID()+ " ne postoji u sistemu");
        }
        return pronadjiVozacaSO.getVozac();
    }

    public void izmeniVozaca(Vozac vozac) throws Exception {
        try {
            AbstractSO izmeniVozacaSO = new EditVozacSO();
            izmeniVozacaSO.execute(vozac);

        } catch (Exception e) {
            throw e;
        }
    }

}
