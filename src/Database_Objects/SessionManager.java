/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database_Objects;

import database.Table.Table_Antwortmoeglichkeit;
import database.Table.Table_Aufgabe;
import database.Table.Table_Berufswahl;
import database.Table.Table_Bewerber;
import database.Table.Table_Ergebnis;
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
    private ArrayList<Antwortmoeglichkeit> antwortmoeglichkeiten = new ArrayList();
    private ArrayList<Aufgabe> aufgaben = new ArrayList();
    private ArrayList<Berufswahl> berufswahlen = new ArrayList();
    private ArrayList<Bewerber> bewerber = new ArrayList();
    private ArrayList<Kategorie> kategorien = new ArrayList();
    private ArrayList<Loesung> loesungen = new ArrayList();
    private ArrayList<Permissions> permissions = new ArrayList();
    private ArrayList<Schwierigkeit> schwierigkeiten = new ArrayList();
    private ArrayList<Ergebnis> ergebnisse = new ArrayList();

    public ArrayList<Ergebnis> getErgebnisse() {
        return ergebnisse;
    }
    

    public ArrayList<Antwortmoeglichkeit> getAntwortmoeglichkeiten() {
        return antwortmoeglichkeiten;
    }

    public ArrayList<Aufgabe> getAufgaben() {
        return aufgaben;
    }

    public ArrayList<Berufswahl> getBerufswahlen() {
        return berufswahlen;
    }

    public ArrayList<Bewerber> getBewerber() {
        return bewerber;
    }

    public ArrayList<Kategorie> getKategorien() {
        return kategorien;
    }

    public ArrayList<Loesung> getLoesungen() {
        return loesungen;
    }

    public ArrayList<Permissions> getPermissions() {
        return permissions;
    }

    public ArrayList<Schwierigkeit> getSchwierigkeiten() {
        return schwierigkeiten;
    }
    
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
        this.kategorien = Table_Kategorie.getInstance().getAllEntrys();
        this.loesungen = Table_Loesung.getInstance().getAllEntrys();
        this.permissions = Table_Permissions.getInstance().getAllEntrys();
        this.schwierigkeiten = Table_Schwierigkeit.getInstance().getAllEntrys();
        this.ergebnisse = Table_Ergebnis.getInstance().getAllEntrys();
    }
    
    public void addAntwortmoeglichkeit(Antwortmoeglichkeit a){
        this.antwortmoeglichkeiten.add(a);
    }
    public void addAufgabe(Aufgabe a){
        this.aufgaben.add(a);
    }
    public void addBerufsauswahl(Berufswahl b){
        this.berufswahlen.add(b);
    }
    public void addBewerber(Bewerber b){
        this.bewerber.add(b);
    }
    public void addKategorie(Kategorie k){
        this.kategorien.add(k);
    }
    public void addLoesung(Loesung l){
        this.loesungen.add(l);
    }
    public void addPermission(Permissions p){
        this.permissions.add(p);
    }
    public void addSchwierigkeit(Schwierigkeit s){
        this.schwierigkeiten.add(s);
    }
    public Antwortmoeglichkeit getAntwortmoeglichkeitById(int id){
        for(Antwortmoeglichkeit a: this.antwortmoeglichkeiten){
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
    public Aufgabe getAufgabeById(int id){
        for(Aufgabe a: this.aufgaben){
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }
    public Berufswahl getBerufswahlById(int id){
        for(Berufswahl b : this.berufswahlen){
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
    public Bewerber getBewerberById(int id){
        for(Bewerber b : this.bewerber){
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public Kategorie getKategorieById(int id){
        for(Kategorie k : this.kategorien){
            if (k.getId() == id) {
                return k;
            }
        }
        return null;
    }
    public Loesung getLoesungById(int id){
        for(Loesung l : this.loesungen){
            if (l.getId() == id) {
                return l;
            }
        }
        return null;
    }
    public Permissions getPermissionById(int id){
        for(Permissions p : this.permissions){
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    public Schwierigkeit getSchwierigkeitById(int id){
        for(Schwierigkeit s : this.schwierigkeiten){
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
    
    public double getPunktezahlDurchschnitt(){
        int punkteGesamt = 0;
        int pruefungenCount = this.getErgebnisse().size();
        
        for(Ergebnis e : ergebnisse){
            punkteGesamt += e.getPunktzahl();
        }
        return punkteGesamt / pruefungenCount;
    }
    
    public double getBestandenDurchschnitt(){
        int pruefungenCount = this.getErgebnisse().size();
        int bestandenePruefungen = 0;
        
        for(Ergebnis e : ergebnisse){
            if (e.getErgebnis() == 1) {
                bestandenePruefungen += 1;
            }
        }
        
        return bestandenePruefungen / pruefungenCount;
    }
    
    public String[][] resultsToTableSet(){
        String[][] results = new String[ergebnisse.size()][ergebnisse.size()];
        
        for (int i = 0; i < ergebnisse.size(); i++) {
            results[i]= ergebnisse.get(i).toTableSet();
        }
        
        return results;
    }
}
