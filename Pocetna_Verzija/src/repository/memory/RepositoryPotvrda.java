/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.memory;

import domen.PotvrdaOIznajmljivanju;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class RepositoryPotvrda {
    private List<PotvrdaOIznajmljivanju> potvrde;

    public RepositoryPotvrda() {
        potvrde = new ArrayList<>();
    }
    
    public void dodaj(PotvrdaOIznajmljivanju potvrda){
        potvrde.add(potvrda);
        
    }

    public List<PotvrdaOIznajmljivanju> getPotvrde() {
        return potvrde;
    }
    
    
    
    
}
