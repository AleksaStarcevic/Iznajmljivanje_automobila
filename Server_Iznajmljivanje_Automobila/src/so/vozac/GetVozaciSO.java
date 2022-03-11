/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vozac;

import domen.OpstiDomenskiObjekat;
import domen.Vozac;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class GetVozaciSO extends AbstractSO {

    private ArrayList<OpstiDomenskiObjekat> listaVozaca;

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Vozac)) {
            throw new Exception("Pogresan parametar");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        listaVozaca = (ArrayList<OpstiDomenskiObjekat>) brokerBaze.vratiSveBezUslova((OpstiDomenskiObjekat)param);
    }

    public ArrayList<OpstiDomenskiObjekat> getListaVozaca() {
        return listaVozaca;
    }
    
    

}
