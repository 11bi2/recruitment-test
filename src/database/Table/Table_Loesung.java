/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Classes.Loesung;
import DBMaster.DBMaster;
import database.Table.Helper.SQLHelper;
import database.Table.Interface.SQLExecution;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sriga
 */
public class Table_Loesung extends Table<Loesung> implements SQLExecution {
    
    private static Table_Loesung instance = null;

    @Override
    public Table getInstance() {
        if (instance == null) {
            instance = new Table_Loesung();
        }
        return instance;
    }

    @Override
    public void create(Loesung args) {
        executeQuery(SQLHelper.INSERT_LOESUNG_QUERY(args));
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
        executeQuery(SQLHelper.UPDATE_LOESUNG_QUERY(args));
    }

    @Override
    public void delete(Loesung args) {
        executeQuery(SQLHelper.DELETE_LOESUNG_QUERY(args));
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
    
}
