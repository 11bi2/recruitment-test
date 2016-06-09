/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Objects;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sriga
 */
public class Aufgabe {
   
    private int id;
    private int idKategorie;
    private String aufgabenstellung;
    private Blob picture;
    private int idAntwortMoeglichkeit;
    
    public Aufgabe(){}
    public Aufgabe(int bewertungId, String aufgabenstellung, Blob picture, int idAntwortMoeglichkeit){
        this(0, bewertungId, aufgabenstellung, picture, idAntwortMoeglichkeit);
    }
    public Aufgabe(int id, int bewertungId, String aufgabenstellung, Blob picture, int idAntwortMoeglichkeit){
        this.id = id;
        this.idKategorie = bewertungId;
        this.aufgabenstellung = aufgabenstellung;
        this.picture = picture;
        this.idAntwortMoeglichkeit = idAntwortMoeglichkeit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdKategorie() {
        return idKategorie;
    }

    public void setIdKategorie(int idKategorie) {
        this.idKategorie = idKategorie;
    }

    public int getIdAntwortMoeglichkeit() {
        return idAntwortMoeglichkeit;
    }

    public void setIdAntwortMoeglichkeit(int idAntwortMoeglichkeit) {
        this.idAntwortMoeglichkeit = idAntwortMoeglichkeit;
    }


    
    public static Aufgabe fromResultSet(ResultSet res){
        try {
            return new Aufgabe(res.getInt(1), res.getInt(2), res.getString(3), res.getBlob(4), res.getInt(5));
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
    
}
