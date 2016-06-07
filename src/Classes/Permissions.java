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
 * @author sriga
 */
public class Permissions {
    
    private int idPermisson;
    private String description;
    
    public Permissions(int idPermission, String description){
        this.idPermisson = idPermission;
        this.description = description;
    }

    public int getIdPermisson() {
        return idPermisson;
    }

    public void setIdPermisson(int idPermisson) {
        this.idPermisson = idPermisson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static Permissions fromResultSet(ResultSet res){
        try {
            return new Permissions(res.getInt(1), res.getString(2));
        } catch (SQLException ex) {
            Logger.getLogger(Permissions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
