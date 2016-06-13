/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import DBMaster.DBMaster;
import Database_Objects.Ergebnis;
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
public class Table_Ergebnis extends Table<Ergebnis> implements SQLExecution {

    private Table_Ergebnis(){}
    
    private static Table_Ergebnis instance = null;
    
    public static Table_Ergebnis getInstance(){
        if (instance == null) {
            return instance = new Table_Ergebnis();
        }
        return instance;
    }
    
    @Override
    public void create(Ergebnis args) {
        executeUpdate(SQLHelper.INSERT_ERGEBNIS_QUERY(args));
        args.setId(this.getLastInsertedId());
    }

    @Override
    public Integer getLastInsertedId() {
        ResultSet res = executeQuery(SQLHelper.GET_LAST_INSERTED_ERGEBNIS_QUERY());
        
        try {
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Ergebnis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Ergebnis getEntry(int id) {
        return Ergebnis.fromResultSet(executeQuery(SQLHelper.GET_ERGEBNIS_ENTRY_QUERY(id)));
    }

    @Override
    public ArrayList<Ergebnis> getAllEntrys() {
        ArrayList<Ergebnis> results = new ArrayList();
        
        ResultSet res = executeQuery(SQLHelper.GET_ALL_ERGEBNIS_ENTRY_QUERY());
        
        try {
            while(res.next()){
                results.add(Ergebnis.fromResultSet(res));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Ergebnis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return results;
    }

    @Override
    public void update(Ergebnis args) {
        executeUpdate(SQLHelper.UPDATE_ERGEBNIS_QUERY(args));
    }

    @Override
    public void delete(Ergebnis args) {
        executeUpdate(SQLHelper.DELETE_ERGEBNIS_QUERY(args));
    }

    @Override
    public int getCount() {
        ResultSet res = executeQuery(SQLHelper.GET_ERGEBNIS_COUNT_QUERY());
    
        try {
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Ergebnis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return DBMaster.getDatabase().getSession().prepareStatement(query).executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Ergebnis.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void executeUpdate(String query) {
        try {
            DBMaster.getDatabase().getSession().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Ergebnis.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
