/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.potvrda;

import domen.OpstiDomenskiObjekat;
import domen.PotvrdaOIznajmljivanju;
import domen.TerminVoznje;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class FindPotvrdaSO extends AbstractSO {

    OpstiDomenskiObjekat potvrda;

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof PotvrdaOIznajmljivanju)) {
            throw new Exception("Pogresan param");
        }

        ArrayList<OpstiDomenskiObjekat> lista = (ArrayList<OpstiDomenskiObjekat>) brokerBaze.vratiSve((OpstiDomenskiObjekat) param);

        if (!lista.contains((OpstiDomenskiObjekat) param)) {
            throw new Exception();
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
       TerminVoznje terminVoznje = new TerminVoznje(); 
       PotvrdaOIznajmljivanju potv = (PotvrdaOIznajmljivanju) param;
       terminVoznje.setPotvrda(potv);
        potvrda = brokerBaze.pronadji(terminVoznje);
       
        
    }

    public OpstiDomenskiObjekat getPotvrda() {
        return potvrda;
    }

}
