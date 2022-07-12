/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;


import domen.Korisnik;
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
public class RepositoryKorisnik implements DbRepository<Korisnik,Integer> {
    private Connection connection;

    public RepositoryKorisnik() {
    }


    @Override
    public List<Korisnik> getAll() throws SQLException {
         try {
            List<Korisnik> korisnici = new ArrayList<>();
            String upit = "SELECT * FROM korisnik";
            connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while (rs.next()) {
                korisnici.add(new Korisnik(rs.getInt("korisnikID"), rs.getString("korisnickoIme"), rs.getString("sifra")));

            }
            rs.close();
            statement.close();
            System.out.println("Uspesno vraceni korisnici!");
            return korisnici;
        } catch (SQLException ex) {
            System.out.println("Neuspesno vraceni korisnici!");
            throw ex;
        }
    }

    @Override
    public void add(Korisnik t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Korisnik t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Korisnik t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Korisnik getByID(Integer k) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
