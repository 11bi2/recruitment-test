/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Classes.Berufswahl;
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
public class Table_Berufswahl extends Table<Berufswahl> implements SQLExecution {
    
    private Table_Berufswahl(){};
    
    private static Table_Berufswahl instance = null;
    
    public static Table_Berufswahl getInstance(){
        if (instance == null) {
            return instance = new Table_Berufswahl();
        }
        return instance;
    }

    @Override
    public void create(Berufswahl args) {
        executeQuery(SQLHelper.INSERT_BERUFSWAHL_QUERY(args));
        args.setIdBerufswahl(this.getLastInsertedId());
    }

    @Override
    public Integer getLastInsertedId() {
        ResultSet res = executeQuery(SQLHelper.GET_LAST_INSERTED_BERUFSWAHL_ID_QUERY());
        
        try {
            return res.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Table_Berufswahl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Berufswahl getEntry(int id) {
        return Berufswahl.fromResultSet(executeQuery(SQLHelper.GET_BERUFSWAHL_ENTRY_QUERY(id)));
    }

    @Override
    public ArrayList<Berufswahl> getAllEntrys() {
        ArrayList<Berufswahl> results = new ArrayList();
        
        ResultSet res = executeQuery(SQLHelper.GET_ALL_BERUFSWAHL_ENTRY_QUERY());
        
        try {
            while(res.next()){
                results.add(Berufswahl.fromResultSet(res));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Berufswahl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }

    @Override
    public void update(Berufswahl args) {
        executeQuery(SQLHelper.UPDATE_BERUFSWAHL_QUERY(args));
    }

    @Override
    public void delete(Berufswahl args) {
        executeQuery(SQLHelper.DELETE_BERUFSWAHL_QUERY(args));
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return DBMaster.getDatabase().getSession().prepareStatement(query).executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Berufswahl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
