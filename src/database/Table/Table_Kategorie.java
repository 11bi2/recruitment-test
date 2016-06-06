/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Classes.Kategorie;
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
public class Table_Kategorie extends Table<Kategorie>  implements SQLExecution{

    private static Table_Kategorie instance = null;
    
    public static Table getInstance() {
        if (instance == null) {
            instance = new Table_Kategorie();
        }
        return instance;
    }

    @Override
    public void create(Kategorie args) {
        executeQuery(SQLHelper.INSERT_KATEGORIE_QUERY(args));
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
        executeQuery(SQLHelper.UPDATE_KATEGORIE_QUERY(args));
    }

    @Override
    public void delete(Kategorie args) {
        executeQuery(SQLHelper.DELETE_KATEGORIE_QUERY(args));
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
