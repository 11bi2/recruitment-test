/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import database.Table.Helper.SQLHelper;
import Database_Objects.Bewerber;
import DBMaster.DBMaster;
import database.Table.Interface.SQLExecution;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sriga
 */
public class Table_Bewerber extends Table<Bewerber> implements SQLExecution {
    
    private Table_Bewerber(){};
    
    private static Table_Bewerber instance = null;
    
    public static Table getInstance() {
        if (instance == null) {
            instance = new Table_Bewerber();
        }
        return instance;
    }

    @Override
    public void create(Bewerber args){  
        try {
            executeUpdate(SQLHelper.INSERT_BEWERBER_QUERY(args));
        } catch (ParseException ex) {
            Logger.getLogger(Table_Bewerber.class.getName()).log(Level.SEVERE, null, ex);
        }
        //executeQuery(SQLHelper.INSERT_BEWERBER_QUERY(args)); 
        args.setId(this.getLastInsertedId());
    }

    @Override
    public Integer getLastInsertedId() {
        
        try {
            
            
            ResultSet res = executeQuery(SQLHelper.GET_LAST_INSERT_BEWERBER_ID_QUERY());
            
            if (res.next()) {
                return res.getInt(1);
            }
        
        } catch (SQLException ex) {
            //UI Hook here
        }
        return null;
    }

    @Override
    public Bewerber getEntry(int id) {
        return Bewerber.fromResultSet(executeQuery(SQLHelper.GET_BEWERBER_QUERY(id)));
    }

    @Override
    public ArrayList<Bewerber> getAllEntrys() {
        ArrayList<Bewerber> bewerber = new ArrayList();
        
        try {
            
            ResultSet results = executeQuery(SQLHelper.GET_ALL_BEWERBER_QUERY());
            
            while(results.next()){
                bewerber.add(Bewerber.fromResultSet(results));
            }
            
        } catch (SQLException ex) {
            //UIHook here
        }
       return bewerber;
    }

    @Override
    public void update(Bewerber args) {
        executeUpdate(SQLHelper.UPDATE_BEWERBER_QUERY(args));
    }

    @Override
    public void delete(Bewerber args) {
        executeUpdate(SQLHelper.DELETE_BEWERBER_QUERY(args));
    } 
    
    public static Bewerber authenticate(String username, String password){
        String vorname;
        String nachname;
        
        try {
            if (username.contains(" ")) {
                String[] usernameSplit = username.split(" ");
                vorname = usernameSplit[0];
                nachname = usernameSplit[1];
                
            } else {
                vorname = username;
                nachname = "";
            }
            
             
                ResultSet res = 
                    DBMaster.getDatabase().getSession().
                            prepareStatement(SQLHelper.AUTHENTICATE_BEWERBER(
                                    vorname, nachname, password)
                            ).executeQuery();
            return Bewerber.fromResultSet(res);
            
        } catch (SQLException | ArrayIndexOutOfBoundsException ex) {
            return null;
        }
    }
    @Override
    public ResultSet executeQuery(String query) {
        try {
            return DBMaster.getDatabase().getSession().prepareStatement(query).executeQuery();
        } catch (SQLException ex) {
            //UIHook here;
        }
        return null;
    }

    @Override
    public int getCount() {
        try {
            ResultSet res = executeQuery(SQLHelper.GET_BERUFSWAHL_COUNT_QUERY());
        
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Bewerber.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void executeUpdate(String query) {
        try {
            DBMaster.getDatabase().getSession().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Bewerber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
