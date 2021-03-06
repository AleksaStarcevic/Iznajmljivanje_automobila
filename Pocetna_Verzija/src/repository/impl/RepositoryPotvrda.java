/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import domen.Automobil;
import domen.Korisnik;
import domen.PotvrdaOIznajmljivanju;
import domen.TerminVoznje;
import domen.TipAutomobila;
import domen.Vozac;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author aleks
 */
public class RepositoryPotvrda implements DbRepository<PotvrdaOIznajmljivanju, Integer> {
//    private List<PotvrdaOIznajmljivanju> potvrde;

    private Connection connection;

    public RepositoryPotvrda() {
//        potvrde = new ArrayList<>();
    }

    @Override
    public void add(PotvrdaOIznajmljivanju potvrda) throws SQLException {

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

            upit = "INSERT INTO termini_voznje VALUES(?,?,?,?)";
            statement = connection.prepareStatement(upit);
            for (TerminVoznje terminVoznje : potvrda.getTermini()) {
                statement.setInt(1, terminVoznje.getPotvrda().getPotvrdaID());
                statement.setInt(2, terminVoznje.getRedniBroj());
                statement.setDate(3, new Date(terminVoznje.getDan().getTime()));
                statement.setString(4, terminVoznje.getVreme());

                statement.executeUpdate();
            }

            statement.close();
            System.out.println("Uspesno kreirana lista potvrda!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno kreiranje liste potvrda!");
            throw ex;
        }

    }

    @Override
    public List<PotvrdaOIznajmljivanju> getAll() throws SQLException {
        List<PotvrdaOIznajmljivanju> potvrde = new ArrayList<>();
        TerminVoznje termin;

        try {

            connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String upit = "SELECT * FROM potvrdaoiznajmljivanju p JOIN automobil a ON p.automobil = a.registracioniBroj JOIN vozac v ON p.vozac = v.vozacID JOIN korisnik k ON p.korisnik=k.korisnikID JOIN tipautomobila t ON a.tip=t.tipID";
            ResultSet rsT = statement.executeQuery(upit);

            while (rsT.next()) {

                PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();
                ArrayList<TerminVoznje> termini = new ArrayList<>();

                potvrda.setPotvrdaID(rsT.getInt("potvrdaID"));
                potvrda.setDatumOD(rsT.getDate("datumOD"));
                potvrda.setDatumDO(rsT.getDate("datumDO"));
                potvrda.setCena(rsT.getDouble("cena"));

                TipAutomobila tip = new TipAutomobila();
                tip.setTipID(rsT.getInt("tipID"));
                tip.setNazivTipa(rsT.getString("nazivTipa"));

                Automobil automobil = new Automobil();
                automobil.setRegistracioniBroj(rsT.getString("automobil"));
                automobil.setModel(rsT.getString("model"));
                automobil.setMarka(rsT.getString("marka"));
                automobil.setTip(tip);

                Korisnik korisnik = new Korisnik();
                korisnik.setKorisnikID(rsT.getInt("korisnikID"));
                korisnik.setKorisnickoIme(rsT.getString("korisnickoIme"));
                korisnik.setSifra(rsT.getString("sifra"));

                Vozac vozac = new Vozac();
                vozac.setVozacID(rsT.getInt("vozacID"));
                vozac.setIme(rsT.getString("ime"));
                vozac.setPrezime(rsT.getString("prezime"));
                vozac.setEmail(rsT.getString("email"));
                vozac.setAdresa(rsT.getString("adresa"));

                potvrda.setAutomobil(automobil);
                potvrda.setVozac(vozac);
                potvrda.setKorisnik(korisnik);
                //////////////////////////////////////////////////////////////////////////////////////////
                String upit2 = "SELECT * from termini_voznje WHERE potvrdaID=" + potvrda.getPotvrdaID();
                Statement statement2 = connection.createStatement();
                ResultSet rsTT = statement2.executeQuery(upit2);
                while (rsTT.next()) {
                    termin = new TerminVoznje();
                    termin.setPotvrda(potvrda);
                    termin.setRedniBroj(rsTT.getInt("redniBroj"));
                    termin.setDan(rsTT.getDate("dan"));
                    termin.setVreme(rsTT.getString("vreme"));
                    termini.add(termin);

                }

                rsTT.close();
                potvrda.setTermini(termini);
                potvrde.add(potvrda);

            }

            for (PotvrdaOIznajmljivanju potv : potvrde) {
                System.out.println(potv + "\n");
            }
            rsT.close();
            statement.close();
            System.out.println("Uspesno ucitavanje potvrda!");
        } catch (SQLException ex) {
            System.out.println("Neuspesno ucitavanje potvrda!");
            throw ex;
        }
        return potvrde;
    }

//    @Override
//    public void add(PotvrdaOIznajmljivanju potvrda) throws SQLException {
//        try {
//            String upit = "INSERT INTO potvrdaoiznajmljivanju(potvrdaID,datumOD,datumDO,cena,automobil,vozac,korisnik) VALUES(?,?,?,?,?,?,?)";
//            connection = DbConnectionFactory.getInstance().getConnection();
//            PreparedStatement statement = connection.prepareStatement(upit);
//
//            statement.setInt(1, potvrda.getPotvrdaID());
//            statement.setDate(2, new Date(potvrda.getDatumOD().getTime()));
//            statement.setDate(3, new Date(potvrda.getDatumDO().getTime()));
//            statement.setDouble(4, potvrda.getCena());
//            statement.setString(5, potvrda.getAutomobil().getRegistracioniBroj());
//            statement.setInt(6, potvrda.getVozac().getVozacID());
//            statement.setInt(7, potvrda.getKorisnik().getKorisnikID());
//
//            statement.executeUpdate();
//            statement.close();
//            System.out.println("Uspesno kreirana potvrda!");
//        } catch (SQLException ex) {
//            System.out.println("Neuspesno kreiranje potvrde!");
//            throw ex;
//        }
//    }
//    @Override
//    public void edit(PotvrdaOIznajmljivanju potvrda) throws SQLException {
//        try {
//            String upit = "UPDATE potvrdaoiznajmljivanju SET datumOD=?,datumDO=?,cena=?,automobil=?,vozac=?,korisnik=? WHERE potvrdaID=?";
//            connection = DbConnectionFactory.getInstance().getConnection();
//            PreparedStatement statement = connection.prepareStatement(upit);
//
//            statement.setDate(1, new Date(potvrda.getDatumOD().getTime()));
//            statement.setDate(2, new Date(potvrda.getDatumDO().getTime()));
//            statement.setDouble(3, potvrda.getCena());
//            statement.setString(4, potvrda.getAutomobil().getRegistracioniBroj());
//            statement.setInt(5, potvrda.getVozac().getVozacID());
//            statement.setInt(6, potvrda.getKorisnik().getKorisnikID());
//            statement.setInt(7, potvrda.getPotvrdaID());
//
//            statement.executeUpdate();
//
//            upit = "INSERT INTO termini_voznje VALUES(?,?,?,?)";
//            statement = connection.prepareStatement(upit);
//            for (TerminVoznje terminVoznje : potvrda.getTermini()) {
//                statement.setInt(1, terminVoznje.getPotvrda().getPotvrdaID());
//                statement.setInt(2, terminVoznje.getRedniBroj());
//                statement.setDate(3, new Date(terminVoznje.getDan().getTime()));
//                statement.setString(4, terminVoznje.getVreme());
//
//                statement.executeUpdate();
//            }
//
//            statement.close();
//            System.out.println("Uspesno izmenjena potvrda!");
//        } catch (SQLException ex) {
//            System.out.println("Neuspesna izmena potvrde!");
//            throw ex;
//        }
//    }
    @Override
    public void edit(PotvrdaOIznajmljivanju potvrda) throws SQLException {
        try {
            String upit = "UPDATE potvrdaoiznajmljivanju SET datumOD=?,datumDO=?,cena=?,automobil=?,vozac=?,korisnik=? WHERE potvrdaID=?";
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);

            statement.setDate(1, new Date(potvrda.getDatumOD().getTime()));
            statement.setDate(2, new Date(potvrda.getDatumDO().getTime()));
            statement.setDouble(3, potvrda.getCena());
            statement.setString(4, potvrda.getAutomobil().getRegistracioniBroj());
            statement.setInt(5, potvrda.getVozac().getVozacID());
            statement.setInt(6, potvrda.getKorisnik().getKorisnikID());
            statement.setInt(7, potvrda.getPotvrdaID());

            statement.executeUpdate();
            //////////////////////////////////////////////////////////////////////////////////////////////
            String upitDel = "DELETE FROM termini_voznje WHERE potvrdaID=" + potvrda.getPotvrdaID();
            statement = connection.prepareStatement(upitDel);
            statement.executeUpdate();

            upit = "INSERT INTO termini_voznje VALUES(?,?,?,?)";
            statement = connection.prepareStatement(upit);
            for (TerminVoznje terminVoznje : potvrda.getTermini()) {
                statement.setInt(1, terminVoznje.getPotvrda().getPotvrdaID());
                statement.setInt(2, terminVoznje.getRedniBroj());
                statement.setDate(3, new Date(terminVoznje.getDan().getTime()));
                statement.setString(4, terminVoznje.getVreme());

                statement.executeUpdate();
            }

            statement.close();
            System.out.println("Uspesno izmenjena potvrda!");
        } catch (SQLException ex) {
            System.out.println("Neuspesna izmena potvrde!");
           
            throw ex;
        }
    }

    @Override
    public void delete(PotvrdaOIznajmljivanju p) throws SQLException {
        try {
            String upit = "DELETE FROM potvrdaoiznajmljivanju WHERE potvrdaID=?";
            connection = DbConnectionFactory.getInstance().getConnection();
            PreparedStatement statement = connection.prepareStatement(upit);

            statement.setInt(1, p.getPotvrdaID());
            statement.executeUpdate();
            statement.close();
            System.out.println("Uspesno obrisana potvrda!");
        } catch (SQLException ex) {
            System.out.println("Neuspesna obrisana potvrda!");
            throw ex;
        }
    }

//    @Override
//    public PotvrdaOIznajmljivanju getByID(Integer ID) throws SQLException {
//        PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();
//        try {
//            String upit = "SELECT * FROM potvrdaoiznajmljivanju p JOIN automobil a ON p.automobil = a.registracioniBroj JOIN vozac v ON p.vozac = v.vozacID JOIN korisnik k ON p.korisnik=k.korisnikID JOIN tipautomobila t ON a.tip=t.tipID WHERE p.potvrdaID=" + ID;
//            connection = DbConnectionFactory.getInstance().getConnection();
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(upit);
//
//            while (rs.next()) {
//
//                potvrda.setPotvrdaID(rs.getInt("potvrdaID"));
//                potvrda.setDatumOD(rs.getDate("datumOD"));
//                potvrda.setDatumDO(rs.getDate("datumDO"));
//                potvrda.setCena(rs.getDouble("cena"));
//
//                TipAutomobila tip = new TipAutomobila();
//                tip.setTipID(rs.getInt("tipID"));
//                tip.setNazivTipa(rs.getString("nazivTipa"));
//
//                Automobil automobil = new Automobil();
//                automobil.setRegistracioniBroj(rs.getString("automobil"));
//                automobil.setModel(rs.getString("model"));
//                automobil.setMarka(rs.getString("marka"));
//                automobil.setTip(tip);
//
//                Korisnik korisnik = new Korisnik();
//                korisnik.setKorisnikID(rs.getInt("korisnikID"));
//                korisnik.setKorisnickoIme(rs.getString("korisnickoIme"));
//                korisnik.setSifra(rs.getString("sifra"));
//
//                Vozac vozac = new Vozac();
//                vozac.setVozacID(rs.getInt("vozacID"));
//                vozac.setIme(rs.getString("ime"));
//                vozac.setPrezime(rs.getString("prezime"));
//                vozac.setEmail(rs.getString("email"));
//                vozac.setAdresa(rs.getString("adresa"));
//
//                potvrda.setAutomobil(automobil);
//                potvrda.setVozac(vozac);
//                potvrda.setKorisnik(korisnik);
//
//            }
//            rs.close();
//            statement.close();
//            System.out.println("Uspesno ucitavanje potvrda!");
//        } catch (SQLException ex) {
//            System.out.println("Neuspesno ucitavanje potvrda!");
//            throw ex;
//        }
//        return potvrda;
//    }
    @Override
    public PotvrdaOIznajmljivanju getByID(Integer ID) throws SQLException {
        PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju();
        ArrayList<TerminVoznje> termini = new ArrayList<>();
        try {
            String upit = "SELECT * FROM termini_voznje tr JOIN potvrdaoiznajmljivanju p ON tr.potvrdaID=p.potvrdaID JOIN automobil a ON p.automobil = a.registracioniBroj JOIN vozac v ON p.vozac = v.vozacID JOIN korisnik k ON p.korisnik=k.korisnikID JOIN tipautomobila t ON a.tip=t.tipID WHERE p.potvrdaID=" + ID;
            connection = DbConnectionFactory.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);

            while (rs.next()) {

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

                TerminVoznje termin = new TerminVoznje();
                termin.setPotvrda(potvrda);
                termin.setRedniBroj(rs.getInt("redniBroj"));
                termin.setDan(rs.getDate("dan"));
                termin.setVreme(rs.getString("vreme"));
                termini.add(termin);

                potvrda.setAutomobil(automobil);
                potvrda.setVozac(vozac);
                potvrda.setKorisnik(korisnik);
                potvrda.setTermini(termini);

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
