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
public class FindCarSO extends AbstractSO {

    private final RepositoryAutomobil storageAutomobil;
    Automobil automobil;

    public FindCarSO() {
        this.storageAutomobil = new RepositoryAutomobil();
    }

    @Override
    protected void precondition(Object param) throws Exception {
      

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        automobil = storageAutomobil.getByID(param.toString());
        if (automobil.getRegistracioniBroj() == null) {
            throw new Exception("Automobil sa registracionim brojem " + param.toString() + " ne postoji u sistemu!");
        }
    }

    public Automobil getAutomobil() {
        return automobil;
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
