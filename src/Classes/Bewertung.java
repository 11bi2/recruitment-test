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
 * @author root
 */
public class Bewertung {
    private int id;
    private byte erreichtePunktzahl;
    private byte moegliche_punktzahl;
    
    public Bewertung(){};
    public Bewertung(byte erreichtePunktzahl, byte moeglichePunktzahl){
        this(0, erreichtePunktzahl, moeglichePunktzahl);
    }
    public Bewertung(int id, byte erreichtePunktzahl, byte moeglichePunktzahl){
        this.id = id;
        this.erreichtePunktzahl = erreichtePunktzahl;
        this.moegliche_punktzahl = moeglichePunktzahl;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public byte getErreichtePunktzahl() {
        return erreichtePunktzahl;
    }
    public void setErreichtePunktzahl(byte erreichtePunktzahl) {
        this.erreichtePunktzahl = erreichtePunktzahl;
    }
    public byte getMoegliche_punktzahl() {
        return moegliche_punktzahl;
    }
    public void setMoegliche_punktzahl(byte moegliche_punktzahl) {
        this.moegliche_punktzahl = moegliche_punktzahl;
    }
    
    public static Bewertung fromResultSet(ResultSet res){
        try {
            return new Bewertung(res.getInt(1), res.getByte(2), res.getByte(3));
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
    
    
}
