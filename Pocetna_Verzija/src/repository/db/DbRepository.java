/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import java.sql.SQLException;
import repository.spec.Repository;

/**
 *
 * @author aleks
 */
public interface DbRepository<T, K> extends Repository<T, K>{
    default void connect() throws SQLException{
        DbConnectionFactory.getInstance().getConnection();
    }
    
    default void disconnect() throws SQLException{
        DbConnectionFactory.getInstance().getConnection().close();
    }
    
    default void commit() throws SQLException{
        DbConnectionFactory.getInstance().getConnection().commit();
    }
    
    default void rollback() throws SQLException{
        DbConnectionFactory.getInstance().getConnection().rollback();
    }
    
    
    
}
