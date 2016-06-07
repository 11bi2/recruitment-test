/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Classes.Aufgabe;
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
        executeQuery(SQLHelper.INSERT_AUFGABE_QUERY(args));
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
        executeQuery(SQLHelper.DELETE_AUFGABE_QUERY(args));
    }

    @Override
    public void delete(Aufgabe args) {
        executeQuery(SQLHelper.DELETE_AUFGABE_QUERY(args));
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
    
}
