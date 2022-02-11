/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import podesavanja.PodesavanjaBaze;

/**
 *
 * @author aleks
 */
public class DbConnectionFactory {
    private Connection connection;
    private static DbConnectionFactory instance;

    private DbConnectionFactory() {
    }
    
    

    public static DbConnectionFactory getInstance() {
        if(instance== null){
            instance= new DbConnectionFactory();
        }
        return instance;
    }
    
    
   
    public Connection getConnection() throws SQLException{
        if (connection == null || connection.isClosed()) {
            try {
                String url = PodesavanjaBaze.getInstance().getProperty("url");
                String user = PodesavanjaBaze.getInstance().getProperty("username");
                String password = PodesavanjaBaze.getInstance().getProperty("password");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            } catch (SQLException ex) {
                System.out.println("Neuspesno uspostavljanje konekcije!\n" + ex.getMessage());
                throw ex;
            }
        }
        return connection;
    }
}
