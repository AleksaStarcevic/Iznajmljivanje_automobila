/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.korisnik;

import domen.Automobil;
import domen.Korisnik;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import repository.impl.RepositoryKorisnik;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class KorisniciSO extends AbstractSO {
    private ArrayList<OpstiDomenskiObjekat> listaKorisnika;

    @Override
    protected void precondition(Object param) throws Exception {
         if (param == null || !(param instanceof Korisnik)) {
            throw new Exception("Pogresan parametar");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
       listaKorisnika = (ArrayList<OpstiDomenskiObjekat>) brokerBaze.vratiSveBezUslova((OpstiDomenskiObjekat)param);
    }

    public ArrayList<OpstiDomenskiObjekat> getListaKorisnika() {
        return listaKorisnika;
    }
    
    

}
