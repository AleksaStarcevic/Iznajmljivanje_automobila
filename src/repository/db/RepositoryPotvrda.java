/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.db;

import domen.Automobil;
import domen.Korisnik;
import domen.PotvrdaOIznajmljivanju;
import domen.TipAutomobila;
import domen.Vozac;
import java.sql.Connection;
import java.sql.Date;
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
public class RepositoryPotvrda extends DbRepository {
//    private List<PotvrdaOIznajmljivanju> potvrde;

    private Connection connection;

    public RepositoryPotvrda() {
//        potvrde = new ArrayList<>();
    }

    public void dodaj(PotvrdaOIznajmljivanju potvrda) throws SQLException {
        try {
            String upit = "INSERT INTO potvrdaoiznajmljivanju(potvrdaID,datumOD,datumDO,cena,automobil,vozac,korisnik) VALUES(?,?,?,?,?,?,?)";
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);

            statement.setInt(1, potvrda.getPotvrdaID());
            statement.setDate(2, new Date(potvrda.getDatumOD().getTime()));
            statement.setDate(3, new Date(potvrda.getDatumDO().getTime()));
            statement.setDouble(4, potvrda.getCena());
            statement.setString(5, potvrda.getAutomobil().getRegistracioniBroj());
            statement.setInt(6, potvrda.getVozac().getVozacID());
            statement.setInt(7, potvrda.getKorisnik().getKorisnikID());

            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreirana potvrda!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno kreiranje potvrde!");
            throw ex;
        }

    }

    public void dodajSvePotvrde(List<PotvrdaOIznajmljivanju> potvrde) throws SQLException {

        try {
            String upit = "INSERT INTO potvrdaoiznajmljivanju(potvrdaID,datumOD,datumDO,cena,automobil,vozac,korisnik) VALUES(?,?,?,?,?,?,?)";
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);

            for (PotvrdaOIznajmljivanju potvrda : potvrde) {
                statement.setInt(1, potvrda.getPotvrdaID());
                statement.setDate(2, new Date(potvrda.getDatumOD().getTime()));
                statement.setDate(3, new Date(potvrda.getDatumDO().getTime()));
                statement.setDouble(4, potvrda.getCena());
                statement.setString(5, potvrda.getAutomobil().getRegistracioniBroj());
                statement.setInt(6, potvrda.getVozac().getVozacID());
                statement.setInt(7, potvrda.getKorisnik().getKorisnikID());

                statement.executeUpdate();
            }
            statement.close();
            System.out.println("Uspesno kreirana lista potvrda!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno kreiranje liste potvrda!");
            throw ex;
        }

    }
    

    public List<PotvrdaOIznajmljivanju> getSvePotvrde() throws SQLException {
        List<PotvrdaOIznajmljivanju> potvrde = new ArrayList<>();
        try {
            String upit = "SELECT * FROM potvrdaoiznajmljivanju p JOIN automobil a ON p.automobil = a.registracioniBroj JOIN vozac v ON p.vozac = v.vozacID JOIN korisnik k ON p.korisnik=k.korisnikID JOIN tipautomobila t ON a.tip=t.tipID";
            connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {
                PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();
                potvrda.setPotvrdaID(rs.getInt("potvrdaID"));
                potvrda.setDatumOD(rs.getDate("datumOD"));
                potvrda.setDatumDO(rs.getDate("datumDO"));
                potvrda.setCena(rs.getDouble("cena"));

                TipAutomobila tip = new TipAutomobila();
                tip.setTipID(rs.getInt("tipID"));
                tip.setNazivTipa(rs.getString("nazivTipa"));

                Automobil automobil = new Automobil();
                automobil.setRegistracioniBroj(rs.getString("automobil"));
                automobil.setModel(rs.getString("model"));
                automobil.setMarka(rs.getString("marka"));
                automobil.setTip(tip);

                Korisnik korisnik = new Korisnik();
                korisnik.setKorisnikID(rs.getInt("korisnikID"));
                korisnik.setKorisnickoIme(rs.getString("korisnickoIme"));
                korisnik.setSifra(rs.getString("sifra"));

                Vozac vozac = new Vozac();
                vozac.setVozacID(rs.getInt("vozacID"));
                vozac.setIme(rs.getString("ime"));
                vozac.setPrezime(rs.getString("prezime"));
                vozac.setEmail(rs.getString("email"));
                vozac.setAdresa(rs.getString("adresa"));

                potvrda.setAutomobil(automobil);
                potvrda.setVozac(vozac);
                potvrda.setKorisnik(korisnik);

                potvrde.add(potvrda);

            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje potvrda!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno ucitavanje potvrda!");
            throw ex;
        }
        return potvrde;
    }
    
     public PotvrdaOIznajmljivanju vratiPotvrduByID(int ID) throws SQLException{
            PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();
        try {
            String upit = "SELECT * FROM potvrdaoiznajmljivanju p JOIN automobil a ON p.automobil = a.registracioniBroj JOIN vozac v ON p.vozac = v.vozacID JOIN korisnik k ON p.korisnik=k.korisnikID JOIN tipautomobila t ON a.tip=t.tipID WHERE p.potvrdaID="+ID;
             connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
          ResultSet rs =  statement.executeQuery(upit);
          
          while(rs.next()){
              
              potvrda.setPotvrdaID(rs.getInt("potvrdaID"));
              potvrda.setDatumOD(rs.getDate("datumOD"));
              potvrda.setDatumDO(rs.getDate("datumDO"));
              potvrda.setCena(rs.getDouble("cena"));
              
              TipAutomobila tip = new TipAutomobila();
              tip.setTipID(rs.getInt("tipID"));
              tip.setNazivTipa(rs.getString("nazivTipa"));
              
              Automobil automobil = new Automobil();
              automobil.setRegistracioniBroj(rs.getString("automobil"));
              automobil.setModel(rs.getString("model"));
              automobil.setMarka(rs.getString("marka"));
              automobil.setTip(tip);
              
              Korisnik korisnik = new Korisnik();
              korisnik.setKorisnikID(rs.getInt("korisnikID"));
              korisnik.setKorisnickoIme(rs.getString("korisnickoIme"));
              korisnik.setSifra(rs.getString("sifra"));
              
              Vozac vozac = new Vozac();
              vozac.setVozacID(rs.getInt("vozacID"));
              vozac.setIme(rs.getString("ime"));
              vozac.setPrezime(rs.getString("prezime"));
              vozac.setEmail(rs.getString("email"));
              vozac.setAdresa(rs.getString("adresa"));
              
              potvrda.setAutomobil(automobil);
              potvrda.setVozac(vozac);
              potvrda.setKorisnik(korisnik);
              
              
              
              
          }
           rs.close();
           statement.close();
           System.out.println("Uspesno ucitavanje potvrda!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno ucitavanje potvrda!");
            throw ex;
        }
         return potvrda;
    }

}
