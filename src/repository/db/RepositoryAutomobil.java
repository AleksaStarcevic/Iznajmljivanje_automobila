/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import domen.Automobil;
import domen.TipAutomobila;
import exception.ValidacijaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class RepositoryAutomobil extends DbRepository {
//    private List<Automobil> automobili;

    private Connection connection;

    public RepositoryAutomobil() {
//        this.automobili = new ArrayList<>();
//        automobili.add(new Automobil("BG041KL", "Logan", "Dacia", new TipAutomobila(1, "Sedan")));
//        automobili.add(new Automobil("BG031KL", "A4", "Audi", new TipAutomobila(1, "Sedan")));
//        automobili.add(new Automobil("BG567KL", "Golf", "Volkswagen", new TipAutomobila(2, "Hecbek")));
    }

    public List<Automobil> getAutomobili() throws SQLException {
        try {
            List<Automobil> automobili = new ArrayList<>();
            String upit = "SELECT * FROM automobil a JOIN tipautomobila t ON a.tip=t.tipID";
            connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while (rs.next()) {
                TipAutomobila tip = new TipAutomobila();
                tip.setTipID(rs.getInt("tipID"));
                tip.setNazivTipa(rs.getString("nazivTipa"));
                automobili.add(new Automobil(rs.getString("registracioniBroj"), rs.getString("model"), rs.getString("marka"), tip));

            }
            rs.close();
            statement.close();
            System.out.println("Uspesno vraceni automobili!");
            return automobili;
        } catch (SQLException ex) {
            System.out.println("Neuspesno vraceni automobili!");
            throw ex;
        }
    }

    public void kreirajAutomobil(Automobil automobil) throws SQLException {
        try {
            String upit = "INSERT INTO automobil(registracioniBroj,model,marka,tip) VALUES(?,?,?,?)";
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);

            statement.setString(1, automobil.getRegistracioniBroj());
            statement.setString(2, automobil.getModel());
            statement.setString(3, automobil.getMarka());
            statement.setInt(4, automobil.getTip().getTipID());

            statement.executeUpdate();
            System.out.println("Uspesno kreiran automobil!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno kreiran automobil!");
            throw ex;
        }
    }

    public void izmeniAutomobil(String registracioniBroj, Automobil a) throws SQLException {
        try {
           
            String upit = "UPDATE automobil SET model=?,marka=?,tip=? WHERE registracioniBroj=?";
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);

            statement.setString(4, registracioniBroj);
            statement.setString(1, a.getModel());
            statement.setString(2, a.getMarka());
            statement.setInt(3, a.getTip().getTipID());

            statement.executeUpdate();
            System.out.println("Uspesno promenjen automobil!");
            
        } catch (SQLException ex) {
            System.out.println("Neuspesno promenjen automobil!");
            throw ex;
        }
    }

    public void obrisiAutomobil(String registracioniBroj) throws SQLException {
        try {
            System.out.println(registracioniBroj);
            String upit = "DELETE FROM automobil WHERE registracioniBroj=?";
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);

            statement.setString(1, registracioniBroj);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Neuspesno obrisan automobil!");
            throw ex;
        }

    }

    public Automobil getAutomobilByRegBroj(String RegBroj) throws SQLException {
        try {
            Automobil automobil = new Automobil();

            String upit = "SELECT * FROM automobil a JOIN tipautomobila t ON a.tip=t.tipID WHERE registracioniBroj='" + RegBroj + "'";
            connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                TipAutomobila tip = new TipAutomobila();
                tip.setTipID(rs.getInt("tipID"));
                tip.setNazivTipa(rs.getString("nazivTipa"));
                automobil = new Automobil(rs.getString("registracioniBroj"), rs.getString("model"), rs.getString("marka"), tip);

            }

            rs.close();
            statement.close();
            return automobil;
        } catch (SQLException ex) {
            System.out.println("Neuspesno vraceni automobili!");
            throw ex;
        }
    }

}
