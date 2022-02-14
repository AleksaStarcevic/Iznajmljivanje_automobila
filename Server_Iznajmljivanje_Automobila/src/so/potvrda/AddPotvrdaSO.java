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
public class AddPotvrdaSO extends AbstractSO {

    private final RepositoryPotvrda storagePotvrda;

    public AddPotvrdaSO() {
        this.storagePotvrda = new RepositoryPotvrda();
    }

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof PotvrdaOIznajmljivanju)) {
            throw new Exception("Pogresan param");
        }
        PotvrdaOIznajmljivanju potvrda = (PotvrdaOIznajmljivanju) param;
        if (storagePotvrda.getAll().contains(potvrda)) {
            throw new Exception("Potvrda vec postoji!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        storagePotvrda.add((PotvrdaOIznajmljivanju) param);
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
