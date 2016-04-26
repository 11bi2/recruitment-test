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
public class Loesung {
    private int id;
    private int aufgabeId;
    private String textLoesung;
    
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
    
    public static Loesung fromResultSet(ResultSet res){
        try {
            return new Loesung(res.getInt(1), res.getInt(2), res.getString(3));
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
    
}
