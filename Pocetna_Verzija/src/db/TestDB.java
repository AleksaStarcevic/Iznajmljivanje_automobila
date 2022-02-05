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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aleks
 */
public class TestDB {
    
    public static void main(String[] args) throws SQLException {
        DatabaseBroker db = new DatabaseBroker();
        db.uspostaviKonekciju();
        
        Vozac v = new Vozac(1, "Aleksa", "Star", "aki1@gmail.com", "Volgina");
        TipAutomobila tip = new TipAutomobila(1, "Karavan");
        Automobil automobil = new Automobil("BG041KL", "Logan", "Dacia", tip);
        Korisnik korisnik = new Korisnik(2, "akile", "123");
        //db.kreirajVozaca(v);
//        System.out.println(db.vratiVozace());

//        PotvrdaOIznajmljivanju potvrda = new PotvrdaOIznajmljivanju(1, new Date(), new Date(), 12, automobil, v, korisnik);
//        db.kreirajPotvrdu(potvrda);
//           Vozac v2 = new Vozac(1, "Maak", "Baak", "aki1e@gmail.com", "Dravska");
//           db.izmeniVozaca(1,v2);
        Automobil automobil2 = new Automobil("BG666PL", "A3", "Audi", tip);
//        db.kreirajAutomobil(automobil2);
//        db.izmeniAutomobil("BG666PL", automobil2);
    //db.obrisiAutomobil("BG666PL");
   List<PotvrdaOIznajmljivanju> potvrde = new ArrayList<>();
  potvrde = db.vratiPotvrde();
   System.out.println(potvrde);
//System.out.println(db.vratiAutomobile());
//        System.out.println(db.vratiKorisnike()); 
        db.raskiniKonekciju();
    }
    
}
