/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Objects;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public class Loesung {
    private int id;
    private int aufgabeId;
    private String textLoesung;
    private int punkte;
    
    public Loesung(){
        this(0, 0, "");
    }
    public Loesung(int aufgabeId, String textLoesung){
        this(0, aufgabeId, textLoesung);
    }
    public Loesung(int id, int aufgabeId, String textLoesung){
        this.id = id;
        this.aufgabeId = aufgabeId;
        this.textLoesung = textLoesung;
    }

    public Loesung(int id, int aufgabeId, String textLoesung, int punkte) {
        this.id = id;
        this.aufgabeId = aufgabeId;
        this.textLoesung = textLoesung;
        this.punkte = punkte;
    }
    
    
    

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAufgabeId() {
        return aufgabeId;
    }
    public void setAufgabeId(int aufgabeId) {
        this.aufgabeId = aufgabeId;
    }
    public String getTextLoesung() {
        return textLoesung;
    }
    public void setTextLoesung(String textLoesung) {
        this.textLoesung = textLoesung;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }
    
    
    
    public static Loesung fromResultSet(ResultSet res){
        try {
            if (res.isBeforeFirst()) {
                res.next();
            }
            return new Loesung(res.getInt(1), res.getInt(2), res.getString(3), res.getInt(4));
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
    
}
