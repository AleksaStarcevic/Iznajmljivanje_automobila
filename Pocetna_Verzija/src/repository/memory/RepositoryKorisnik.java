/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.memory;

import domen.Korisnik;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class RepositoryKorisnik {
    private List<Korisnik> korisnici;

    public RepositoryKorisnik() {
        this.korisnici = new ArrayList<>();
        korisnici.add(new Korisnik(1, "admin", "admin"));
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }
    
    
    
    
    
}
