/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import communication.Operations;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.ResponseType;
import communication.Sender;
import controller.Kontroler;
import domen.Automobil;
import domen.Korisnik;
import domen.PotvrdaOIznajmljivanju;
import domen.Vozac;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.startServer();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Cekam klijenta..");
        Socket socket = serverSocket.accept();

        handleClient(socket);
    }

    private void handleClient(Socket socket) {
        while (true) {
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

                    default:
                }

                // vracam odgovor klijentu               
                new Sender(socket).send(response);

            } catch (Exception ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    private Response login(Request request) {
        Response response = new Response();
        Korisnik requestKorisnik = (Korisnik) request.getArgument();

        try {
            Korisnik korisnik = Kontroler.getInstanca().login(requestKorisnik.getKorisnickoIme(), requestKorisnik.getSifra());
            System.out.println("Uspesna prijava");
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
            response.setResult(Kontroler.getInstanca().getStorageTipovi());
            response.setResponseType(ResponseType.SUCCESS);
        } catch (SQLException ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }

        return response;
    }

    private Response getCarById(Request request) {
        Response response = new Response();
        String regBroj = (String) request.getArgument();
        try {
            Automobil auto = Kontroler.getInstanca().getAutomobilByRegBroj(regBroj);
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
        ArrayList<Automobil> automobili = new ArrayList<>();
        try {
            automobili = (ArrayList<Automobil>) Kontroler.getInstanca().getStorageAutomobili();
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(automobili);
        } catch (SQLException ex) {
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
        ArrayList<Vozac> vozaci = new ArrayList<>();
        try {
            vozaci = (ArrayList<Vozac>) Kontroler.getInstanca().getStorageVozac();
            response.setResponseType(ResponseType.SUCCESS);
            response.setResult(vozaci);
        } catch (SQLException ex) {
            response.setResponseType(ResponseType.ERROR);
            response.setException(ex);
        }
        return response;
    }

    private Response getConfirmation() {
        Response response = new Response();
        ArrayList<PotvrdaOIznajmljivanju> potvrde = new ArrayList<>();
        try {
            potvrde = (ArrayList<PotvrdaOIznajmljivanju>) Kontroler.getInstanca().getPotvrde();
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
        try {
            PotvrdaOIznajmljivanju potvrda = Kontroler.getInstanca().getPotvrdaByID(id);
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

}
