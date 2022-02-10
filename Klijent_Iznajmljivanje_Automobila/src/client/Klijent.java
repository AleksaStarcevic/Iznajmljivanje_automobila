/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.communication.Communication;
import form.Login;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class Klijent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Klijent klijent = new Klijent();
        try {
            klijent.connect();
        } catch (IOException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void connect() throws IOException {

        Socket s = new Socket("127.0.0.1", 9000);
        System.out.println("Povezao se klijent");
        Communication.getInstance().setSocket(s);
        new Login().setVisible(true);
        

    }

}
