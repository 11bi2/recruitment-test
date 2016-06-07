/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Classes.Schwierigkeit;
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
public class Table_Schwierigkeit extends Table<Schwierigkeit> implements SQLExecution {

    private Table_Schwierigkeit(){}
    
    private static Table_Schwierigkeit instance = null;
    
    public static Table_Schwierigkeit getInstance(){
        if (instance == null) {
            return instance = new Table_Schwierigkeit();
        }
        return instance;
    }
    
    @Override
    public void create(Schwierigkeit args) {
        executeQuery(SQLHelper.INSERT_SCHWIERIGKEIT_QUERY(args));
        args.setIdSchwierigkeit(this.getLastInsertedId());
    }

    @Override
    public Integer getLastInsertedId() {
        try {
            return executeQuery(SQLHelper.GET_LAST_INSERTED_SCHWIERIGKEIT_QUERY()).getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Table_Schwierigkeit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Schwierigkeit getEntry(int id) {
        return Schwierigkeit.fromResultSet(executeQuery(SQLHelper.GET_SCHWIERIGKEIT_ENTRY_QUERY(id)));
    }

    @Override
    public ArrayList<Schwierigkeit> getAllEntrys() {
        ArrayList<Schwierigkeit> results = new ArrayList();
        
        ResultSet res = executeQuery(SQLHelper.GET_ALL_SCHWIERIGKEIT_ENTRY_QUERY());
        
        try {
            while(res.next()){
                results.add(Schwierigkeit.fromResultSet(res));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Schwierigkeit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    @Override
    public void update(Schwierigkeit args) {
        executeQuery(SQLHelper.UPDATE_SCHWIERIGKEIT_QUERY(args));
    }

    @Override
    public void delete(Schwierigkeit args) {
        executeQuery(SQLHelper.DELETE_SCHWIERIGKEIT_QUERY(args));
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return DBMaster.getDatabase().getSession().prepareStatement(query).executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Schwierigkeit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
