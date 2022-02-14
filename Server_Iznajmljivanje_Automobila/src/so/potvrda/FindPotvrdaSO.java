/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.potvrda;

import domen.PotvrdaOIznajmljivanju;
import repository.impl.RepositoryPotvrda;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class FindPotvrdaSO extends AbstractSO {

    private final RepositoryPotvrda storagePotvrda;
    PotvrdaOIznajmljivanju potvrda;

    public FindPotvrdaSO() {
        this.storagePotvrda = new RepositoryPotvrda();
    }

    @Override
    protected void precondition(Object param) throws Exception {

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        potvrda = storagePotvrda.getByID((Integer) param);
        if (potvrda.getPotvrdaID() == 0) {
            throw new Exception("Potvrda sa ID:" + (Integer) param + " ne postoji u sistemu");
        }
    }

    public PotvrdaOIznajmljivanju getPotvrda() {
        return potvrda;
    }
    
    

    @Override
    protected void commitTransaction() throws Exception {
        storagePotvrda.commit();
    }

    @Override
    protected void rollbackTransaction() throws Exception {
        storagePotvrda.rollback();
    }

    @Override
    protected void closeConnection() throws Exception {
        storagePotvrda.disconnect();
    }
}
