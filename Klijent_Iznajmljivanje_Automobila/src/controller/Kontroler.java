/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import client.communication.Communication;
import communication.Operations;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import domen.Automobil;
import domen.Korisnik;
import domen.PotvrdaOIznajmljivanju;
import domen.TipAutomobila;
import domen.Vozac;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aleks
 */
public class Kontroler {

    private static Kontroler instanca;
    private Korisnik ulogovaniKorisnik;

    private Kontroler() {
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public Korisnik getUlogovaniKorisnik() {
        return ulogovaniKorisnik;
    }

    public void setUlogovaniKorisnik(Korisnik ulogovaniKorisnik) {
        this.ulogovaniKorisnik = ulogovaniKorisnik;
    }

    public Korisnik login(String username, String password) throws Exception {
        Korisnik korisnik = new Korisnik(username, password);
        Request request = new Request(Operations.LOGIN, korisnik);
        Response response = Communication.getInstance().login(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            Korisnik ulogovan = (Korisnik) response.getResult();
            setUlogovaniKorisnik(ulogovan);
            return ulogovan;
        } else {
            throw response.getException();
        }
    }

    public List<TipAutomobila> getStorageTipovi() throws Exception {
        Request request = new Request(Operations.GET_CAR_TYPES);
        Response response = Communication.getInstance().getCarTypes(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            ArrayList<TipAutomobila> tipovi = (ArrayList<TipAutomobila>) response.getResult();
            return tipovi;
        } else {
            throw response.getException();
        }

    }

    public void dodajAutomobil(Automobil auto) throws Exception {
        Request request = new Request(Operations.ADD_CAR, auto);
        Response response = Communication.getInstance().addCar(request);

        if (!response.getResponseType().equals(ResponseType.SUCCESS)) {
            throw response.getException();

        }
    }

    public void izmeniAutomobil(Automobil auto) throws Exception {
        Request request = new Request(Operations.EDIT_CAR, auto);
        Response response = Communication.getInstance().editCar(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) {
            throw response.getException();

        }
    }

    public Automobil getAutomobilByRegBroj(String regBroj) throws Exception {
        Request request = new Request(Operations.FIND_CAR, regBroj);
        Response response = Communication.getInstance().getCarById(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return (Automobil) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void obrisiAutomobil(Automobil pretrazenAuto) throws Exception {
        Request request = new Request(Operations.DELETE_CAR, pretrazenAuto);
        Response response = Communication.getInstance().deleteCar(request);

        if (!response.getResponseType().equals(ResponseType.SUCCESS)) {
            throw response.getException();
        }

    }

    public List<Automobil> getStorageAutomobili() throws Exception {
        Request request = new Request(Operations.GET_CARS);
        Response response = Communication.getInstance().getCarTypes(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            ArrayList<Automobil> automobili = (ArrayList<Automobil>) response.getResult();
            return automobili;
        } else {
            throw response.getException();
        }
    }

    public void dodaj(PotvrdaOIznajmljivanju potvrda) throws Exception {
        Request request = new Request(Operations.ADD_CONFIRMATION, potvrda);
        Response response = Communication.getInstance().addConfirmation(request);
        if (!response.getResponseType().equals(ResponseType.SUCCESS)) {
            throw response.getException();
        }
    }

    public PotvrdaOIznajmljivanju getPotvrdaByID(int id) throws Exception {
        Request request = new Request(Operations.FIND_CONFIRMATION, id);
        Response response = Communication.getInstance().findConfirmation(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return (PotvrdaOIznajmljivanju) response.getResult();

        } else {
            throw response.getException();

        }
    }

    public void obrisiPotvrdu(PotvrdaOIznajmljivanju potvrdaPretrazena) throws Exception {
        Request request = new Request(Operations.DELETE_CONFIRMATION, potvrdaPretrazena);
        Response response = Communication.getInstance().deleteConfirmation(request);

        if (!response.getResponseType().equals(ResponseType.SUCCESS)) {
            throw response.getException();
        }
    }

    public List<Vozac> getStorageVozac() throws Exception {
        Request request = new Request(Operations.GET_DRIVERS);
        Response response = Communication.getInstance().getDrivers(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            List<Vozac> vozaci = (List<Vozac>) response.getResult();
            return vozaci;
        } else {
            throw response.getException();

        }
    }

    public List<PotvrdaOIznajmljivanju> getPotvrde() throws Exception {
        Request request = new Request(Operations.GET_POTVRDE);
        Response response = Communication.getInstance().getConfirmations(request);
        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            List<PotvrdaOIznajmljivanju> potvrde = (List<PotvrdaOIznajmljivanju>) response.getResult();
            return potvrde;
        } else {
            throw response.getException();

        }
    }

    public void izmeniPotvrdu(PotvrdaOIznajmljivanju potvrda) throws Exception {
        Request request = new Request(Operations.EDIT_CONFIRMATION, potvrda);
        Response response = Communication.getInstance().editConfirmation(request);

        if (!response.getResponseType().equals(ResponseType.SUCCESS)) {
            throw response.getException();

        }
    }

    public void dodajVozaca(Vozac v) throws Exception {
        Request request = new Request(Operations.ADD_DRIVER, v);
        Response response = Communication.getInstance().addDriver(request);

        if (!response.getResponseType().equals(ResponseType.SUCCESS)) {
            throw response.getException();

        }
        
    }

    public List<Vozac> getVozaci() throws Exception {
         Request request = new Request(Operations.GET_DRIVERS);
        Response response = Communication.getInstance().getDrivers(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            ArrayList<Vozac> vozaci = (ArrayList<Vozac>) response.getResult();
            return vozaci;
        } else {
            throw response.getException();
        }
    }
    
    public Vozac getVozacByID(int id) throws Exception{
         Request request = new Request(Operations.FIND_DRIVER, id);
        Response response = Communication.getInstance().getDriverById(request);

        if (response.getResponseType().equals(ResponseType.SUCCESS)) {
            return (Vozac) response.getResult();
        } else {
            throw response.getException(); 
        }
        
    }

    public void izmeniVozaca(Vozac v) throws Exception {
         Request request = new Request(Operations.EDIT_DRIVER, v);
        Response response = Communication.getInstance().editDriver(request);

        if (!response.getResponseType().equals(ResponseType.SUCCESS)) {
            throw response.getException();

        }
    }

}
