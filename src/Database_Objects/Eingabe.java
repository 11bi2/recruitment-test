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
 * @author sriga
 */
public class Eingabe {
    private int id;
    private int aufgabeId;
    private String text;
    
    public Eingabe(){
        this(0, 0, "");
    };
    public Eingabe(int aufgabeId, String text){
        this(0, aufgabeId, text);
    }
    public Eingabe(int id, int aufgabeId, String text){
        this.id = id;
        this.aufgabeId = aufgabeId;
        this.text = text;
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
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    
    public static Eingabe fromResultSet(ResultSet res){
        try {
            return new Eingabe(res.getInt(1), res.getInt(2), res.getString(3));
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
    
    
}
