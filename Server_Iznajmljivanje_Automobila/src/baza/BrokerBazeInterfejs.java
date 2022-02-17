/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author aleks
 */
public interface BrokerBazeInterfejs {
    public List<OpstiDomenskiObjekat> vratiSveBezUslova(OpstiDomenskiObjekat odo) throws Exception;
 
    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception;


    public void ubaci(OpstiDomenskiObjekat odo) throws Exception;

    public void izmeni(OpstiDomenskiObjekat odo) throws Exception;

   public void obrisi(OpstiDomenskiObjekat odo) throws Exception;
   public OpstiDomenskiObjekat pronadji(OpstiDomenskiObjekat odo) throws Exception;
}
