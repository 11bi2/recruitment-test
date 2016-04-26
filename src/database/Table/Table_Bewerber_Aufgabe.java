/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import Classes.Aufgabe;
import Classes.Bewerber;
import DBMaster.DBMaster;
import database.Table.Helper.SQLHelper;
import database.Table.Interface.NtoM;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sriga
 */
public class Table_Bewerber_Aufgabe implements NtoM<Bewerber, Aufgabe>{ 

    private ResultSet results;
    private static Table_Bewerber_Aufgabe instance = null;
    
    @Override
    public Table_Bewerber_Aufgabe getInstance() {
        if(instance == null){
            instance = new Table_Bewerber_Aufgabe();
        }
        return instance;
    }

    @Override
    public void create(Bewerber b, Aufgabe a) {
        try {
            
            DBMaster.getDatabase().getSession().prepareStatement(
                    SQLHelper.INSERT_BEWERBER_AUFGABE_LINK(b, a)).executeQuery()
                    .close();
            
        } catch (SQLException ex) {
            //UIHook here
        }
    }

    @Override
    public ArrayList<Bewerber> getEntrysN(Aufgabe a) {
        ArrayList<Integer> ids = new ArrayList();
        ArrayList<Bewerber> bewerber = new ArrayList();
        
        try {
            
            results = DBMaster.getDatabase().getSession().prepareStatement(
                    SQLHelper.GET_BEWERBER_IDS_BY_AUFGABEN_ID(a)).executeQuery();
            
            while (results.next()){
                ids.add(results.getInt(1));
            }
            
            for (int i : ids) {
                results = DBMaster.getDatabase().getSession().prepareStatement(
                        SQLHelper.GET_BEWERBER_QUERY(i)).executeQuery();
                results.next();
                bewerber.add(Bewerber.fromResultSet(results));
            }
         
            results.close();
        } catch (SQLException ex) {
            //UIHook here
        }
        return bewerber;
    }

    @Override
    public ArrayList<Aufgabe> getEntrysM(Bewerber b) {
        ArrayList<Integer> ids = new ArrayList();
        ArrayList<Aufgabe> aufgaben = new ArrayList();
        
        try {
            
            results = DBMaster.getDatabase().getSession().prepareStatement(
                    SQLHelper.GET_AUFGABEN_IDS_BY_BEWEREBR_ID(b)).executeQuery();
            
            while(results.next()){
                ids.add(results.getInt(1));
            }
            
            ids.stream().forEach((_item) -> {
                //Aufgaben geter
                
                aufgaben.add(Aufgabe.fromResultSet(results));
            });
            
            results.close();
        } catch (SQLException ex) {
            //UIHook here
        }
        return aufgaben;
    }

    @Override
    public void deleteN(Bewerber b) {
        try {
            
            DBMaster.getDatabase().getSession().prepareStatement(
                    SQLHelper.DELETE_BEWERBER_LINK_QUERY(b)).executeQuery()
                    .close();
            
        } catch (SQLException ex) {
            //UIHook here
        }
    }

    @Override
    public void deleteM(Aufgabe a) {
        try {
            
            DBMaster.getDatabase().getSession().prepareStatement(
                    SQLHelper.DELETE_AUFGABEN_LINK_QUERY(a)).executeQuery()
                    .close();
        
        } catch (SQLException ex) {
            //UIHook here
        }
    }

}
