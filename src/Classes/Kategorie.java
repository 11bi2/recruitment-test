/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author sriga
 */
public class Kategorie {
    
    private int id;
    private int bewerberID;
    private int aufgabeID;
    private String kategorieBezeichnung;
    private Time verfuegbareZeit;
    
    public Kategorie(){
        this(0, 0, 0, "", null);
    };
    
    public Kategorie(int bewerberID, int aufgabeID, String kategorieBezeichnung, Time verfuegbareZeit){
        this(0, bewerberID, aufgabeID, kategorieBezeichnung, verfuegbareZeit);
    }
    
    public Kategorie(int id, int bewerberID, int aufgabeID, String kategorieBezeichnung, Time verfuegbareZeit){
        this.id = id;
        this.bewerberID = bewerberID;
        this.aufgabeID = aufgabeID;
        this.kategorieBezeichnung = kategorieBezeichnung;
        this.verfuegbareZeit = verfuegbareZeit;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getBewerberID() {
        return bewerberID;
    }
    public void setBewerberID(int bewerberID) {
        this.bewerberID = bewerberID;
    }
    public int getAufgabeID() {
        return aufgabeID;
    }
    public void setAufgabeID(int aufgabeID) {
        this.aufgabeID = aufgabeID;
    }
    public String getKategorieBezeichnung() {
        return kategorieBezeichnung;
    }
    public void setKategorieBezeichnung(String kategorieBezeichnung) {
        this.kategorieBezeichnung = kategorieBezeichnung;
    }
    public Time getVerfuegbareZeit() {
        return verfuegbareZeit;
    }
    public void setVerfuegbareZeit(Time verfuegbareZeit) {
        this.verfuegbareZeit = verfuegbareZeit;
    }
    
    public static Kategorie fromResultSet(ResultSet res){
        try {    
            return new Kategorie(
                    res.getInt(1), res.getInt(2), 
                    res.getInt(3), res.getString(4), 
                    res.getTime(5));
            
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
}
