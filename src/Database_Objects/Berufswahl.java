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
public class Berufswahl {
    
    private int id;
    private String berufsBeschreibung;
    private String voraussetzung;
    
    public Berufswahl(int idBerufswahl, String berufsBeschreibung, String voraussetzung){
        setId(idBerufswahl);
        setBerufsBeschreibung(berufsBeschreibung);
        setVoraussetzung(voraussetzung);
    }

    public int getId() {
        return id;
    }

    public void setId(int idBerufswahl) {
        this.id = idBerufswahl;
    }

    public String getBerufsBeschreibung() {
        return berufsBeschreibung;
    }

    public void setBerufsBeschreibung(String berufsBeschreibung) {
        this.berufsBeschreibung = berufsBeschreibung;
    }

    public String getVoraussetzung() {
        return voraussetzung;
    }

    public void setVoraussetzung(String voraussetzung) {
        this.voraussetzung = voraussetzung;
    }
    
    public static Berufswahl fromResultSet(ResultSet res){
        try {
            return new Berufswahl(res.getInt(1), res.getString(2), res.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Berufswahl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
