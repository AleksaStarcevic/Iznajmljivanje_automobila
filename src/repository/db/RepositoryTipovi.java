/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import domen.TipAutomobila;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class RepositoryTipovi extends DbRepository{
    private Connection connection;
    public RepositoryTipovi() {
    }
    
     public List<TipAutomobila> vratiTipoveAutomobila() throws SQLException{
        ArrayList<TipAutomobila> tipovi = new ArrayList<>();
        
        try {
            String upit = "SELECT * FROM tipautomobila";
            connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            
            while(rs.next()){
                tipovi.add(new TipAutomobila(rs.getInt("tipID"), rs.getString("nazivTipa")));
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno vraceni tipovi!");
            return tipovi;
        } catch (SQLException ex) {
             System.out.println("Neuspesno vraceni tipovi!");
            throw ex;
        }
        
    }
    
}
