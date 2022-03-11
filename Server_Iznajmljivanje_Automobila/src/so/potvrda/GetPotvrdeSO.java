/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.potvrda;

import domen.OpstiDomenskiObjekat;
import domen.PotvrdaOIznajmljivanju;
import java.util.ArrayList;
import java.util.List;
import repository.impl.RepositoryPotvrda;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class GetPotvrdeSO extends AbstractSO {

    private List<OpstiDomenskiObjekat> listaPotvrda;

    

    @Override
    protected void precondition(Object param) throws Exception {

        if (param == null || !(param instanceof PotvrdaOIznajmljivanju)) {
            throw new Exception("Pogresan param");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        listaPotvrda =  brokerBaze.vratiSve((OpstiDomenskiObjekat)param);
        
     
        // vratim sve potvrde
        // vratim termin na osnovu idja
        //  prodjem kroz potvrde i napunim termine u potvrdu ako su im idjevi isti!
        
    }

    public List<OpstiDomenskiObjekat> getListaPotvrda() {
        return listaPotvrda;
    }

   
}
