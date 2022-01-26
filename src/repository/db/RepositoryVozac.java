/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import domen.Vozac;
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
public class RepositoryVozac extends DbRepository{
//    List<Vozac> vozaci;
    private Connection connection;

    public RepositoryVozac() {
//        vozaci = new ArrayList<>();
//        vozaci.add(new Vozac(1, "Aleksa", "Star", "alek1@gmail.com", "Volgina"));
//        vozaci.add(new Vozac(2, "Nikola", "Cvet", "nik7@gmail.com", "Gige"));
//        vozaci.add(new Vozac(3, "Aleksa", "Visnja", "visn3@gmail.com", "Medak"));
    }

    public List<Vozac> getVozaci() throws SQLException {
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
    
   
    
    
}
