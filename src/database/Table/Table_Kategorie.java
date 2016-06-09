/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Database_Objects.Kategorie;
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
public class Table_Kategorie extends Table<Kategorie>  implements SQLExecution{

    private Table_Kategorie(){}
    
    private static Table_Kategorie instance = null;
    
    public static Table getInstance() {
        if (instance == null) {
            instance = new Table_Kategorie();
        }
        return instance;
    }

    @Override
    public void create(Kategorie args) {
        executeUpdate(SQLHelper.INSERT_KATEGORIE_QUERY(args));
        args.setId(getLastInsertedId());
    }

    @Override
    public Integer getLastInsertedId() {
        try {
            return executeQuery(SQLHelper.GET_LAST_INSERTED_KATEGORIE_ID_QUERY()).getInt(1);
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }

    @Override
    public Kategorie getEntry(int id) {    
        return Kategorie.fromResultSet(executeQuery(SQLHelper.GET_KATEGORIE_QUERY(id)));
    }

    @Override
    public ArrayList<Kategorie> getAllEntrys() {
        ArrayList<Kategorie> kategorien = new ArrayList();
        
        try {
            
            ResultSet res = executeQuery(SQLHelper.GET_ALL_KATEGORIE_QUERY());
            
            while(res.next()){
                kategorien.add(Kategorie.fromResultSet(res));
            }
            
            return kategorien;
        } catch (SQLException ex) {
            //UIHook here
        }
        return kategorien;
    }

    @Override
    public void update(Kategorie args) {
        executeUpdate(SQLHelper.UPDATE_KATEGORIE_QUERY(args));
    }

    @Override
    public void delete(Kategorie args) {
        executeUpdate(SQLHelper.DELETE_KATEGORIE_QUERY(args));
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

    @Override
    public int getCount() {
        try {
            ResultSet res = executeQuery(SQLHelper.GET_KATEGORIE_COUNT_QUERY());
            
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Kategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public void executeUpdate(String query) {
        try {
            DBMaster.getDatabase().getSession().prepareStatement(query).executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Kategorie.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
