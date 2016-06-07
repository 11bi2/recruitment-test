/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sriga
 */
public class Schwierigkeit {
    
    private int idSchwierigkeit;
    private int idAufgabe;
    private int erreichtePunktzahl;
    private int moeglichePunktzahl;

    public Schwierigkeit(int idSchwierigkeit, int idAufgabe, int erreichtePunktzahl, int moeglichePunktzahl) {
        this.idSchwierigkeit = idSchwierigkeit;
        this.idAufgabe = idAufgabe;
        this.erreichtePunktzahl = erreichtePunktzahl;
        this.moeglichePunktzahl = moeglichePunktzahl;
    }

    
    
    public int getIdSchwierigkeit() {
        return idSchwierigkeit;
    }

    public void setIdSchwierigkeit(int idSchwierigkeit) {
        this.idSchwierigkeit = idSchwierigkeit;
    }

    public int getIdAufgabe() {
        return idAufgabe;
    }

    public void setIdAufgabe(int idAufgabe) {
        this.idAufgabe = idAufgabe;
    }

    public int getErreichtePunktzahl() {
        return erreichtePunktzahl;
    }

    public void setErreichtePunktzahl(int erreichtePunktzahl) {
        this.erreichtePunktzahl = erreichtePunktzahl;
    }

    public int getMoeglichePunktzahl() {
        return moeglichePunktzahl;
    }

    public void setMoeglichePunktzahl(int moeglichePunktzahl) {
        this.moeglichePunktzahl = moeglichePunktzahl;
    }
    
    public static Schwierigkeit fromResultSet(ResultSet res){
        try {
            return new Schwierigkeit(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4));
        } catch (SQLException ex) {
            Logger.getLogger(Schwierigkeit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
