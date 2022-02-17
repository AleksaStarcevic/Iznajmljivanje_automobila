/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza;

import domen.OpstiDomenskiObjekat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbConnectionFactory;

/**
 *
 * @author aleks
 */
public class BrokerBaze implements BrokerBazeInterfejs {

    @Override
    public List<OpstiDomenskiObjekat> vratiSveBezUslova(OpstiDomenskiObjekat odo) throws Exception {
        // select from *
        ArrayList<OpstiDomenskiObjekat> lista;
        Connection konekcija = DbConnectionFactory.getInstance().getConnection();
        String upit = "SELECT * FROM " + odo.vratiImeKlase();
        System.out.println(upit);
        Statement stat = konekcija.createStatement();
        ResultSet rs = stat.executeQuery(upit);
        lista = odo.napuniSve(rs);
        rs.close();
        stat.close();
        return lista;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception {
        ArrayList<OpstiDomenskiObjekat> lista;
        Connection konekcija = DbConnectionFactory.getInstance().getConnection();
        String upit = "SELECT * FROM " + odo.vratiImeKlase() + " " + odo.vratiTabeluSaUslovomSpajanja();
        System.out.println(upit);
        Statement stat = konekcija.createStatement();
        ResultSet rs = stat.executeQuery(upit);
        lista = odo.napuniSve(rs);
        rs.close();
        stat.close();
        return lista;
    }

    @Override
    public void ubaci(OpstiDomenskiObjekat odo) throws Exception {

        Connection konekcija = DbConnectionFactory.getInstance().getConnection();
        String upit = "INSERT INTO " + odo.vratiImeKlase() + " VALUES (" + odo.vratiVrednostiAtributa() + ")";
        System.out.println(upit);
        PreparedStatement prepst = konekcija.prepareStatement(upit);
        prepst.executeUpdate(upit);
        prepst.close();

    }

    @Override
    public void izmeni(OpstiDomenskiObjekat odo) throws Exception {
        Connection konekcija = DbConnectionFactory.getInstance().getConnection();
        String upit = "UPDATE " + odo.vratiImeKlase() + " SET " + odo.postaviVrednostAtrbuta() + " WHERE " + odo.vratiUslovZaNadjiSlog();
        PreparedStatement prestat = konekcija.prepareStatement(upit);
        System.out.println(upit);
        prestat.executeUpdate(upit);
        prestat.close();
    }

    @Override
    public void obrisi(OpstiDomenskiObjekat odo) throws Exception {
        Connection konekcija = DbConnectionFactory.getInstance().getConnection();
        String upit = "DELETE FROM " + odo.vratiImeKlase() + " WHERE " + odo.vratiUslovZaNadjiSlog();
        PreparedStatement statement = konekcija.prepareStatement(upit);
        System.out.println(upit);
        statement.executeUpdate(upit);
        statement.close();
    }

    @Override
    public OpstiDomenskiObjekat pronadji(OpstiDomenskiObjekat odo) throws Exception {
        // select * join where

        Connection konekcija = DbConnectionFactory.getInstance().getConnection();
        String upit = "SELECT * FROM " + odo.vratiImeKlase() + " " + odo.vratiTabeluSaUslovomSpajanja() + " WHERE " + odo.vratiUslovZaNadjiSlog();
        System.out.println(upit);
        Statement stat = konekcija.createStatement();
        ResultSet rs = stat.executeQuery(upit);
        OpstiDomenskiObjekat rezultat = odo.napuni(rs);
        rs.close();
        stat.close();

        return rezultat;

    }

}
