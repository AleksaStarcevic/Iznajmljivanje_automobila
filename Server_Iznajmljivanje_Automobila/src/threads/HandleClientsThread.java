/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import communication.Operations;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import controller.Kontroler;
import domen.Automobil;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import domen.PotvrdaOIznajmljivanju;
import domen.TipAutomobila;
import domen.Vozac;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class HandleClientsThread extends Thread {

    private Socket socket;
    private Korisnik prijavljeniKorisnik;

    public HandleClientsThread(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                Request request = (Request) new Receiver(socket).receive();
                Response response = new Response();
                int operation = request.getOperation();
                switch (operation) {
                    case Operations.LOGIN:
                        response = login(request);

                        break;
                    case Operations.ADD_CAR:
                        response = addCar(request);

                        break;

                    case Operations.GET_CAR_TYPES:
                        response = getCarTypes();
                        break;
                    case Operations.FIND_CAR:
                        response = getCarById(request);
                        break;
                    case Operations.GET_CARS:
                        response = getCars();
                        break;
                    case Operations.EDIT_CAR:
                        response = editCar(request);
                        break;
                    case Operations.DELETE_CAR:
                        response = deleteCar(request);
                        break;
                    case Operations.GET_DRIVERS:
                        response = getDrivers();
                        break;
                    case Operations.GET_POTVRDE:
                        response = getConfirmation();
                        break;

                    case Operations.ADD_CONFIRMATION:
                        response = addConfirmation(request);
                        break;
                    case Operations.FIND_CONFIRMATION:
                        response = findConfirmation(request);
                        break;
                    case Operations.DELETE_CONFIRMATION:
                        response = deleteConfirmation(request);
                        break;
                    case Operations.EDIT_CONFIRMATION:
                        response = editConfirmation(request);
                        break;
                    case Operations.ADD_DRIVER:
                        response = addDriver(request);
                        break;
                    case Operations.FIND_DRIVER:
                         response = findDriver(request);
                         break;
                         case Operations.EDIT_DRIVER:
                         response = editDriver(request);
                         break;
                    

                    default:
                }

                // vracam odgovor klijentu               
                new Sender(socket).send(response);

            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public Korisnik getPrijavljeniKorisnik() {
        return prijavljeniKorisnik;
    }

    private Response login(Request request) {
        Response response = new Response();
        Korisnik requestKorisnik = (Korisnik) request.getArgument();

        try {

            Korisnik korisnik = (Korisnik) Kontroler.getInstanca().login(requestKorisnik);
            if (Kontroler.getInstanca().getPrijavljeni().contains(korisnik)) {
                throw new Exception("Korisnik " + korisnik.getKorisnickoIme() + " je vec ulogovan na sistem!");
            }
            Kontroler.getInstanca().getPrijavljeni().add(korisnik);

            System.out.println("Uspesna prijava");
            prijavljeniKorisnik = korisnik;
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(korisnik);
        } catch (Exception ex) {
            ex.printStackTrace();
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response addCar(Request request) {
        Response response = new Response();
        Automobil auto = (Automobil) request.getArgument();
        try {
            Kontroler.getInstanca().dodajAutomobil(auto);
            response.setResponseType(ResponseType.SUCCESS);

        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getCarTypes() {
        Response response = new Response();
        try {
            response.setResult(Kontroler.getInstanca().getStorageTipovi(new TipAutomobila()));
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }

        return response;
    }

    private Response getCarById(Request request) {
        Response response = new Response();
        String regBroj = (String) request.getArgument();
        Automobil autom = new Automobil();
        autom.setRegistracioniBroj(regBroj);
        try {
            OpstiDomenskiObjekat auto = Kontroler.getInstanca().getAutomobilByRegBroj(autom);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(auto);

        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getCars() {
        Response response = new Response();
        ArrayList<OpstiDomenskiObjekat> automobili;
        try {
            automobili = Kontroler.getInstanca().getStorageAutomobili(new Automobil());
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(automobili);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response editCar(Request request) {
        Response response = new Response();
        Automobil auto = (Automobil) request.getArgument();
        try {
            Kontroler.getInstanca().izmeniAutomobil(auto);
            response.setResponseType(ResponseType.SUCCESS);

        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response deleteCar(Request request) {
        Response response = new Response();
        Automobil auto = (Automobil) request.getArgument();
        try {
            Kontroler.getInstanca().obrisiAutomobil(auto);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getDrivers() {
        Response response = new Response();
        ArrayList<OpstiDomenskiObjekat> vozaci = new ArrayList<>();
        try {
            vozaci = (ArrayList<OpstiDomenskiObjekat>) Kontroler.getInstanca().getStorageVozac(new Vozac());
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(vozaci);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getConfirmation() {
        Response response = new Response();
        ArrayList<OpstiDomenskiObjekat> potvrde;
        try {
            potvrde = (ArrayList<OpstiDomenskiObjekat>) Kontroler.getInstanca().getPotvrde(new PotvrdaOIznajmljivanju());
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(potvrde);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response addConfirmation(Request request) {
        Response response = new Response();
        PotvrdaOIznajmljivanju potvrda = (PotvrdaOIznajmljivanju) request.getArgument();
        try {
            Kontroler.getInstanca().dodaj(potvrda);
            response.setResponseType(ResponseType.SUCCESS);

        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response findConfirmation(Request request) {
        Response response = new Response();
        int id = (int) request.getArgument();
        PotvrdaOIznajmljivanju p = new PotvrdaOIznajmljivanju();
        p.setPotvrdaID(id);
        try {
            PotvrdaOIznajmljivanju potvrda = (PotvrdaOIznajmljivanju) Kontroler.getInstanca().getPotvrdaByID(p);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(potvrda);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response deleteConfirmation(Request request) {
        Response response = new Response();
        PotvrdaOIznajmljivanju potvrda = (PotvrdaOIznajmljivanju) request.getArgument();
        try {
            Kontroler.getInstanca().obrisiPotvrdu(potvrda);
            response.setResponseType(ResponseType.SUCCESS);

        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response editConfirmation(Request request) {
        Response response = new Response();
        PotvrdaOIznajmljivanju potvrda = (PotvrdaOIznajmljivanju) request.getArgument();
        try {
            Kontroler.getInstanca().izmeniPotvrdu(potvrda);
            response.setResponseType(ResponseType.SUCCESS);
        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response addDriver(Request request) {
          Response response = new Response();
        Vozac v = (Vozac) request.getArgument();
        try {
            Kontroler.getInstanca().dodajVozaca(v);
            response.setResponseType(ResponseType.SUCCESS);

        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response findDriver(Request request) {
         Response response = new Response();
        int id  = (int) request.getArgument();
        Vozac vozac = new Vozac();
        vozac.setVozacID(id);
        try {
            OpstiDomenskiObjekat v = Kontroler.getInstanca().pronadjiVozaca(vozac);
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(v);

        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response editDriver(Request request) {
        Response response = new Response();
        Vozac vozac = (Vozac) request.getArgument();
        try {
            Kontroler.getInstanca().izmeniVozaca(vozac);
            response.setResponseType(ResponseType.SUCCESS);

        } catch (Exception ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

   

}
