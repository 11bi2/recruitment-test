/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sriga
 */
public class Ergebnis {
    
    private int id;
    private int id_Bewerber;
    private String pruefungsDatum;
    private int punktzahl;
    private int ergebnis;

    public Ergebnis(){}
    
    public Ergebnis(int id, int id_Bewerber, String pruefungsDatum, int punktzahl, int ergebnis) {
        this.id = id;
        this.id_Bewerber = id_Bewerber;
        this.pruefungsDatum = pruefungsDatum;
        this.punktzahl = punktzahl;
        this.ergebnis = ergebnis;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Bewerber() {
        return id_Bewerber;
    }

    public void setId_Bewerber(int id_Bewerber) {
        this.id_Bewerber = id_Bewerber;
    }

    public String getPruefungsDatum() {
        return pruefungsDatum;
    }

    public void setPruefungsDatum(String pruefungsDatum) {
        this.pruefungsDatum = pruefungsDatum;
    }

    public int getPunktzahl() {
        return punktzahl;
    }

    public void setPunktzahl(int punktzahl) {
        this.punktzahl = punktzahl;
    }

    public int getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(int ergebnis) {
        this.ergebnis = ergebnis;
    }
    
    public static Ergebnis fromResultSet(ResultSet res){
        try {
            if (res.isBeforeFirst()) {
                res.next();
            }
            return new Ergebnis(res.getInt(1), res.getInt(2), res.getString(3), res.getInt(4), res.getInt(5));
        } catch (SQLException ex) {
            Logger.getLogger(Ergebnis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
 
    public String[] toTableSet(){
        Bewerber bewerber = SessionManager.getInstance().getBewerberById(this.getId_Bewerber());
        Berufswahl berufsWahl = SessionManager.getInstance().getBerufswahlById(bewerber.getIdBerufswahl());
        String enroled;
        
        if (this.getErgebnis() == 1) {
            enroled = "Bestanden";
        }else {
            enroled = "Durchgefallen";
        }
        
        String[] tableArray = {bewerber.getVorName(), bewerber.getNachName(), berufsWahl.getBerufsBeschreibung(), this.getPruefungsDatum(), this.getPunktzahl() + "", enroled};
         
        return tableArray;
         
    }
}