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
    private int idBerufswahl;
    private int idPermisson;
    private String vorName;
    private String nachName;
    private int geburtsTag;
    private String eMail;
    private int permission;
    private int created;
    private int freigabe;
    private String assignedPassword;

    public Bewerber(int id, int idBerufswahl, int idPermisson, String vorName, String nachName, int geburtsTag, String eMail, int permission, int created, int freigabe, String assignedPassword) {
        this.id = id;
        this.idBerufswahl = idBerufswahl;
        this.idPermisson = idPermisson;
        this.vorName = vorName;
        this.nachName = nachName;
        this.geburtsTag = geburtsTag;
        this.eMail = eMail;
        this.permission = permission;
        this.created = created;
        this.freigabe = freigabe;
        this.assignedPassword = assignedPassword;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBerufswahl() {
        return idBerufswahl;
    }

    public void setIdBerufswahl(int idBerufswahl) {
        this.idBerufswahl = idBerufswahl;
    }

    public int getIdPermisson() {
        return idPermisson;
    }

    public void setIdPermisson(int idPermisson) {
        this.idPermisson = idPermisson;
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

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public int getFreigabe() {
        return freigabe;
    }

    public void setFreigabe(int freigabe) {
        this.freigabe = freigabe;
    }

    public String getAssignedPassword() {
        return assignedPassword;
    }

    public void setAssignedPassword(String assignedPassword) {
        this.assignedPassword = assignedPassword;
    }
    
    public static Bewerber fromResultSet(ResultSet res){
        try {
            
            return new Bewerber(res.getInt(1), res.getInt(2), res.getInt(3), res.getString(4), res.getString(5), res.getInt(6), res.getString(7), res.getInt(8), res.getInt(9), res.getInt(10), res.getString(11));
            
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
    
}
