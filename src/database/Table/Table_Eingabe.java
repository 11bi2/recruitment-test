/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Classes.Eingabe;
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
 * @author root
 */
public class Table_Eingabe extends Table<Eingabe> implements SQLExecution {

    private static Table_Eingabe instance = null;
    
    private Table_Eingabe(){};
    
    @Override
    public Table getInstance() {
        if (instance == null) {
            instance = new Table_Eingabe();
        }
        return instance;
    }

    @Override
    public void create(Eingabe args) {
        executeQuery(SQLHelper.INSERT_EINGABE_QUERY(args));
    }

    @Override
    public Integer getLastInsertedId() {
        try {
            return executeQuery(SQLHelper.GET_LAST_INSERTED_EINGABE_ID_QUERY())
                    .getInt(1);
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }

    @Override
    public Eingabe getEntry(int id) {
        return Eingabe.fromResultSet(executeQuery(
                SQLHelper.GET_EINGABE_QUERY(id)));
 
    }

    @Override
    public ArrayList<Eingabe> getAllEntrys() {
        ArrayList<Eingabe> eingaben = new ArrayList();
        
        try{
            ResultSet res = executeQuery(SQLHelper.GET_ALL_EINGABE_QUERY());
            
            while(res.next()){
                eingaben.add(Eingabe.fromResultSet(res));
            }
        } catch (SQLException ex) {
            //UIHook here
        }
        return eingaben;
    }

    @Override
    public void update(Eingabe args) {
        executeQuery(SQLHelper.UPDATE_EINGABE_QUERY(args));
    }

    @Override
    public void delete(Eingabe args) {
        executeQuery(SQLHelper.DELETE_EINGABE_QUERY(args));
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return DBMaster.getDatabase().getSession()
                    .prepareStatement(query).executeQuery();
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
    
}
