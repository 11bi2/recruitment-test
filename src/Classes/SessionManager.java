/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import database.Table.Table_Aufgabe;
import database.Table.Table_Bewerber;
import database.Table.Table_Bewertung;
import database.Table.Table_Eingabe;
import database.Table.Table_Kategorie;
import database.Table.Table_Loesung;
import java.util.ArrayList;

/**
 *
 * @author sriga
 */
public class SessionManager {
    private ArrayList<Aufgabe> aufgaben;
    private ArrayList<Bewerber> bewerber;
    private ArrayList<Bewertung> bewertungen;
    private ArrayList<Eingabe> eingaben;
    private ArrayList<Kategorie> kategorien;
    private ArrayList<Loesung> loesungen;
    
    private SessionManager(){
        initSession();
    }
    
    private static SessionManager instance = null;
    
    public static SessionManager getInstance(){
        if (instance == null) {
            return instance = new SessionManager();
        }
        return instance;
    }
    
    private void initSession(){
        this.aufgaben = Table_Aufgabe.getInstance().getAllEntrys();
        this.bewerber = Table_Bewerber.getInstance().getAllEntrys();
        this.bewertungen = Table_Bewertung.getInstance().getAllEntrys();
        this.eingaben = Table_Eingabe.getInstance().getAllEntrys();
        this.kategorien = Table_Kategorie.getInstance().getAllEntrys();
        this.loesungen = Table_Loesung.getInstance().getAllEntrys();
    }
}
