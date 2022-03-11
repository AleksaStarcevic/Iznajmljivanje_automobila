/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vozac;

import domen.OpstiDomenskiObjekat;
import domen.Vozac;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class EditVozacSO extends AbstractSO{

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Vozac)) {
            throw new Exception("Pogresan param");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        brokerBaze.izmeni((OpstiDomenskiObjekat) param);
    }
    
}
