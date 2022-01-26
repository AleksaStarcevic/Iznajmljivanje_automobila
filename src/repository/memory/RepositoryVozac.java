/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.memory;

import domen.Vozac;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aleks
 */
public class RepositoryVozac {
    List<Vozac> vozaci;

    public RepositoryVozac() {
        vozaci = new ArrayList<>();
        vozaci.add(new Vozac(1, "Aleksa", "Star", "alek1@gmail.com", "Volgina"));
        vozaci.add(new Vozac(2, "Nikola", "Cvet", "nik7@gmail.com", "Gige"));
        vozaci.add(new Vozac(3, "Aleksa", "Visnja", "visn3@gmail.com", "Medak"));
    }

    public List<Vozac> getVozaci() {
        return vozaci;
    }
    
   
    
    
}
