/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.automobil;

import domen.Automobil;
import repository.impl.RepositoryAutomobil;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class AddCarSO extends AbstractSO {

    private final RepositoryAutomobil storageAutomobil;

    public AddCarSO() {
        storageAutomobil = new RepositoryAutomobil();
    }

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof Automobil)) {
            throw new Exception("Pogresan param");
        }
        Automobil auto = (Automobil) param;
        
        if (storageAutomobil.getAll().contains(auto)) {
            throw new Exception("Automobil sa registarskom oznakom:" + auto.getRegistracioniBroj() + " vec postoji u sistemu!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        storageAutomobil.add((Automobil) param);
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
