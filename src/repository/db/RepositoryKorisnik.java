/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import domen.Korisnik;
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
public class RepositoryKorisnik extends DbRepository {
//    private List<Korisnik> korisnici;
    private Connection connection;

    public RepositoryKorisnik() {
//        this.korisnici = new ArrayList<>();
//        korisnici.add(new Korisnik(1, "admin", "admin"));
    }

    public List<Korisnik> getKorisnici() throws SQLException {
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
    
    
    
    
    
}
