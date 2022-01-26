/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import java.sql.SQLException;

/**
 *
 * @author aleks
 */
public class DbRepository {
    public void connect() throws SQLException{
        DbConnectionFactory.getInstance().getConnection();
    }
    
    public void disconnect() throws SQLException{
        DbConnectionFactory.getInstance().getConnection().close();
    }
    
    public void commit() throws SQLException{
        DbConnectionFactory.getInstance().getConnection().commit();
    }
    
    public void rollback() throws SQLException{
        DbConnectionFactory.getInstance().getConnection().rollback();
    }
    
    
    
}
