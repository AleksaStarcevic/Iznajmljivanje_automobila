/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;


import domen.TipAutomobila;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author aleks
 */
public class RepositoryTipovi implements DbRepository<TipAutomobila,Integer>{
    private Connection connection;
    public RepositoryTipovi() {
    }
    
    

    @Override
    public List<TipAutomobila> getAll() throws SQLException {
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

    @Override
    public void add(TipAutomobila t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(TipAutomobila t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(TipAutomobila t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipAutomobila getByID(Integer k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
