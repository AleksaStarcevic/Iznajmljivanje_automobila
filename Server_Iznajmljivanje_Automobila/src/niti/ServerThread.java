/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import konfiguracija.PodesavanjaKonekcije;
import domen.Korisnik;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import forma.FrmMain;

/**
 *
 * @author aleks
 */
public class ServerThread extends Thread{
   private ServerSocket serverSocket;
   private static List<HandleClientsThread> clients;
   
    public ServerThread() throws IOException {
//        serverSocket = new ServerSocket(9000);
          serverSocket = new ServerSocket(Integer.parseInt(PodesavanjaKonekcije.getInstance().getProperty("port")));
        clients = new ArrayList<>();
       
    }

    @Override
    public void run() {
       while(!serverSocket.isClosed()){
           try {
               Socket socket = serverSocket.accept();
               HandleClientsThread thread = new HandleClientsThread(socket);
               thread.start();
               clients.add(thread);
           } catch (IOException ex) {
              ex.printStackTrace();
           }
       }
       stopAllThreads();
    }
    
    private void stopAllThreads(){
        for (HandleClientsThread client : clients) {
            try {
                client.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
    
    public  static List<Korisnik> getPrijavljeniKorisnici(){
        List<Korisnik> korisnici = new ArrayList<>();
        for (HandleClientsThread client : clients) {
            korisnici.add(client.getPrijavljeniKorisnik());
        }
        return korisnici;
    }
    
    
    
    

    
    
    
    
}
