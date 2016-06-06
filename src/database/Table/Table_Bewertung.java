/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Classes.Bewertung;
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
public class Table_Bewertung extends Table<Bewertung> implements SQLExecution {
    
    private static Table_Bewertung instance = null;

    public static Table getInstance() {
        if (instance == null) {
            instance = new Table_Bewertung();
        }
        return instance;
    }

    @Override
    public void create(Bewertung args) {
        executeQuery(SQLHelper.INSERT_BEWERTUNG_QUERY(args));
        args.setId(getLastInsertedId());
    }

    @Override
    public Integer getLastInsertedId() {
        try {
            return executeQuery(SQLHelper.GET_LAST_INSERTED_BEWERTUNG_ID_QUERY())
                    .getInt(1);
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }

    @Override
    public Bewertung getEntry(int id) {
        return Bewertung.fromResultSet(
                executeQuery(SQLHelper.GET_ALL_BEWERTUNG_QUERY()));
    }

    @Override
    public ArrayList getAllEntrys() {
        ArrayList<Bewertung> bewertungen = new ArrayList();
        try {
            
            ResultSet res = executeQuery(SQLHelper.GET_ALL_BEWERTUNG_QUERY());
            
            while(res.next()){
                bewertungen.add(Bewertung.fromResultSet(res));
            }
        } catch (SQLException ex) {
            //UIHook here
        }
        return bewertungen;
    }

    @Override
    public void update(Bewertung args) {
        executeQuery(SQLHelper.UPDATE_BEWERTUNG_QUERY(args));
    }

    @Override
    public void delete(Bewertung args) {
        executeQuery(SQLHelper.DELETE_BEWERTUNG_QUERY(args));
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            return DBMaster.getDatabase().getSession().
                    prepareStatement(query).executeQuery();
        } catch (SQLException ex) {
            //UIHook here
        }
        return null;
    }
    
}
