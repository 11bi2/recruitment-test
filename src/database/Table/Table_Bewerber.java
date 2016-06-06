/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import database.Table.Helper.SQLHelper;
import Classes.Bewerber;
import DBMaster.DBMaster;
import database.Table.Interface.SQLExecution;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sriga
 */
public class Table_Bewerber extends Table<Bewerber> implements SQLExecution {
    
    private ResultSet results;
    
    public Table_Bewerber(){};
    
    private static Table_Bewerber instance = null;
    
   
    public static Table getInstance() {
        if (instance == null) {
            instance = new Table_Bewerber();
        }
        return instance;
    }

    @Override
    public void create(Bewerber args){  
        executeQuery(SQLHelper.INSERT_BEWERBER_QUERY(args));    
        args.setId(this.getLastInsertedId());
    }

    @Override
    public Integer getLastInsertedId() {
        
        try {
            return executeQuery(SQLHelper.GET_LAST_INSERT_BEWERBER_ID_QUERY())
                    .getInt(1);
        
        } catch (SQLException ex) {
            //UI Hook here
        }
        return null;
    }

    @Override
    public Bewerber getEntry(int id) {
        return Bewerber.fromResultSet(executeQuery(
                SQLHelper.GET_BEWERBER_QUERY(id)));
    }

    @Override
    public ArrayList<Bewerber> getAllEntrys() {
        ArrayList<Bewerber> bewerber = new ArrayList();
        
        try {
            
            results = executeQuery(SQLHelper.GET_ALL_BEWERBER_QUERY());
            
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
        executeQuery(SQLHelper.UPDATE_BEWERBER_QUERY(args));
    }

    @Override
    public void delete(Bewerber args) {
        executeQuery(SQLHelper.DELETE_BEWERBER_QUERY(args));
    } 
    
    public static boolean authenticate(String username, String password){
        try {
            String[] usernameSplit = username.split(" ");
            ResultSet res = 
                    DBMaster.getDatabase().getSession().
                            prepareStatement(SQLHelper.AUTHENTICATE_BEWERBER(
                                    usernameSplit[0], usernameSplit[1], password)
                            ).executeQuery();
            if (res.next()) {
                return true;
            }
        } catch (SQLException | ArrayIndexOutOfBoundsException ex) {
            return false;
        }
        return false;
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
}
