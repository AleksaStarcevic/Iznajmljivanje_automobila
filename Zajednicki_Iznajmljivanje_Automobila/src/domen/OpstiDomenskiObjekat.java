/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;



/**
 *
 * @author aleks
 */
public interface OpstiDomenskiObjekat{
    String vratiVrednostiAtributa();

    String postaviVrednostAtrbuta();

    String vratiImeKlase();

    String vratiUslovZaNadjiSlog();

    String vratiUslovZaNadjiSlogove();


    public OpstiDomenskiObjekat napuni(ResultSet rs) throws Exception;

    public ArrayList<OpstiDomenskiObjekat> napuniSve(ResultSet rs) throws Exception;

    public String vratiTabeluSaUslovomSpajanja();
}
