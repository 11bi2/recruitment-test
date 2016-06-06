/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table.Helper;

import Classes.Aufgabe;
import Classes.Bewerber;
import Classes.Bewertung;
import Classes.Eingabe;
import Classes.Kategorie;
import Classes.Loesung;

/**
 *
 * @author sriga
 */
public class SQLHelper {
    
    //Constants
    
    //Tables
    private static final String TABLE_BEWERBER = "bewerber";
    private static final String TABLE_KATEGORIE = "kategorie";
    private static final String TABLE_AUFGABE = "aufgaben";
    private static final String TABLE_BEWERTUNG = "bewertung";
    private static final String TABLE_LOESUNG = "loesung";
    private static final String TABLE_EINGABE = "eingabe";
    private static final String TABLE_BEWERBER_AUFGABE = "Bewerber_Aufgabe";
    
    //Bewerber Columns
    private static final String KEY_BEWERBER_ID = "idBewerber";
    private static final String KEY_BEWERBER_VORNAME = "Vorname";
    private static final String KEY_BEWERBER_NACHNAME = "Nachname";
    private static final String KEY_BEWERBER_GEBURTSTAG = "Geburtstag";
    private static final String KEY_BEWERBER_EMAIL = "EMail";
    private static final String KEY_BEWERBER_ABSCHLUSS = "Abschluss";
    private static final String KEY_BEWERBER_BERUFSWAHL = "Berufswahl";
    private static final String KEY_BEWERBER_PASSWORD  = "Password";
    
    //Aufgaben Columsn
    private static final String KEY_AUFGABE_ID = "idAufgabe";
    private static final String KEY_AUFGABE_BEWERTUNG_ID = "idBewertung";
    private static final String KEY_AUFGABE_BILD = "Bild";
    private static final String KEY_AUFGABE_AUFGABENSTELLUNG = "Aufgabenstellung";
    private static final String KEY_AUFGABE_HILFESTELLUNG = "Hilfestellung";
    
    //Kategorie Columns
    private static final String KEY_KATEGORIE_ID = "idKategorie";
    private static final String KEY_KATEGORIE_BEWERBER_ID = "idBewerber";
    private static final String KEY_KATEGORIE_AUFGABE_ID = "idAufgabe";
    private static final String KEY_KATEGORIE_KATEGORIEBEZEICHNUNG = "Kategoriebezeichnung";
    private static final String KEY_KATEGORIE_VERFUEGBARE_ZEIT = "Verfuegbare_Zeit";
    
    //Bewertung Columns
    private static final String KEY_BEWERTUNG_ID = "idBewertung";
    private static final String KEY_BEWERTUNG_ERREICHTE_PUNKTZAHL = "Erreichte_Punktzahl";
    private static final String KEY_BEWERTUNG_MOEGLICHE_PUNKTZAHL = "Moegliche_Punktzahl";
    
    //Loesung Columns
    public static final String KEY_LOESUNG_ID = "idLoesung";
    public static final String KEY_LOESUNG_AUFGABE_ID = "idAufgabe";
    public static final String KEY_LOESUNG_TEXT = "Text_Loesung";
    
    //Eingabe Columns
    public static final String KEY_EINGABE_ID = "idEingabe";
    public static final String KEY_EINGABE_AUFGABE_ID = "idAufgabe";
    public static final String KEY_EINGABE_TEXT = "Text_Eingabe";
    
  /**
   *############################################################################
   * Bewerber Querys
   *############################################################################
   */
    
    public static String INSERT_BEWERBER_QUERY(Bewerber b){
        return "INSERT INTO " + TABLE_BEWERBER +
                " (" + 
                KEY_BEWERBER_VORNAME + ", " +
                KEY_BEWERBER_NACHNAME + ", " +
                KEY_BEWERBER_GEBURTSTAG + ", " +
                KEY_BEWERBER_EMAIL + ", " + 
                KEY_BEWERBER_ABSCHLUSS + ", " +
                KEY_BEWERBER_BERUFSWAHL +
                ") VALUES(" +
                    b.getVorName() + ", " +
                    b.getNachName() + ", " +
                    b.getGeburtsTag() + ", " +
                    b.geteMail() + ", " +
                    b.getAbschluss() + ", " +
                    b.getBerufsWahl() + 
                ");";
    }
    
    public static String GET_LAST_INSERT_BEWERBER_ID_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_BEWERBER + ";";
    }
    
    public static String GET_BEWERBER_QUERY(int id){
        return "SELECT * FROM " + TABLE_BEWERBER + 
               " WHERE " + KEY_BEWERBER_ID + " = " + id + ";";
    }
    
    public static String GET_ALL_BEWERBER_QUERY(){
        return "SELECT * FROM " + TABLE_BEWERBER +";";
    }
    
    public static String UPDATE_BEWERBER_QUERY(Bewerber b){
        return "UPDATE " + TABLE_BEWERBER + " SET " +
                KEY_BEWERBER_VORNAME + " = " + b.getVorName() + ", " +
                KEY_BEWERBER_NACHNAME + " = " + b.getNachName() + ", " +
                KEY_BEWERBER_GEBURTSTAG + " = " + b.getGeburtsTag() + ", " +
                KEY_BEWERBER_EMAIL + " = " + b.geteMail() + ", " +
                KEY_BEWERBER_ABSCHLUSS + " = " + b.getAbschluss() + ", " +
                KEY_BEWERBER_BERUFSWAHL + " = " + b.getBerufsWahl() + " " +
                "WHERE " + KEY_BEWERBER_ID + " = " + b.getId() +";";
    }
    
    public static String DELETE_BEWERBER_QUERY(Bewerber b){
        return "DELETE FROM " + TABLE_BEWERBER + " WHERE " + KEY_BEWERBER_ID + " = " + b.getId() + ";";
    }
    
    public static String AUTHENTICATE_BEWERBER(String vorName, String nachName, String password){
        return "SELECT * FROM " + TABLE_BEWERBER + " WHERE " +
                KEY_BEWERBER_VORNAME + " = '" + vorName + "' AND " +
                KEY_BEWERBER_NACHNAME + " = '" + nachName + "' AND " +
                KEY_BEWERBER_PASSWORD + " = '" + password + "';";
    }
    
    /**
     *##########################################################################
     * Aufgabe Querys
     *##########################################################################
     */
    
    
    public static String INSERT_AUFGABE_QUERY(Aufgabe a){
        return "INSERT INTO " + TABLE_AUFGABE + " " +
                "(" +
                    KEY_AUFGABE_BEWERTUNG_ID + ", " +
                    KEY_AUFGABE_AUFGABENSTELLUNG + ", " +
                    KEY_AUFGABE_BILD + ", " +
                    KEY_AUFGABE_HILFESTELLUNG +
                ") values(" +
                    a.getBewertungId() + ", " +
                    a.getAufgabenstellung() + ", " +
                    a.getPicture() + ", " +
                    a.getHilfestellung() +
                ");";
                
    }
    
    public static String GET_LAST_INSERTED_AUFGABE_ID_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_AUFGABE + ";";
    }
    
    public static String GET_AUFGABE_QUERY(int id){
        return "SELECT * FROM " + TABLE_AUFGABE + " " +
                "WHERE " + KEY_AUFGABE_ID +  " = " + id + ";";
    }
    
    public static String GET_ALL_AUFGABE_QUERY(){
        return "SELECT * FROM " + TABLE_AUFGABE + ";";
    }
    
    public static String UPDATE_AUFGABE_QUERY(Aufgabe a){
        return "UPDATE " + TABLE_AUFGABE + " SET " +
                KEY_AUFGABE_BEWERTUNG_ID + " = " + a.getBewertungId() + ", " +
                KEY_AUFGABE_AUFGABENSTELLUNG + " = " + a.getAufgabenstellung() + ", " +
                KEY_AUFGABE_BILD + " = " + a.getPicture() + ", " +
                KEY_AUFGABE_HILFESTELLUNG + " = " + a.getHilfestellung() + " " +
                "WHERE " + KEY_AUFGABE_ID + " = " + a.getId() + ";";
                
    }
    
    public static String DELETE_AUFGABE_QUERY(Aufgabe a){
        return "DELETE FROM " + TABLE_AUFGABE + " " +
                "WHERE " + KEY_AUFGABE_ID + " = " + a.getId() + ";";
    }
    
    /**
     *##########################################################################
     * Kategorie Querys
     *##########################################################################
     */
    
    public static String INSERT_KATEGORIE_QUERY(Kategorie k){
        return "INSERT INTO " + TABLE_KATEGORIE + " " +
                "(" +
                    KEY_KATEGORIE_BEWERBER_ID + ", " +
                    KEY_KATEGORIE_AUFGABE_ID + ", " +
                    KEY_KATEGORIE_KATEGORIEBEZEICHNUNG + ", " +
                    KEY_KATEGORIE_VERFUEGBARE_ZEIT +
                ") values(" +
                    k.getBewerberID() + ", " +
                    k.getAufgabeID() + ", " +
                    k.getKategorieBezeichnung() + ", " +
                    k.getVerfuegbareZeit() +
                ");";
    }
    
    public static String GET_LAST_INSERTED_KATEGORIE_ID_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_KATEGORIE + ";";
    }
    
    public static String GET_KATEGORIE_QUERY(int id){
        return "SELECT * FROM " + TABLE_KATEGORIE + " " +
                "WHERE " + KEY_KATEGORIE_ID + " = " + id + ";";
    }
    
    public static String GET_ALL_KATEGORIE_QUERY(){
        return "SELECT * FROM " + TABLE_KATEGORIE + ";";
    }
    
    public static String UPDATE_KATEGORIE_QUERY(Kategorie k){
        return "UPDATE " + TABLE_KATEGORIE + " SET " +
                KEY_KATEGORIE_BEWERBER_ID + " = " + k.getBewerberID() + ", " +
                KEY_KATEGORIE_AUFGABE_ID + " = " + k.getAufgabeID() + ", " +
                KEY_KATEGORIE_KATEGORIEBEZEICHNUNG + " = " + k.getKategorieBezeichnung() + ", " +
                KEY_KATEGORIE_VERFUEGBARE_ZEIT + " = " + k.getVerfuegbareZeit() + " " +
                "WHERE " + KEY_KATEGORIE_ID + " = " + k.getId() + ";";
    }
    
    public static String DELETE_KATEGORIE_QUERY(Kategorie k){
        return "DELETE FROM " + TABLE_KATEGORIE + " " +
                "WHERE " + KEY_KATEGORIE_ID + " = " + k.getId() + ";";
    }
    
    /**
     *##########################################################################
     * Bewertung
     *##########################################################################
     */
    
    public static String INSERT_BEWERTUNG_QUERY(Bewertung b){
        return "INSERT INTO " + TABLE_BEWERTUNG + " " +
                "(" +
                    KEY_BEWERTUNG_ERREICHTE_PUNKTZAHL + ", " +
                    KEY_BEWERTUNG_MOEGLICHE_PUNKTZAHL +
                ") values(" +
                    b.getErreichtePunktzahl() + ", " +
                    b.getMoegliche_punktzahl() +
                ");";
    }
    
    
    public static String GET_LAST_INSERTED_BEWERTUNG_ID_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_BEWERTUNG + ";";
    }
    
    public static String GET_BEWERTUNG_QUERY(int id){
        return "SELECT * FROM " + TABLE_BEWERTUNG + " " +
               "WHERE " + KEY_BEWERTUNG_ID + " = " + id + ";";
    }
    
    public static String GET_ALL_BEWERTUNG_QUERY(){
        return "SELECT * FROM " + TABLE_BEWERTUNG + ";";
    }
    
    public static String UPDATE_BEWERTUNG_QUERY(Bewertung b){
        return "UPDATE " + TABLE_BEWERTUNG + " SET " +
                KEY_BEWERTUNG_ERREICHTE_PUNKTZAHL + " = " + b.getErreichtePunktzahl() + ", " +
                KEY_BEWERTUNG_MOEGLICHE_PUNKTZAHL + " = " + b.getMoegliche_punktzahl() + " " +
                "WHERE " + KEY_BEWERTUNG_ID + " = " + b.getId() + ";";
    }
    
    public static String DELETE_BEWERTUNG_QUERY(Bewertung b){
        return "DELETE FROM " + TABLE_BEWERTUNG + " WHERE " +
                KEY_BEWERTUNG_ID + " = " + b.getId() + ";";
    }
    
    /**
     *##########################################################################
     * Loesung Querys
     * #########################################################################
     */
    
    public static String INSERT_LOESUNG_QUERY(Loesung l){
        return "INSERT INTO " + TABLE_LOESUNG + " " +
                "(" +
                    KEY_LOESUNG_AUFGABE_ID + ", " +
                    KEY_LOESUNG_TEXT + 
                ") values(" +
                    l.getAufgabeId() + ", " +
                    l.getTextLoesung() +
                ");";
    }
    
    public static String GET_LAST_INSERTED_LOESUNG_ID(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_LOESUNG + ";";
    }
    
    public static String GET_LOESUNG_QUERY(int id){
        return "SELECT * FROM " + TABLE_LOESUNG + " " +
                "WHERE " + KEY_LOESUNG_ID + " = " + id + ";";
    }
    
    public static String GET_ALL_LOESUNG_QUERY(){
        return "SELECT * FROM " + TABLE_LOESUNG + ";";
    }
    
    public static String UPDATE_LOESUNG_QUERY(Loesung l){
        return "UPDATE " + TABLE_LOESUNG + " SET " +
                KEY_LOESUNG_AUFGABE_ID + " = " + l.getAufgabeId() + ", " +
                KEY_LOESUNG_TEXT + " = " + l.getTextLoesung() + " " +
                "WHERE " + KEY_LOESUNG_ID + " = " + l.getId() + ";";
    }
    
    public static String DELETE_LOESUNG_QUERY(Loesung l){
        return "DELETE FROM " + TABLE_LOESUNG + " " +
                "WHERE " + KEY_LOESUNG_ID + " = " + l.getId() + ";";
    }
    
    /**
     *##########################################################################
     * Eingabe Querys
     *##########################################################################
     */
    
    public static String INSERT_EINGABE_QUERY(Eingabe e){
        return "INSERT INTO " + TABLE_EINGABE + " " +
                "(" +
                    KEY_EINGABE_AUFGABE_ID + ", " +
                    KEY_EINGABE_TEXT + " " +
                ") values(" +
                    e.getAufgabeId() + ", " +
                    e.getText() + 
                ");";
    }
    
    public static String GET_LAST_INSERTED_EINGABE_ID_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_EINGABE + ";";
    }
    
    public static String GET_EINGABE_QUERY(int id){
        return "SELECT * FROM " + TABLE_EINGABE + " " +
                "WHERE " + KEY_EINGABE_ID + " = " + id + ";";
    }
    
    public static String GET_ALL_EINGABE_QUERY(){
        return "SELECT * FROM " + TABLE_EINGABE + ";";
    }
    
    public static String UPDATE_EINGABE_QUERY(Eingabe e){
        return "UPDATE " + TABLE_EINGABE + " SET " +
                    KEY_EINGABE_AUFGABE_ID + " = " + e.getAufgabeId() + ",  " +
                    KEY_EINGABE_TEXT + " = " + e.getText() + " " +
                "WHERE " + KEY_EINGABE_ID + " = " + e.getId() + ";";
    }
    
    public static String DELETE_EINGABE_QUERY(Eingabe e){
        return "DELETE FROM " + TABLE_EINGABE + " " +
                "WHERE " + KEY_EINGABE_ID + " = " + e.getId();
    }
    
    /**
     *##########################################################################
     * Bewerber_Aufgaben Querys
     *##########################################################################
     */
    
    public static String INSERT_BEWERBER_AUFGABE_LINK(Bewerber b, Aufgabe a){
        return "INSERT INTO " + TABLE_BEWERBER_AUFGABE + 
                " (" +
                    KEY_BEWERBER_ID + ", " +
                    KEY_AUFGABE_ID + 
                ") values(" +
                    b.getId() + ", " +
                    a.getId() + 
                ");";
    }
    
    public static String GET_AUFGABEN_IDS_BY_BEWEREBR_ID(Bewerber b){
        return "SELECT " + KEY_AUFGABE_ID + " " +
                "FROM " + TABLE_BEWERBER_AUFGABE + " " +
                "WHERE " + KEY_BEWERBER_ID + " = " + b.getId() + ";";
    }
    
    public static String GET_BEWERBER_IDS_BY_AUFGABEN_ID(Aufgabe a){
        return "SELECT " + KEY_BEWERBER_ID + " " +
                "From " + TABLE_BEWERBER_AUFGABE + " " +
                "WHERE " + KEY_AUFGABE_ID + " = " + a.getId() + ";";
    }
    
    public static String DELETE_BEWERBER_LINK_QUERY(Bewerber b){
        return "DELETE FROM " + TABLE_BEWERBER_AUFGABE + " " +
                "WHERE " + KEY_BEWERBER_ID + " = " + b.getId() + ";";
    }
    
    public static String DELETE_AUFGABEN_LINK_QUERY(Aufgabe a){
        return "DELETE FROM " + TABLE_BEWERBER_AUFGABE + " " +
                "WHERE " + KEY_AUFGABE_ID + " = " + a.getId() + ";";
    }
}
