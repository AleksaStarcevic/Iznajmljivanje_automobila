/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.Automobil;
import domen.Korisnik;
import domen.PotvrdaOIznajmljivanju;
import domen.TipAutomobila;
import domen.Vozac;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aleks
 */
public class DatabaseBroker {

    Connection connection;

    public void uspostaviKonekciju() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                String url = "jdbc:mysql://localhost:3306/iznajmljivanje_automobila";
                String user = "root";
                String password = "admin";
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException ex) {
                System.out.println("Neuspesno uspostavljanje konekcije!\n" + ex.getMessage());
                throw ex;
            }
        }
    }

    public void raskiniKonekciju() throws SQLException {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("Neuspesno raskidanje konekcije!\n" + ex.getMessage());
                throw ex;
            }
        }
    }
    public List<Korisnik> vratiKorisnike() throws SQLException {
        try {
            List<Korisnik> korisnici = new ArrayList<>();
            String upit = "SELECT * FROM korisnik";
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
    
    public List<TipAutomobila> vratiTipoveAutomobila() throws SQLException{
        ArrayList<TipAutomobila> tipovi = new ArrayList<>();
        
        try {
            String upit = "SELECT * FROM tipautomobila";
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
    
    

    public void kreirajVozaca(Vozac v) throws SQLException {
        try {
            String upit = "INSERT INTO vozac(vozacID,ime,prezime,email,adresa) VALUES(?,?,?,?,?)";
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

    public List<Vozac> vratiVozace() throws SQLException {
        try {
            List<Vozac> vozaci = new ArrayList<>();
            String upit = "SELECT * FROM vozac";
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

    public void izmeniVozaca(int id,Vozac v) throws SQLException {
        try {
            String upit = "UPDATE vozac SET ime=?,prezime=?,email=?,adresa=? WHERE vozacID=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            
            statement.setInt(5, id);
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
    
    
    public void kreirajAutomobil(Automobil automobil) throws SQLException{
        try {
            String upit = "INSERT INTO automobil(registracioniBroj,model,marka,tip) VALUES(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(upit);

            statement.setString(1, automobil.getRegistracioniBroj());
            statement.setString(2, automobil.getModel());
            statement.setString(3, automobil.getMarka());
            statement.setInt(4,automobil.getTip().getTipID());
            
            statement.executeUpdate();
            System.out.println("Uspesno kreiran automobil!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno kreiran automobil!");
            throw ex;
        }
    }
    
    
     public void izmeniAutomobil(String registracioniBroj,Automobil a) throws SQLException {
        try {
            String upit = "UPDATE automobil SET model=?,marka=?,tip=? WHERE registracioniBroj=?";
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
     
     public void obrisiAutomobil(String registracioniBroj) throws SQLException{
        try {
            String upit = "DELETE FROM automobil WHERE registracioniBroj=?";
            PreparedStatement statement = connection.prepareStatement(upit);
            
            statement.setString(1, registracioniBroj);
            statement.executeUpdate();
             System.out.println("Uspesno obrisan automobil!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno obrisan automobil!");
            throw ex;
        }
         
     }
     
     public List<Automobil> vratiAutomobile() throws SQLException {
        try {
            List<Automobil> automobili = new ArrayList<>();
            String upit = "SELECT * FROM automobil a JOIN tipautomobila t ON a.tip=t.tipID";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            while (rs.next()) {
                TipAutomobila tip = new TipAutomobila();
                tip.setTipID(rs.getInt("tipID"));
                tip.setNazivTipa(rs.getString("nazivTipa"));
                automobili.add(new Automobil(rs.getString("registracioniBroj"), rs.getString("model"), rs.getString("marka"),tip));

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
    
    

    public void kreirajPotvrdu(PotvrdaOIznajmljivanju potvrda) throws SQLException {
        try {
            String upit = "INSERT INTO potvrdaoiznajmljivanju(potvrdaID,datumOD,datumDO,cena,automobil,vozac,korisnik) VALUES(?,?,?,?,?,?,?)";
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
    
    public List<PotvrdaOIznajmljivanju> vratiPotvrde() throws SQLException{
            List<PotvrdaOIznajmljivanju> potvrde = new ArrayList<>();
        try {
            String upit = "SELECT * FROM potvrdaoiznajmljivanju p JOIN automobil a ON p.automobil = a.registracioniBroj JOIN vozac v ON p.vozac = v.vozacID JOIN korisnik k ON p.korisnik=k.korisnikID JOIN tipautomobila t ON a.tip=t.tipID";
            Statement statement = connection.createStatement();
          ResultSet rs =  statement.executeQuery(upit);
          
          while(rs.next()){
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
    
    
     public void sacuvajListuPotvrda(List<PotvrdaOIznajmljivanju> potvrde) throws SQLException {
        try {
            String upit = "INSERT INTO potvrdaoiznajmljivanju(potvrdaID,datumOD,datumDO,cena,automobil,vozac,korisnik) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(upit);
            
            for (PotvrdaOIznajmljivanju potvrda : potvrde) {
                
            statement.setInt(1, potvrda.getPotvrdaID());
            statement.setDate(2, new Date(potvrda.getDatumOD().getTime()));
            statement.setDate(3, new Date(potvrda.getDatumDO().getTime()));
            statement.setDouble(4, potvrda.getCena());
            statement.setString(5, potvrda.getAutomobil().getRegistracioniBroj());
            statement.setInt(6, potvrda.getVozac().getVozacID());
            statement.setInt(7, potvrda.getKorisnik().getKorisnikID());
            }

            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno kreirana lista potvrda!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno kreiranje liste potvrda!");
            throw ex;
        }
    }

}
