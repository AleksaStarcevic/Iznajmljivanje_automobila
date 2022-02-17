/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.potvrda;

import domen.OpstiDomenskiObjekat;
import domen.PotvrdaOIznajmljivanju;
import java.util.ArrayList;

import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class AddPotvrdaSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof PotvrdaOIznajmljivanju)) {
            throw new Exception("Pogresan param");
        }
        ArrayList<OpstiDomenskiObjekat> lista = (ArrayList<OpstiDomenskiObjekat>) brokerBaze.vratiSve((OpstiDomenskiObjekat) param);

        if (lista.contains((OpstiDomenskiObjekat) param)) {
            throw new Exception();
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        brokerBaze.ubaci((OpstiDomenskiObjekat) param);
    }

}
