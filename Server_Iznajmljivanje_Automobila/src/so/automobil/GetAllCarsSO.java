/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.automobil;

import domen.Automobil;
import domen.OpstiDomenskiObjekat;
import domen.TipAutomobila;
import java.util.ArrayList;
import java.util.List;
import repository.impl.RepositoryAutomobil;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class GetAllCarsSO extends AbstractSO{

private ArrayList<OpstiDomenskiObjekat> listaAutomobila;

   


    @Override
    protected void precondition(Object param) throws Exception {
       if (param == null || !(param instanceof Automobil)) {
            throw new Exception("Pogresan parametar");
        }
    }

   
    
     @Override
    protected void executeOperation(Object param) throws Exception {
         listaAutomobila = (ArrayList<OpstiDomenskiObjekat>) brokerBaze.vratiSve((OpstiDomenskiObjekat)param);
    }

    public ArrayList<OpstiDomenskiObjekat> getListaAutomobila() {
        return listaAutomobila;
    }
    
    

   
    
}
