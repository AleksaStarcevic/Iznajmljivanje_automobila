/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import repository.db.DbRepository;

/**
 *
 * @author aleks
 */
public abstract class AbstractSO {
   
  

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
        }finally{
            closeConnection();
        }

    }

    protected abstract void precondition(Object param) throws Exception;

    protected abstract void executeOperation(Object param)throws Exception;

    protected void startTransaction()throws Exception {
        
    }
    
    protected void closeConnection()throws Exception {
        
    }

    protected void rollbackTransaction()throws Exception {

    }

    protected void commitTransaction() throws Exception{
    }
}
