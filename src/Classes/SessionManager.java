/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import database.Table.Table_Antwortmoeglichkeit;
import database.Table.Table_Aufgabe;
import database.Table.Table_Berufswahl;
import database.Table.Table_Bewerber;
import database.Table.Table_Eingabe;
import database.Table.Table_Kategorie;
import database.Table.Table_Loesung;
import database.Table.Table_Permissions;
import database.Table.Table_Schwierigkeit;
import java.util.ArrayList;

/**
 *
 * @author sriga
 */
public class SessionManager {
    private ArrayList<Antwortmoeglichkeit> antwortmoeglichkeiten;
    private ArrayList<Aufgabe> aufgaben;
    private ArrayList<Berufswahl> berufswahlen;
    private ArrayList<Bewerber> bewerber;
    private ArrayList<Eingabe> eingaben;
    private ArrayList<Kategorie> kategorien;
    private ArrayList<Loesung> loesungen;
    private ArrayList<Permissions> permissions;
    private ArrayList<Schwierigkeit> schwierigkeiten;
    
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
        this.antwortmoeglichkeiten = Table_Antwortmoeglichkeit.getInstance().getAllEntrys();
        this.aufgaben = Table_Aufgabe.getInstance().getAllEntrys();
        this.berufswahlen = Table_Berufswahl.getInstance().getAllEntrys();
        this.bewerber = Table_Bewerber.getInstance().getAllEntrys();
        this.eingaben = Table_Eingabe.getInstance().getAllEntrys();
        this.kategorien = Table_Kategorie.getInstance().getAllEntrys();
        this.loesungen = Table_Loesung.getInstance().getAllEntrys();
        this.permissions = Table_Permissions.getInstance().getAllEntrys();
        this.schwierigkeiten = Table_Schwierigkeit.getInstance().getAllEntrys();
    }
}
