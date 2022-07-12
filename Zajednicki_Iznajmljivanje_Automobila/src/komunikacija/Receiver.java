/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class Receiver {
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }
    
    public Object receive(){
        ObjectInputStream in;
        Object object = new Object();
        try {
            in = new ObjectInputStream(socket.getInputStream());
            object = in.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
//            throw new Exception("Greska u prijemu objekta:"+ex.getMessage());
        }
        return object;
    }
}
