/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.automobil;

import domen.Automobil;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import repository.impl.RepositoryAutomobil;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class FindCarSO extends AbstractSO {

    OpstiDomenskiObjekat automobil;

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Automobil)) {
            throw new Exception("Pogresan param");
        }

        ArrayList<OpstiDomenskiObjekat> lista = (ArrayList<OpstiDomenskiObjekat>) brokerBaze.vratiSve((OpstiDomenskiObjekat) param);
        
        if (!lista.contains((OpstiDomenskiObjekat) param)) {
            throw new Exception();
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        automobil = brokerBaze.pronadji((OpstiDomenskiObjekat) param);

    }

    public OpstiDomenskiObjekat getAutomobil() {
        return automobil;
    }

}
