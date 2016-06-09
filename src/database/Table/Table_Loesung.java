/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Database_Objects.Loesung;
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
public class Table_Loesung extends Table<Loesung> implements SQLExecution {
    
    private Table_Loesung(){}
    
    private static Table_Loesung instance = null;

    public static Table getInstance() {
        if (instance == null) {
            instance = new Table_Loesung();
        }
        return instance;
    }

    @Override
    public void create(Loesung args) {
        executeUpdate(SQLHelper.INSERT_LOESUNG_QUERY(args));
    }

    @Override
    public Integer getLastInsertedId() {
        
        try {
            return executeQuery(SQLHelper.GET_LAST_INSERTED_LOESUNG_ID()).getInt(1);
        } catch (SQLException ex) {
            //UIHook here
        }
        
        return null;
    }

    @Override
    public Loesung getEntry(int id) {
        return Loesung.fromResultSet(executeQuery(SQLHelper.GET_LOESUNG_QUERY(id)));
    }

    @Override
    public ArrayList<Loesung> getAllEntrys() {
        ArrayList<Loesung> loesungen = new ArrayList();
        
        ResultSet res = executeQuery(SQLHelper.GET_ALL_LOESUNG_QUERY());
        
        try {
            while(res.next()){
                loesungen.add(Loesung.fromResultSet(res));
            }
        } catch (SQLException ex) {
            //UIHook here
        }
        
        return loesungen;
    }

    @Override
    public void update(Loesung args) {
        executeUpdate(SQLHelper.UPDATE_LOESUNG_QUERY(args));
    }

    @Override
    public void delete(Loesung args) {
        executeUpdate(SQLHelper.DELETE_LOESUNG_QUERY(args));
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return DBMaster.getDatabase().getSession().prepareStatement(query)
                    .executeQuery();
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }

    @Override
    public int getCount() {
        try {
            ResultSet res = executeQuery(SQLHelper.GET_LOESUNG_COUNT_QUERY());
            
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Loesung.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void executeUpdate(String query) {
        try {
            DBMaster.getDatabase().getSession().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Loesung.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
