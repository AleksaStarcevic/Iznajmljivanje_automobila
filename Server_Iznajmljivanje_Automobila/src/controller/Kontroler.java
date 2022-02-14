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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.impl.RepositoryAutomobil;
import repository.impl.RepositoryKorisnik;
import repository.impl.RepositoryPotvrda;
import repository.impl.RepositoryTipovi;
import repository.impl.RepositoryVozac;
import so.AbstractSO;
import so.automobil.AddCarSO;
import so.automobil.DeleteCarSO;
import so.automobil.EditCarSO;
import so.automobil.FindCarSO;
import so.automobil.GetAllCarsSO;
import so.potvrda.AddPotvrdaSO;
import so.potvrda.DeletePotvrdaSO;
import so.potvrda.EditPotvrdaSO;
import so.potvrda.FindPotvrdaSO;
import so.potvrda.GetPotvrdeSO;

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
    private List<Korisnik> prijavljeni;

    private Kontroler() {
        this.storageKorisnik = new RepositoryKorisnik();
        this.storageAutomobil = new RepositoryAutomobil();
        this.storagePotvrda = new RepositoryPotvrda();
        this.storageVozac = new RepositoryVozac();
        this.storageTipovi = new RepositoryTipovi();
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
        try {
            AbstractSO dodajAutomobilSO = new AddCarSO();
            dodajAutomobilSO.execute(a);

        } catch (Exception e) {
            throw e;
        }

//        storageAutomobil.connect();
//        try {
//            if (!(storageAutomobil.getAll().contains(a))) {
//                storageAutomobil.add(a);
//                storageAutomobil.commit();
//            } else {
//                throw new Exception("Automobil sa registarskom oznakom:" + a.getRegistracioniBroj() + " vec postoji u sistemu!");
//            }
//        } catch (SQLException e) {
//            storageAutomobil.rollback();
//            throw e;
//        } finally {
//            storageAutomobil.disconnect();
//        }
    }

    public void obrisiAutomobil(Automobil a) throws Exception {
        try {
            AbstractSO obrisiAutomobilSO = new DeleteCarSO();
            obrisiAutomobilSO.execute(a);

        } catch (Exception e) {
            throw e;
        }
//        try {
//            storageAutomobil.connect();
//            storageAutomobil.delete(a);
//            storageAutomobil.commit();
//
//        } catch (SQLException ex) {
//            storageAutomobil.rollback();
//            throw new Exception("Neuspesno brisanje automobila!");
//        } finally {
//            storageAutomobil.disconnect();
//        }
    }

    public void izmeniAutomobil(Automobil a) throws Exception {
        try {
            AbstractSO izmeniAutomobilSO = new EditCarSO();
            izmeniAutomobilSO.execute(a);

        } catch (Exception e) {
            throw e;
        }
//        try {
//            storageAutomobil.connect();
//            storageAutomobil.edit(a);
//            storageAutomobil.commit();
//
//        } catch (SQLException ex) {
//            storageAutomobil.rollback();
//            throw new Exception("Neuspesna izmena automobila!");
//        } finally {
//            storageAutomobil.disconnect();
//        }
    }

    public List<Automobil> getStorageAutomobili() throws Exception {
        GetAllCarsSO vratiSveAutomobileSO = new GetAllCarsSO();
        try {
            vratiSveAutomobileSO.execute(null);
        } catch (Exception e) {
            throw e;
        }
        return vratiSveAutomobileSO.getListaAutomobila();
    }

    public List<Vozac> getStorageVozac() throws SQLException {
        return storageVozac.getAll();
    }

    public List<TipAutomobila> getStorageTipovi() throws SQLException {
        return storageTipovi.getAll();
    }

    public Automobil getAutomobilByRegBroj(String RegBroj) throws Exception {
        FindCarSO nadjiAuto = new FindCarSO();
        try {
            nadjiAuto.execute(RegBroj);
        } catch (Exception e) {
            throw e;
        }
        return nadjiAuto.getAutomobil();
//        Automobil auto = new Automobil();
//        try {
//
//            storageAutomobil.connect();
//            auto = storageAutomobil.getByID(RegBroj);
//            if (auto.getRegistracioniBroj() == null) {
//                throw new Exception("Automobil sa registracionim brojem " + RegBroj + " ne postoji u sistemu!");
//            }
//            storageAutomobil.commit();
//        } catch (SQLException ex) {
//            storageAutomobil.rollback();
//            throw new Exception("Neuspesna pretraga automobila!");
//        } finally {
//            storageAutomobil.disconnect();
//        }
//
//        return auto;
    }

    public void dodaj(PotvrdaOIznajmljivanju potvrda) throws Exception {
        try {
            AbstractSO dodajPotvrduSO = new AddPotvrdaSO();
            dodajPotvrduSO.execute(potvrda);

        } catch (Exception e) {
            throw e;
        }
//        storagePotvrda.connect();
//        try {
//            if (!(storagePotvrda.getAll().contains(potvrda))) {
//                storagePotvrda.add(potvrda);
//                storagePotvrda.commit();
//            } else {
//                throw new Exception("Potvrda vec postoji!");
//            }
//        } catch (Exception e) {
//            storagePotvrda.rollback();
//            throw e;
//        } finally {
//            storagePotvrda.disconnect();
//        }

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
            FindPotvrdaSO pronadjiPotvrduSO = new FindPotvrdaSO();
        try {
            pronadjiPotvrduSO.execute(id);

        } catch (Exception e) {
            throw e;
        }
        return pronadjiPotvrduSO.getPotvrda();
        
//        PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();
//        try {
//            storagePotvrda.connect();
//            potvrda = storagePotvrda.getByID(id);
//            if (potvrda.getPotvrdaID() == 0) {
//                throw new Exception("Potvrda sa ID:" + id + " ne postoji u sistemu");
//            }
//            storagePotvrda.commit();
//        } catch (SQLException ex) {
//            throw ex;
//        } finally {
//            storagePotvrda.disconnect();
//        }
//        return potvrda;
    }

    public void izmeniPotvrdu(PotvrdaOIznajmljivanju potvrda) throws Exception {
        try {
            AbstractSO izmeniPotvrduSO = new EditPotvrdaSO();
            izmeniPotvrduSO.execute(potvrda);

        } catch (Exception e) {
            throw e;
        }
//        try {
//            storagePotvrda.connect();
//            storagePotvrda.edit(potvrda);
//            storagePotvrda.commit();
//
//        } catch (SQLException ex) {
//            storagePotvrda.rollback();
//            throw new Exception("Neuspesna izmena potvrde!");
//        } finally {
//            storagePotvrda.disconnect();
//        }
    }

    public void obrisiPotvrdu(PotvrdaOIznajmljivanju p) throws Exception {
        try {
            AbstractSO izbrisiPotvrduSO = new DeletePotvrdaSO();
            izbrisiPotvrduSO.execute(p);

        } catch (Exception e) {
            throw e;
        }
//        try {
//            storagePotvrda.connect();
//            storagePotvrda.delete(p);
//            storagePotvrda.commit();
//
//        } catch (SQLException ex) {
//            storagePotvrda.rollback();
//            throw new Exception("Neuspesno brisanje potvrde!");
//        } finally {
//            storagePotvrda.disconnect();
//        }
    }

    public List<PotvrdaOIznajmljivanju> getPotvrde() throws Exception {
        GetPotvrdeSO vratiPotvrdeSO = new GetPotvrdeSO();
        try {
            vratiPotvrdeSO.execute(null);

        } catch (Exception e) {
            throw e;
        }
        return vratiPotvrdeSO.getListaPotvrda();
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
