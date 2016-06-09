/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Database_Objects.Aufgabe;
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
public class Table_Aufgabe extends Table<Aufgabe> implements SQLExecution {

    private Table_Aufgabe(){};
    
    private static Table_Aufgabe instance = null;
    
    public static Table getInstance() {
        if (instance == null) {
            instance = new Table_Aufgabe();
        }
        return instance;
    }

    @Override
    public void create(Aufgabe args) {
        executeUpdate(SQLHelper.INSERT_AUFGABE_QUERY(args));
        args.setId(getLastInsertedId());
    }

    @Override
    public Integer getLastInsertedId() {
        
        try {
            
            return executeQuery(SQLHelper.GET_LAST_INSERTED_AUFGABE_ID_QUERY())
                    .getInt(1);
            
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }

    @Override
    public Aufgabe getEntry(int id) {
        return Aufgabe.fromResultSet(executeQuery(
                SQLHelper.GET_AUFGABE_QUERY(id)));
    }

    @Override
    public ArrayList<Aufgabe> getAllEntrys() {
        ArrayList<Aufgabe> aufgaben = new ArrayList();
        
        try {
            
            ResultSet res = executeQuery(SQLHelper.GET_ALL_AUFGABE_QUERY());
            
            while(res.next()){
                aufgaben.add(Aufgabe.fromResultSet(res));
            }
            
        } catch (SQLException ex) {
            //UIHook here
        }
        return aufgaben;
    }

    @Override
    public void update(Aufgabe args) {
        executeUpdate(SQLHelper.DELETE_AUFGABE_QUERY(args));
    }

    @Override
    public void delete(Aufgabe args) {
        executeUpdate(SQLHelper.DELETE_AUFGABE_QUERY(args));
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return DBMaster.getDatabase().getSession().prepareStatement(
                    query).executeQuery();
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }

    @Override
    public int getCount() {
        try {
            ResultSet res =  executeQuery(SQLHelper.GET_AUFGABE_COUNT_QUERY());
        
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Aufgabe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void executeUpdate(String query) {
        try {
            DBMaster.getDatabase().getSession().prepareCall(query).executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Aufgabe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
