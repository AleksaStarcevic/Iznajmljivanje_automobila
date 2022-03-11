/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.potvrda;

import domen.OpstiDomenskiObjekat;
import domen.PotvrdaOIznajmljivanju;
import domen.TerminVoznje;
import jdk.nashorn.internal.objects.NativeArray;
import repository.impl.RepositoryPotvrda;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class EditPotvrdaSO extends AbstractSO {

    @Override
    protected void precondition(Object param) throws Exception {
        if (param == null || !(param instanceof PotvrdaOIznajmljivanju)) {
            throw new Exception("Pogresan param");
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        brokerBaze.izmeni((OpstiDomenskiObjekat) param);

        TerminVoznje termin = new TerminVoznje();
        PotvrdaOIznajmljivanju pot = (PotvrdaOIznajmljivanju) param;
        termin.setPotvrda(pot);
        // izbrisem termine
        brokerBaze.obrisi(termin);
        // ubacim termine
        for (TerminVoznje tr : pot.getTermini()) {
            brokerBaze.ubaci(tr);
        }

    }

}
