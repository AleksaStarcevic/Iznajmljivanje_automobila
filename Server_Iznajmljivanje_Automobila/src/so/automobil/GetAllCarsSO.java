/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.automobil;

import domen.Automobil;
import domen.TipAutomobila;
import java.util.List;
import repository.impl.RepositoryAutomobil;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class GetAllCarsSO extends AbstractSO{
private final RepositoryAutomobil storageAutomobil;
private List<Automobil> listaAutomobila;

    public GetAllCarsSO() {
        this.storageAutomobil = new RepositoryAutomobil();
    }


    @Override
    protected void precondition(Object param) throws Exception {
       
    }

   
    
     @Override
    protected void executeOperation(Object param) throws Exception {
         listaAutomobila = storageAutomobil.getAll();
    }

    public List<Automobil> getListaAutomobila() {
        return listaAutomobila;
    }
    
    

    @Override
    protected void commitTransaction() throws Exception {
        storageAutomobil.commit();
    }

    @Override
    protected void rollbackTransaction() throws Exception {
        storageAutomobil.rollback();
    }

  

    @Override
    protected void closeConnection() throws Exception {
        storageAutomobil.disconnect();
    }
    
}
