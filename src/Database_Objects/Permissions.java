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
public class Permissions {
    
    private int id;
    private String description;
    
    public Permissions(int idPermission, String description){
        this.id = idPermission;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int idPermisson) {
        this.id = idPermisson;
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
