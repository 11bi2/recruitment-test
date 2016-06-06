/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sriga
 */
public class Bewerber {
    private int id;
    private String vorName;
    private String nachName;
    private int geburtsTag;
    private String eMail;
    private String abschluss;
    private String berufsWahl;
    private String assignedPassword;
    
    public Bewerber(){}
    public Bewerber(String vorName, String nachName, int geburtsTag, String eMail, String abschluss, String berufswahl, String assignedPassword){
        this(0, vorName, nachName, geburtsTag, eMail, abschluss, berufswahl, assignedPassword);
    }
    public Bewerber(int id, String vorName, String nachName, int geburtsTag, String eMail, String abschluss, String berufsWahl, String assignedPassword){
        this.id = id;
        this.vorName = vorName;
        this.nachName = nachName;
        this.geburtsTag = geburtsTag;
        this.eMail = eMail;
        this.abschluss = abschluss;
        this.berufsWahl = berufsWahl;
        this.assignedPassword = assignedPassword;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getVorName() {
        return vorName;
    }
    public void setVorName(String vorName) {
        this.vorName = vorName;
    }
    public String getNachName() {
        return nachName;
    }
    public void setNachName(String nachName) {
        this.nachName = nachName;
    }
    public int getGeburtsTag() {
        return geburtsTag;
    }
    public void setGeburtsTag(int geburtsTag) {
        this.geburtsTag = geburtsTag;
    }
    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public String getAbschluss() {
        return abschluss;
    }
    public void setAbschluss(String abschluss) {
        this.abschluss = abschluss;
    }
    public String getBerufsWahl() {
        return berufsWahl;
    }
    public void setBerufsWahl(String berufsWahl) {
        this.berufsWahl = berufsWahl;
    }

    public String getAssignedPassword() {
        return assignedPassword;
    }

    public void setAssignedPassword(String assignedPassword) {
        this.assignedPassword = assignedPassword;
    }
    
    
    
    
    public static Bewerber fromResultSet(ResultSet res){
        try {
            
            return new Bewerber(
                    res.getInt(1), res.getString(2), res.getString(3), 
                    res.getInt(4), res.getString(5), res.getString(6), 
                    res.getString(7), res.getString(8));
            
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
    
}
