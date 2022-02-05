/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;

/**
 *
 * @author aleks
 */
public class TipAutomobila implements Serializable{
    private int tipID;
    private String nazivTipa;

    public TipAutomobila() {
    }

    public TipAutomobila(int tipID, String nazivTipa) {
        this.tipID = tipID;
        this.nazivTipa = nazivTipa;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }

    public void setNazivTipa(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }

    public int getTipID() {
        return tipID;
    }

    public void setTipID(int tipID) {
        this.tipID = tipID;
    }

    @Override
    public String toString() {
       return nazivTipa;
    }
    
    
}
