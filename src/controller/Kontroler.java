/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domen.Automobil;
import domen.Korisnik;
import domen.PotvrdaOIznajmljivanju;
import domen.TipAutomobila;
import domen.Vozac;
import exception.ValidacijaException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.db.RepositoryAutomobil;
import repository.db.RepositoryKorisnik;
import repository.db.RepositoryPotvrda;
import repository.db.RepositoryTipovi;
import repository.db.RepositoryVozac;

/**
 *
 * @author aleks
 */
public class Kontroler {

    private static Kontroler instanca;
    private final RepositoryKorisnik storageKorisnik;
    private final RepositoryAutomobil storageAutomobil;
    private final RepositoryPotvrda storagePotvrda;
    private final RepositoryVozac storageVozac;
    private final RepositoryTipovi storageTipovi;

    private Korisnik ulogovaniKorisnik;

    private Kontroler() {
        this.storageKorisnik = new RepositoryKorisnik();
        this.storageAutomobil = new RepositoryAutomobil();
        this.storagePotvrda = new RepositoryPotvrda();
        this.storageVozac = new RepositoryVozac();
        this.storageTipovi = new RepositoryTipovi();
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Korisnik login(String username, String password) throws Exception {
        try {

            storageKorisnik.connect();
            List<Korisnik> korisnici = storageKorisnik.getKorisnici();
            storageKorisnik.commit();
            for (Korisnik korisnik : korisnici) {
                if (korisnik.getKorisnickoIme().equalsIgnoreCase(username) && korisnik.getSifra().equals(password)) {
                    return korisnik;
                }

            }
            throw new Exception("Nepoznat korisnik!");
        } catch (Exception e) {
            storageKorisnik.rollback();
            throw e;
        } finally {
            storageKorisnik.disconnect();
        }

    }

    public void dodajAutomobil(Automobil a) throws Exception {
        storageAutomobil.connect();

        try {
            if (!(storageAutomobil.getAutomobili().contains(a))) {

                storageAutomobil.kreirajAutomobil(a);
                storageAutomobil.commit();
            } else {
                throw new Exception("Automobil vec postoji!");
            }
        } catch (Exception e) {
            storageAutomobil.rollback();
            throw e;
        } finally {
            storageAutomobil.disconnect();
        }

    }

    public void obrisiAutomobil(String registracioniBroj) throws Exception {
        try {
            storageAutomobil.connect();
            storageAutomobil.obrisiAutomobil(registracioniBroj);
            storageAutomobil.commit();
            throw new Exception("Uspesno brisanje automobila!");
        } catch (SQLException ex) {
            storageAutomobil.rollback();
            throw new Exception("Neuspesno brisanje automobila!");
        } finally {
            storageAutomobil.disconnect();
        }
    }

    public void izmeniAutomobil(String regBroj, Automobil a) throws SQLException {
        storageAutomobil.izmeniAutomobil(regBroj, a);
    }

    public List<Automobil> getStorageAutomobili() throws SQLException {
        return storageAutomobil.getAutomobili();
    }

    public List<Vozac> getStorageVozac() throws SQLException {
        return storageVozac.getVozaci();
    }

    public List<TipAutomobila> getStorageTipovi() throws SQLException {
        return storageTipovi.vratiTipoveAutomobila();
    }

    public Automobil getAutomobilByRegBroj(String RegBroj) throws SQLException, ValidacijaException {
        return storageAutomobil.getAutomobilByRegBroj(RegBroj);
    }

    public void dodaj(PotvrdaOIznajmljivanju potvrda) throws Exception {
        storagePotvrda.connect();
        try {
            if (!(storagePotvrda.getSvePotvrde().contains(potvrda))) {
                storagePotvrda.dodaj(potvrda);
                storagePotvrda.commit();
            } else {
                throw new Exception("Potvrda vec postoji!");
            }
        } catch (Exception e) {
            storagePotvrda.rollback();
            throw e;
        } finally {
            storagePotvrda.disconnect();
        }

    }

    public void dodajSvePotvrde(List<PotvrdaOIznajmljivanju> potvrde) throws SQLException {
        storagePotvrda.connect();
        try {
            storagePotvrda.dodajSvePotvrde(potvrde);
            storagePotvrda.commit();
        } catch (Exception e) {
            storagePotvrda.rollback();
            throw e;
        } finally {
            storagePotvrda.disconnect();
        }
    }

    public List<PotvrdaOIznajmljivanju> getPotvrde() throws SQLException {
        return storagePotvrda.getSvePotvrde();
    }

    public void setUlogovaniKorisnik(Korisnik ulogovaniKorisnik) {
        this.ulogovaniKorisnik = ulogovaniKorisnik;
    }

    public Korisnik getUlogovaniKorisnik() {
        return ulogovaniKorisnik;
    }

}
