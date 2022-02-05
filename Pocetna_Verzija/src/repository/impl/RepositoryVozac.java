/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;


import domen.Vozac;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class RepositoryVozac implements DbRepository<Vozac,Integer>{
//    List<Vozac> vozaci;
    private Connection connection;

    public RepositoryVozac() {
//        vozaci = new ArrayList<>();
//        vozaci.add(new Vozac(1, "Aleksa", "Star", "alek1@gmail.com", "Volgina"));
//        vozaci.add(new Vozac(2, "Nikola", "Cvet", "nik7@gmail.com", "Gige"));
//        vozaci.add(new Vozac(3, "Aleksa", "Visnja", "visn3@gmail.com", "Medak"));
    }
    
    
    
    

    

    @Override
    public List<Vozac> getAll() throws SQLException {
        try {
            List<Vozac> vozaci = new ArrayList<>();
            String upit = "SELECT * FROM vozac";
            connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while (rs.next()) {
                vozaci.add(new Vozac(rs.getInt("vozacID"), rs.getString("ime"), rs.getString("prezime"), rs.getString("email"), rs.getString("adresa")));

            }
            rs.close();
            statement.close();
            System.out.println("Uspesno vraceni vozaci!");
            return vozaci;
        } catch (SQLException ex) {
            System.out.println("Neuspesno vraceni vozaci!");
            throw ex;
        }
    }

    @Override
    public void add(Vozac v) throws SQLException {
         try {
            String upit = "INSERT INTO vozac(vozacID,ime,prezime,email,adresa) VALUES(?,?,?,?,?)";
             connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);

            statement.setInt(1, v.getVozacID());
            statement.setString(2, v.getIme());
            statement.setString(3, v.getPrezime());
            statement.setString(4, v.getEmail());
            statement.setString(5, v.getAdresa());

            statement.executeUpdate();
            System.out.println("Uspesno kreiran vozac!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno kreiran vozac!");
            throw ex;
        }
    }

    @Override
    public void edit(Vozac v) throws SQLException {
        try {
            String upit = "UPDATE vozac SET ime=?,prezime=?,email=?,adresa=? WHERE vozacID=?";
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);
            
            statement.setInt(5, v.getVozacID());
            statement.setString(1, v.getIme());
            statement.setString(2, v.getPrezime());
            statement.setString(3, v.getEmail());
            statement.setString(4, v.getAdresa());
            
            statement.executeUpdate();
            System.out.println("Uspesno promenjen vozac!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno promenjen vozac!");
            throw ex;
        }
    }

    @Override
    public void delete(Vozac t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vozac getByID(Integer k) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
    
}
