/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.communication;

import communication.Operations;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domen.Automobil;
import domen.Korisnik;
import domen.PotvrdaOIznajmljivanju;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author aleks
 */
public class Communication {
    private static Communication instance;
    private Socket socket;
    private Korisnik ulogovani;

    private Communication() {
    }

    public static Communication getInstance() {
        if(instance == null){
            instance = new Communication();
        }
        return instance;
    }
    
   

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setUlogovaniKorisnik(Korisnik korisnik) {
        this.ulogovani = korisnik;
    }

    public Korisnik getUlogovani() {
        return ulogovani;
    }
    
    
    
     public Response login(Request request) throws Exception{
        new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
        
    }
    

    public Response addCar(Request request) throws Exception {
        new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }
    
    public Response getCarTypes(Request request) throws Exception{
         new Sender(socket).send(request);
         return (Response) new Receiver(socket).receive();
        
    }
    
   

    public Response getCarById(Request request) throws Exception{
        new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }

    public Response getCars(Request request) throws Exception {
       
         new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
        
    }

    public Response editCar(Request request) throws Exception{
          new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }

    public Response deleteCar(Request request) throws Exception{
         new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }

    public Response getDrivers(Request request) throws Exception{
         
         new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }
    
     public Response getConfirmations(Request request) throws Exception{
         
         new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }
     
     public Response addConfirmation(Request request) throws Exception{
          new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
     }

    public Response findConfirmation(Request request) throws Exception{
        new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }

    public Response deleteConfirmation(Request request) throws Exception {
        new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }

    public Response editConfirmation(Request request) throws Exception{
         new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }

    public Response addDriver(Request request) {
        new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }

    public Response getDriverById(Request request) {
        new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }

    public Response editDriver(Request request) {
        new Sender(socket).send(request);
        
        return (Response) new Receiver(socket).receive();
    }
    
    
    
}
