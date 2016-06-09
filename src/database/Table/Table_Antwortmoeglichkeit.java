/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Database_Objects.Antwortmoeglichkeit;
import DBMaster.DBMaster;
import database.Table.Helper.SQLHelper;
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
public class Table_Antwortmoeglichkeit extends Table<Antwortmoeglichkeit> implements SQLExecution {

    private Table_Antwortmoeglichkeit(){}
    
    private static Table_Antwortmoeglichkeit instance = null;
    
    public static Table_Antwortmoeglichkeit getInstance(){
        if (instance == null) {
            return instance = new Table_Antwortmoeglichkeit();
        }
        return instance;
    }
    
    @Override
    public void create(Antwortmoeglichkeit args) {
        executeUpdate(SQLHelper.INSERT_ANTWORTMOEGLICHKTEI_QUERY(args));
    }

    @Override
    public Integer getLastInsertedId() {
        ResultSet res = executeQuery(SQLHelper.GET_LAST_INSERT_AUFGABENMOEGLICHKEITEN_ID_QUERY());
        
        try {
            return res.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Table_Antwortmoeglichkeit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Antwortmoeglichkeit getEntry(int id) {
       return Antwortmoeglichkeit.fromResultSet(executeQuery(SQLHelper.GET_ANTWORTMOEGLICHKEIT_QUERY(id)));
    }

    @Override
    public ArrayList<Antwortmoeglichkeit> getAllEntrys() {
        ArrayList<Antwortmoeglichkeit> results = new ArrayList();
        
        ResultSet res = executeQuery(SQLHelper.GET_ALL_ANTWORTMOEGLICHKEITEN_QUERY());
        
        try {
            
            while(res.next()){
                results.add(Antwortmoeglichkeit.fromResultSet(res));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Table_Antwortmoeglichkeit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return results;
    }

    @Override
    public void update(Antwortmoeglichkeit args) {
        executeUpdate(SQLHelper.UPDATE_ANTWORTMOEGLICHKEITEN_QUERY(args));
    }

    @Override
    public void delete(Antwortmoeglichkeit args) {
        executeUpdate(SQLHelper.DELETE_ANTWORTMOEGLICHKEIT_QUERY(args));
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return DBMaster.getDatabase().getSession().prepareStatement(query).executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Antwortmoeglichkeit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public int getCount() {
        try {
            ResultSet res = executeQuery(SQLHelper.GET_ANTWORTMOEGLICHKEIT_COUNT_QUERY());
            
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Antwortmoeglichkeit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void executeUpdate(String query) {
        try {
            DBMaster.getDatabase().getSession().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Antwortmoeglichkeit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
