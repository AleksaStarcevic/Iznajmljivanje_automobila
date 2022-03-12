/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.potvrda;

import domen.OpstiDomenskiObjekat;
import domen.PotvrdaOIznajmljivanju;
import domen.TerminVoznje;
import java.util.ArrayList;
import java.util.List;
import repository.impl.RepositoryPotvrda;
import so.AbstractSO;

/**
 *
 * @author aleks
 */
public class GetPotvrdeSO extends AbstractSO {

    private List<OpstiDomenskiObjekat> potvrde = new ArrayList<>();

    @Override
    protected void precondition(Object param) throws Exception {

        if (param == null || !(param instanceof PotvrdaOIznajmljivanju)) {
            throw new Exception("Pogresan param");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {

        List<OpstiDomenskiObjekat> listaPotvrda = brokerBaze.vratiSve((OpstiDomenskiObjekat) param);
        PotvrdaOIznajmljivanju potvrda;
        TerminVoznje termin;

        List<OpstiDomenskiObjekat> listaTermina = brokerBaze.vratiSve(new TerminVoznje());

        for (OpstiDomenskiObjekat opstiDomenskiObjekat : listaPotvrda) {
            potvrda = (PotvrdaOIznajmljivanju) opstiDomenskiObjekat;
            ArrayList<TerminVoznje> termini = new ArrayList<>();

            for (OpstiDomenskiObjekat opstiDomenskiObjekat1 : listaTermina) {
                termin = (TerminVoznje) opstiDomenskiObjekat1;
                if (potvrda.getPotvrdaID() == termin.getPotvrda().getPotvrdaID()) {
                    termini.add(termin);
                }
            }
            potvrda.setTermini(termini);
            potvrde.add(potvrda);

        }

    }

    public List<OpstiDomenskiObjekat> getListaPotvrda() {
        return potvrde;
    }

}
