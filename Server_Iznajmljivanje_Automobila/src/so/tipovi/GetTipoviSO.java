/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipovi;

import domen.OpstiDomenskiObjekat;
import domen.TipAutomobila;
import java.util.List;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class GetTipoviSO extends AbstractSO{
     private List<OpstiDomenskiObjekat> listaTipova;
    
     @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof TipAutomobila)) {
            throw new Exception("Pogresan param");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        listaTipova = brokerBaze.vratiSveBezUslova((OpstiDomenskiObjekat)param);
    }

    public List<OpstiDomenskiObjekat> getListaTipova() {
        return listaTipova;
    }
    
    
    
}
