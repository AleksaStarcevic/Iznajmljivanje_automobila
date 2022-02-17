/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.automobil;

import domen.Automobil;
import domen.OpstiDomenskiObjekat;
import repository.impl.RepositoryAutomobil;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class DeleteCarSO extends AbstractSO {

    

    

    @Override
    protected void precondition(Object param) throws Exception {
         if (param == null || !(param instanceof Automobil)) {
            throw new Exception("Pogresan param");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
       brokerBaze.obrisi((OpstiDomenskiObjekat)param);
    }
    
    

}
