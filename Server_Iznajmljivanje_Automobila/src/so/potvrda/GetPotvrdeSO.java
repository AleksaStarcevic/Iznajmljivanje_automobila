/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.potvrda;

import domen.PotvrdaOIznajmljivanju;
import java.util.List;
import repository.impl.RepositoryPotvrda;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class GetPotvrdeSO extends AbstractSO{
    private final RepositoryPotvrda storagePotvrda;
    private List<PotvrdaOIznajmljivanju> listaPotvrda;

    public GetPotvrdeSO() {
        this.storagePotvrda = new RepositoryPotvrda();
    }

    @Override
    protected void precondition(Object param) throws Exception {
       
       
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
       listaPotvrda = storagePotvrda.getAll();
    }

    public List<PotvrdaOIznajmljivanju> getListaPotvrda() {
        return listaPotvrda;
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
