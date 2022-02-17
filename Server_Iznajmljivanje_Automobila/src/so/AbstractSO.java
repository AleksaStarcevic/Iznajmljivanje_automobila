/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import baza.BrokerBaze;
import baza.BrokerBazeInterfejs;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author aleks
 */
public abstract class AbstractSO {

    protected BrokerBaze brokerBaze;

    public AbstractSO() {
        brokerBaze = new BrokerBaze();
    }

    public void execute(Object param) throws Exception {
        try {
            precondition(param);
            startTransaction();
            executeOperation(param);
            commitTransaction();
            System.out.println("Uspesno izvrsena operacija!");
        } catch (Exception e) {
            System.out.println("NEUspesno izvrsena operacija!");
            rollbackTransaction();
            throw e;
        } finally {
            closeConnection();
        }

    }

    protected abstract void precondition(Object param) throws Exception;

    protected abstract void executeOperation(Object param) throws Exception;

    protected void startTransaction() throws Exception {
      
    }

    protected void closeConnection() throws Exception {
        DbConnectionFactory.getInstance().getConnection().close();
    }

    protected void rollbackTransaction() throws Exception {
        DbConnectionFactory.getInstance().getConnection().rollback();
    }

    protected void commitTransaction() throws Exception {
        DbConnectionFactory.getInstance().getConnection().commit();
    }
}
