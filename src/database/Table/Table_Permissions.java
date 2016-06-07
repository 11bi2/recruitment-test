/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Classes.Permissions;
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
public class Table_Permissions extends Table<Permissions> implements SQLExecution {

    private Table_Permissions(){}
    
    private static Table_Permissions instance = null;
    
    public static Table_Permissions getInstance(){
        if (instance == null) {
            return instance = new Table_Permissions();
        }
        return instance;
    }
    
    @Override
    public void create(Permissions args) {
        executeQuery(SQLHelper.INSERT_PERMISSION_QUERY(args));
        args.setIdPermisson(this.getLastInsertedId());
    }

    @Override
    public Integer getLastInsertedId() {
        ResultSet res = executeQuery(SQLHelper.GET_LAST_INSERTED_PERMISSIONS_ID_QUERY());
        try {
            return res.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Table_Permissions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Permissions getEntry(int id) {
        return Permissions.fromResultSet(executeQuery(SQLHelper.GET_PERMISSIONS_ENTRY_QUERY(id)));
    }

    @Override
    public ArrayList<Permissions> getAllEntrys() {
        ArrayList<Permissions> results = new ArrayList();
        
        ResultSet res = executeQuery(SQLHelper.GET_ALL_PERMISSIONS_ENTRY_QUERY());
        
        try {
            while(res.next()){
                results.add(Permissions.fromResultSet(res));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Table_Permissions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return results;
    }

    @Override
    public void update(Permissions args) {
        executeQuery(SQLHelper.UPDATE_PERMISSIONS_QUERY(args));
    }

    @Override
    public void delete(Permissions args) {
        executeQuery(SQLHelper.DELETE_PERMISSIONS_QUERY(args));
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return DBMaster.getDatabase().getSession().prepareStatement(query).executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Table_Permissions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
