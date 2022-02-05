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

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.impl.RepositoryAutomobil;
import repository.impl.RepositoryKorisnik;
import repository.impl.RepositoryPotvrda;
import repository.impl.RepositoryTipovi;
import repository.impl.RepositoryVozac;

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
            List<Korisnik> korisnici = storageKorisnik.getAll();
            storageKorisnik.commit();
            for (Korisnik korisnik : korisnici) {
                if (korisnik.getKorisnickoIme().equalsIgnoreCase(username) && korisnik.getSifra().equals(password)) {
                    return korisnik;
                }

            }
            throw new Exception("Nepoznat korisnik!");
        } catch (SQLException e) {
            storageKorisnik.rollback();
            throw e;
        } finally {
            storageKorisnik.disconnect();
        }

    }

    public void dodajAutomobil(Automobil a) throws Exception {
        storageAutomobil.connect();

        try {
            if (!(storageAutomobil.getAll().contains(a))) {

                storageAutomobil.add(a);
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

    public void obrisiAutomobil(Automobil a) throws Exception {
        try {
            storageAutomobil.connect();
            storageAutomobil.delete(a);
            storageAutomobil.commit();
            
        } catch (SQLException ex) {
            storageAutomobil.rollback();
            throw new Exception("Neuspesno brisanje automobila!");
        } finally {
            storageAutomobil.disconnect();
        }
    }

    public void izmeniAutomobil(Automobil a) throws Exception {
        try {
            storageAutomobil.connect();
            storageAutomobil.edit(a);
            storageAutomobil.commit();

        } catch (SQLException ex) {
            storageAutomobil.rollback();
            throw new Exception("Neuspesna izmena automobila!");
        } finally {
            storageAutomobil.disconnect();
        }
    }

    public List<Automobil> getStorageAutomobili() throws SQLException {
        return storageAutomobil.getAll();
    }

    public List<Vozac> getStorageVozac() throws SQLException {
        return storageVozac.getAll();
    }

    public List<TipAutomobila> getStorageTipovi() throws SQLException {
        return storageTipovi.getAll();
    }

    public Automobil getAutomobilByRegBroj(String RegBroj) throws Exception {
        Automobil auto = new Automobil();
        try {

            storageAutomobil.connect();
            auto = storageAutomobil.getByID(RegBroj);
            if (auto.getRegistracioniBroj() == null) {
                throw new Exception("Automobil sa registracionim brojem " + RegBroj + " ne postoji u sistemu!");
            }
            storageAutomobil.commit();
        } catch (SQLException ex) {
            storageAutomobil.rollback();
            throw new Exception("Neuspesna pretraga automobila!");
        } finally {
            storageAutomobil.disconnect();
        }

        return auto;
    }

    public void dodaj(PotvrdaOIznajmljivanju potvrda) throws Exception {
        storagePotvrda.connect();
        try {
            if (!(storagePotvrda.getAll().contains(potvrda))) {
                storagePotvrda.add(potvrda);
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
            storagePotvrda.addAll(potvrde);
            storagePotvrda.commit();
        } catch (SQLException e) {
            storagePotvrda.rollback();
            throw e;
        } finally {
            storagePotvrda.disconnect();
        }
    }

    public PotvrdaOIznajmljivanju getPotvrdaByID(int id) throws Exception {
        PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();
        try {
            storagePotvrda.connect();
            potvrda = storagePotvrda.getByID(id);
            if (potvrda.getPotvrdaID() == 0) {
                throw new Exception("Potvrda sa ID:" + id + " ne postoji u sistemu");
            }
            storagePotvrda.commit();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            storagePotvrda.disconnect();
        }
        return potvrda;
    }

    public void izmeniPotvrdu(PotvrdaOIznajmljivanju potvrda) throws Exception {
        try {
            storagePotvrda.connect();
            storagePotvrda.edit(potvrda);
            storagePotvrda.commit();
            throw new Exception("Uspesno izmenjena potvrda!");
        } catch (SQLException ex) {
            storagePotvrda.rollback();
            throw new Exception("Neuspesna izmena potvrde!");
        } finally {
            storagePotvrda.disconnect();
        }
    }
    
    public void obrisiPotvrdu(PotvrdaOIznajmljivanju p) throws Exception{
        try {
            storagePotvrda.connect();
            storagePotvrda.delete(p);
            storagePotvrda.commit();
            throw new Exception("Uspesno brisanje potvrde!");
        } catch (SQLException ex) {
            storagePotvrda.rollback();
            throw new Exception("Neuspesno brisanje potvrde!");
        } finally {
            storagePotvrda.disconnect();
        }
    }

    public List<PotvrdaOIznajmljivanju> getPotvrde() throws Exception {
        return storagePotvrda.getAll();
    }

    public void dodajVozaca(Vozac v) throws Exception {
        try {
            storageVozac.connect();
            if (!storageVozac.getAll().contains(v)) {
                storageVozac.add(v);
                storageVozac.commit();
               
            } else {
                throw new Exception("Vozac vec sa id:" + v.getVozacID() + " vec postoji u sistemu!");
            }
        } catch (Exception ex) {
            storageVozac.rollback();
            throw ex;
        } finally {
            storagePotvrda.disconnect();
        }
    }

    public void setUlogovaniKorisnik(Korisnik ulogovaniKorisnik) {
        this.ulogovaniKorisnik = ulogovaniKorisnik;
    }

    public Korisnik getUlogovaniKorisnik() {
        return ulogovaniKorisnik;
    }

}
