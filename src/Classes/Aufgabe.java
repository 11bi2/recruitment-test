/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sriga
 */
public class Aufgabe {
   
    private int id;
    private int bewertungId;
    private String aufgabenstellung;
    private Blob picture;
    private String hilfestellung;
    
    public Aufgabe(){}
    public Aufgabe(int bewertungId, String aufgabenstellung, Blob picture, String hilfestellung){
        this(0, bewertungId, aufgabenstellung, picture, hilfestellung);
    }
    public Aufgabe(int id, int bewertungId, String aufgabenstellung, Blob picture, String hilfestellung){
        this.id = id;
        this.bewertungId = bewertungId;
        this.aufgabenstellung = aufgabenstellung;
        this.picture = picture;
        this.hilfestellung = hilfestellung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBewertungId() {
        return bewertungId;
    }

    public void setBewertungId(int bewertungId) {
        this.bewertungId = bewertungId;
    }

    public String getAufgabenstellung() {
        return aufgabenstellung;
    }

    public void setAufgabenstellung(String Aufgabenstellung) {
        this.aufgabenstellung = Aufgabenstellung;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public String getHilfestellung() {
        return hilfestellung;
    }

    public void setHilfestellung(String hilfestellung) {
        this.hilfestellung = hilfestellung;
    }
    
    public static Aufgabe fromResultSet(ResultSet res){
        try {
            return new Aufgabe(res.getInt(1), res.getInt(2), res.getString(3), res.getBlob(4), res.getString(5));
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
    
}
