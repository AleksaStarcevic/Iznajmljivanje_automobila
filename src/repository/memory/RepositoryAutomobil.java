/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.memory;

import domen.Automobil;
import domen.TipAutomobila;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class RepositoryAutomobil {
    private List<Automobil> automobili;

    public RepositoryAutomobil() {
        this.automobili = new ArrayList<>();
        automobili.add(new Automobil("BG041KL", "Logan", "Dacia", new TipAutomobila(1, "Sedan")));
        automobili.add(new Automobil("BG031KL", "A4", "Audi", new TipAutomobila(1, "Sedan")));
        automobili.add(new Automobil("BG567KL", "Golf", "Volkswagen", new TipAutomobila(2, "Hecbek")));
    }

    public List<Automobil> getAutomobili() {
        return automobili;
    }
    
    
    
    
    
}
