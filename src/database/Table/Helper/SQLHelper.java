/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table.Helper;

import Database_Objects.Antwortmoeglichkeit;
import Database_Objects.Aufgabe;
import Database_Objects.Berufswahl;
import Database_Objects.Bewerber;
import Database_Objects.Eingabe;
import Database_Objects.Ergebnis;
import Database_Objects.Kategorie;
import Database_Objects.Loesung;
import Database_Objects.Permissions;
import Database_Objects.Schwierigkeit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author sriga
 */
public class SQLHelper {
    
    //Constants
    
    //Date Formatter
    private static final SimpleDateFormat STANDARD_DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd");
    
    //Tables
    private static final String TABLE_ANTWORTMOEGLICHKEITEN = "antwortmoeglichkeiten";
    private static final String TABLE_AUFGABE = "aufgaben";
    private static final String TABLE_BERUFSWAHL = "berufswahl";
    private static final String TABLE_BEWERBER = "bewerber";
    private static final String TABLE_EINGABE = "eingabe";
    private static final String TABLE_KATEGORIE = "kategorien";
    private static final String TABLE_LOESUNG = "loesung";
    private static final String TABLE_PERMISSIONS = "permissions";
    private static final String TABLE_SCHWIERIGKEIT = "schwierigkeit";
    private static final String TABLE_ERGEBNIS = "ergebnis";
    
    //Antwortmoeglichkeiten Columns
    private static final String KEY_ANTWORTMOEGLICHKEITEN_ID = "ID_Antwortmoeglichkeit";
    private static final String KEY_ANTWORTMOEGLICHKEITEN_AUFGABE_ID = "Aufgaben_ID_Aufgaben";
    private static final String KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT1 = "Antwortmoeglichkeit1";
    private static final String KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT2 = "Antwortmoeglichkeit2";
    private static final String KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT3 = "Antwortmoeglichkeit3";
    private static final String KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT4 = "Antwortmoeglichkeit4";
    private static final String KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT5 = "Antwortmoeglichkeit5";
  
    //Aufgaben Columsn
    private static final String KEY_AUFGABE_ID = "ID_Aufgaben";
    private static final String KEY_AUFGABE_KATEGORIE_ID = "Kategorien_ID_Kategorie";
    private static final String KEY_AUFGABE_AUFGABENSTELLUNG = "Aufgabenstellung";
    private static final String KEY_AUFGABE_BILD = "Bild";
    private static final String KEY_AUFGABE_ANTWORTMOEGLICHKEITEN_ID = "antwortmoeglichkeiten_ID_Antwortmoeglichkeit";
    
    //Berufswahl Columns
    private static final String KEY_BERUFSWAHL_ID = "ID_Berufswahl";
    private static final String KEY_BERUFSWAHL_BERUFSBESCHREIBUNG = "Berufsbeschreibung";
    private static final String KEY_BERUFSWAHL_VORAUSSETZUNG = "Voraussetzung";
    
    //Bewerber Columns
    private static final String KEY_BEWERBER_ID = "ID_Bewerber";
    private static final String KEY_BEWERBER_BERUFSWAHLID = "Berufswahl_ID_Berufswahl";
    private static final String KEY_BEWERBER_PERMISSION_ID = "Permissions_ID_Permissions";
    private static final String KEY_BEWERBER_VORNAME = "Vorname";
    private static final String KEY_BEWERBER_NACHNAME = "Nachname";
    private static final String KEY_BEWERBER_GEBURTSTAG = "Geburtstag";
    private static final String KEY_BEWERBER_EMAIL = "EMail";
    private static final String KEY_BEWERBER_PERMISSION = "Permission";
    private static final String KEY_BEWERBER_CREATED = "Created";
    private static final String KEY_BEWERBER_FREIGABE = "Freigabe";
    private static final String KEY_BEWERBER_PASSWORD  = "assignedPassword";
    
    //Eingabe Columns
    private static final String KEY_EINGABE_ID = "ID_Eingabe";
    private static final String KEY_EINGABE_AUFGABE_ID = "Aufgaben_ID_Aufgaben";
    private static final String KEY_EINGABE_EINGABE = "Eingabe";
    
    //Kategorie Columns
    private static final String KEY_KATEGORIE_ID = "ID_Kategorien";
    private static final String KEY_KATEGORIE_BERUFSWAHL_ID = "Berufswahl_ID_Berufswahl";
    private static final String KEY_KATEGORIE_AUFGABE_ID = "Aufgaben_ID_Aufgaben";
    private static final String KEY_KATEGORIE_KATEGORIEBEZEICHNUNG = "Kategorienbezeichnung";
    private static final String KEY_KATEGORIE_VERFUEGBARE_ZEIT = "Verfuegbare_Zeit";
    
    //Loesung Columns
    public static final String KEY_LOESUNG_ID = "ID_Loesung";
    public static final String KEY_LOESUNG_AUFGABE_ID = "Aufgaben_ID_Aufgaben";
    public static final String KEY_LOESUNG_LOESUNG = "Text_Loesung";
    public static final String KEY_LOESUNG_MOEGLICHE_PUNKTE = "MoeglichePunkte";
    
    //Permissions Columns
    private static final String KEY_PERMISSIONS_ID = "ID_Permissions";
    private static final String KEY_PERMISSIONS_DESCRIPTION = "description";
    
    //Schwierigkeit Columns
    private static final String KEY_SCHWIERIGKEIT_ID = "ID_Schwierigkeit";
    private static final String KEY_SCHWIERIGKEIT_AUFGABE_ID = "Aufgaben_ID_Aufgaben";
    private static final String KEY_SCHWIERIGKEIT_ERREICHTE_PUNKTZAHL = "erreichte_punktzahl";
    private static final String KEY_SCHWIERIGKEIT_MOEGLICHE_PUNKTZAHL = "moegliche_punktzahl";
  
    
    //Ergebnis Columns
    private static final String KEY_ERGEBNIS_ID = "id_ergebnis";
    private static final String KEY_ERGEBNIS_BEWERBER_ID = "id_Bewerber";
    private static final String KEY_ERGEBNIS_DATUM = "datum";
    private static final String KEY_ERGEBNIS_PUNKTZAHL = "punktzahl";
    private static final String KEY_ERGEBNIS_ERGEBNIS = "ergebnis";
    /**
     * #########################################################################
     * Antwortmoeglichkeit Querys
     * #########################################################################
     */
    
    public static String INSERT_ANTWORTMOEGLICHKTEI_QUERY(Antwortmoeglichkeit a){
        return "INSERT INTO " + TABLE_ANTWORTMOEGLICHKEITEN + " (" +
                    KEY_ANTWORTMOEGLICHKEITEN_AUFGABE_ID + ", " +
                    KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT1 + ", " +
                    KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT2 + ", " +
                    KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT3 + ", " +
                    KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT4 + ", " +
                    KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT5 + 
                ") VALUES('" +
                    a.getIdAufgaben() + "', '" +
                    a.getAntwortMoeglichkeit1() + "', '" +
                    a.getAntwortMoeglichkeit2() + "', '" +
                    a.getAntwortMoeglichkeit3() + "', '" +
                    a.getAntwortMoeglichkeit4() + "', '" +
                    a.getAntwortMoeglichkeit5() + 
                "');";
   
                
    }
    
    public static String GET_LAST_INSERT_AUFGABENMOEGLICHKEITEN_ID_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_ANTWORTMOEGLICHKEITEN + ",";
    }
    
    public static String GET_ANTWORTMOEGLICHKEIT_QUERY(int id){
        return "SELECT * FROM " + TABLE_ANTWORTMOEGLICHKEITEN +  " " +
                "WHERE " + KEY_ANTWORTMOEGLICHKEITEN_ID + " = '" + id + "';";
    }
    
    public static String GET_ALL_ANTWORTMOEGLICHKEITEN_QUERY(){
        return "SELECT * FROM " + TABLE_ANTWORTMOEGLICHKEITEN + ";";
    }
    
    public static String UPDATE_ANTWORTMOEGLICHKEITEN_QUERY(Antwortmoeglichkeit a){
        return "UPDATE " + TABLE_ANTWORTMOEGLICHKEITEN + " SET " +
                KEY_ANTWORTMOEGLICHKEITEN_AUFGABE_ID + " = '" + a.getIdAufgaben() + "', " +
                KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT1 + " = '" + a.getAntwortMoeglichkeit1() + "', " +
                KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT2 + " = '" + a.getAntwortMoeglichkeit2() + "', " +
                KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT3 + " = '" + a.getAntwortMoeglichkeit3() + "', " +
                KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT4 + " = '" + a.getAntwortMoeglichkeit4() + "', " +
                KEY_ANTWORTMOEGLICHKEITEN_ANTWORTMOEGLICHKEIT5 + " = '" + a.getAntwortMoeglichkeit5() + "' " +
                "WHERE " + KEY_ANTWORTMOEGLICHKEITEN_ID + " = '" + a.getId() + "';";
                }
    
    public static String DELETE_ANTWORTMOEGLICHKEIT_QUERY(Antwortmoeglichkeit a){
        return "DELETE FROM " + TABLE_ANTWORTMOEGLICHKEITEN + " WHERE " +
                KEY_ANTWORTMOEGLICHKEITEN_ID + " = '" + a.getId() + "';";
    }
    
    public static String GET_ANTWORTMOEGLICHKEIT_COUNT_QUERY(){
        return "SELECT COUNT(" + KEY_ANTWORTMOEGLICHKEITEN_ID +  ")FROM " +
        TABLE_ANTWORTMOEGLICHKEITEN + ";";
    }
    
        /**
     *##########################################################################
     * Aufgabe Querys
     *##########################################################################
     */
    
    public static String INSERT_AUFGABE_QUERY(Aufgabe a){
        return "INSERT INTO " + TABLE_AUFGABE + " " +
                "(" +
                    KEY_AUFGABE_KATEGORIE_ID + ", " +
                    KEY_AUFGABE_AUFGABENSTELLUNG + ", " +
                    KEY_AUFGABE_BILD + ", " +
                    KEY_AUFGABE_ANTWORTMOEGLICHKEITEN_ID +
                ") values('" +
                    a.getIdKategorie()+ "', '" +
                    a.getAufgabenstellung() + "', '" +
                    a.getPicture() + "', '" +
                    a.getIdKategorie()+
                "');";
                
    }
    
    public static String GET_LAST_INSERTED_AUFGABE_ID_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_AUFGABE + ";";
    }
    
    public static String GET_AUFGABE_QUERY(int id){
        return "SELECT * FROM " + TABLE_AUFGABE + " " +
                "WHERE " + KEY_AUFGABE_ID +  " = '" + id + "';";
    }
    
    public static String GET_ALL_AUFGABE_QUERY(){
        return "SELECT * FROM " + TABLE_AUFGABE + ";";
    }
    
    public static String UPDATE_AUFGABE_QUERY(Aufgabe a){
        return "UPDATE " + TABLE_AUFGABE + " SET " +
                KEY_AUFGABE_KATEGORIE_ID + " = '" + a.getIdKategorie()+ "', " +
                KEY_AUFGABE_AUFGABENSTELLUNG + " = '" + a.getAufgabenstellung() + "', " +
                KEY_AUFGABE_BILD + " = '" + a.getPicture() + "', " +
                KEY_AUFGABE_ANTWORTMOEGLICHKEITEN_ID + " = '" + a.getIdAntwortMoeglichkeit()+ "' " +
                "WHERE " + KEY_AUFGABE_ID + " = '" + a.getId() + "';";
                
    }
    
    public static String DELETE_AUFGABE_QUERY(Aufgabe a){
        return "DELETE FROM " + TABLE_AUFGABE + " " +
                "WHERE " + KEY_AUFGABE_ID + " = '" + a.getId() + "';";
    }
    
    public static String GET_AUFGABE_COUNT_QUERY(){
        return "SELECT COUNT(" + KEY_AUFGABE_ID +  ")FROM " +
        TABLE_AUFGABE + ";";
    }
    
    /**
     * #########################################################################
     * Berufswahl Columns
     * #########################################################################
     */
    
    public static String INSERT_BERUFSWAHL_QUERY(Berufswahl b){
        return "INSERT INTO " + TABLE_BERUFSWAHL + " ('" +
                    KEY_BERUFSWAHL_BERUFSBESCHREIBUNG + ", " +
                    KEY_BERUFSWAHL_VORAUSSETZUNG + 
                ") values('" +
                    b.getBerufsBeschreibung() + "', '" +
                    b.getVoraussetzung() 
                + "');";
    }
    
    public static String GET_LAST_INSERTED_BERUFSWAHL_ID_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_BERUFSWAHL + ";";
    }
    
    public static String GET_BERUFSWAHL_ENTRY_QUERY(int id){
        return "SELECT * FROM " + TABLE_BERUFSWAHL + " " +
                "WHERE " + KEY_BERUFSWAHL_ID + " = '" + id + "';";
    }
    
    public static String GET_ALL_BERUFSWAHL_ENTRY_QUERY(){
        return "SELECT * FROM " + TABLE_BERUFSWAHL + ";";
    }
    
     public static String UPDATE_BERUFSWAHL_QUERY(Berufswahl b){
        return "UPDATE " + TABLE_BERUFSWAHL + " SET " +
                KEY_BERUFSWAHL_BERUFSBESCHREIBUNG + " = '" + b.getBerufsBeschreibung()+ "', " +
                KEY_BERUFSWAHL_VORAUSSETZUNG + " = '" + b.getVoraussetzung()+ "' " +
                "WHERE " + KEY_BERUFSWAHL_ID + " = '" + b.getId()+ "';";
    }
     
     public static String DELETE_BERUFSWAHL_QUERY(Berufswahl b){
         return "DELETE FROM " + TABLE_BERUFSWAHL + " WHERE " + " " +
                 "WHERE " + KEY_BERUFSWAHL_ID + " = '" + b.getId() + "';";
     }
     
     public static String GET_BERUFSWAHL_COUNT_QUERY(){
        return "SELECT COUNT(" + KEY_BERUFSWAHL_ID +  ")FROM " +
        TABLE_BERUFSWAHL + ";";
    }
   
    /**
   *############################################################################
   * Bewerber Querys
   *############################################################################
   */
    
    public static String INSERT_BEWERBER_QUERY(Bewerber b) throws ParseException{
        Date givenDate = b.getGeburtsTag();
        
        return "INSERT INTO " + TABLE_BEWERBER +
                " (" + 
                KEY_BEWERBER_PERMISSION_ID + ", " +
                KEY_BEWERBER_BERUFSWAHLID + ", " +
                KEY_BEWERBER_VORNAME + ", " +
                KEY_BEWERBER_NACHNAME + ", " +
                KEY_BEWERBER_GEBURTSTAG + ", " +
                KEY_BEWERBER_EMAIL + ", " + 
                KEY_BEWERBER_FREIGABE + ", " +
                KEY_BEWERBER_PASSWORD +
                ") VALUES('" +
                    b.getIdPermisson() + "', '" +
                    b.getIdBerufswahl() + "', '" +
                    b.getVorName() + "', '" +
                    b.getNachName() + "', '" +
                    STANDARD_DATE_FORMAT.format(givenDate) + "', '" +
                    b.geteMail() + "', '" +
                    b.getFreigabe() + "', '" +
                    b.getAssignedPassword() + 
                "');";
    }
    
    public static String GET_LAST_INSERT_BEWERBER_ID_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_BEWERBER + ";";
    }
    
    public static String GET_BEWERBER_QUERY(int id){
        return "SELECT * FROM '" + TABLE_BEWERBER + 
               "' WHERE " + KEY_BEWERBER_ID + " = '" + id + "';";
    }
    
    public static String GET_ALL_BEWERBER_QUERY(){
        return "SELECT * FROM " + TABLE_BEWERBER +";";
    }
    
    public static String UPDATE_BEWERBER_QUERY(Bewerber b){
        return "UPDATE " + TABLE_BEWERBER + " SET " +
                KEY_BEWERBER_BERUFSWAHLID + " = '" + b.getIdBerufswahl() + "', " +
                KEY_BEWERBER_PERMISSION_ID + " = '" + b.getIdPermisson() + "', " +
                KEY_BEWERBER_VORNAME + " = '" + b.getVorName() + "', " +
                KEY_BEWERBER_NACHNAME + " = '" + b.getNachName() + "', " +
                KEY_BEWERBER_GEBURTSTAG + " = '" + b.getGeburtsTag() + "', " +
                KEY_BEWERBER_EMAIL + " = '" + b.geteMail() + "', " +
                KEY_BEWERBER_FREIGABE + " = '" + b.getFreigabe() + "', " +
                KEY_BEWERBER_PASSWORD + " = '" + b.getAssignedPassword() + "' " +
                "WHERE " + KEY_BEWERBER_ID + " = '" + b.getId() +"';";
    }
    
    public static String DELETE_BEWERBER_QUERY(Bewerber b){
        return "DELETE FROM '" + TABLE_BEWERBER + "' WHERE '" + KEY_BEWERBER_ID + "' = '" + b.getId() + "';";
    }
    
    public static String AUTHENTICATE_BEWERBER(String vorName, String nachName, String password){
        return "SELECT * FROM " + TABLE_BEWERBER + " WHERE " +
                KEY_BEWERBER_VORNAME + " = '" + vorName + "' AND " +
                KEY_BEWERBER_NACHNAME + " = '" + nachName + "' AND " +
                KEY_BEWERBER_PASSWORD + " = '" + password + "';";
    }
    
    public static String GET_BEWERBER_COUNT_QUERY(){
        return "SELECT COUNT(" + KEY_BEWERBER_ID +  ")FROM " +
        TABLE_BEWERBER + ";";
    }
    
    /**
     * #########################################################################
     * Eingabe Querys
     * #########################################################################
     */
    
    public static String INSERT_EINGABE_QUERY(Eingabe e){
        return "INSERT INTO " + TABLE_EINGABE + " ('" +
                KEY_EINGABE_AUFGABE_ID + ", " +
                KEY_EINGABE_EINGABE + ") values('" +
                e.getAufgabeId() + "', '" +
                e.getText() + "');";
    }
    
    public static String GET_EINGABE_LAST_INSERTED_ID(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_EINGABE + ";";
    }
    
    public static String GET_EINGABE_ENTRY_QUERY(int id){
        return "SELECT * FROM " + TABLE_EINGABE + " " +
                "WHERE " + KEY_EINGABE_ID + " = '" + id + "';";
    }
    
    public static String GET_ALL_EINGABE_ENTRY_QUERY(){
        return "SELECT * FROM " + TABLE_EINGABE + ";";
    }
    
    public static String UPDATE_EINGABE_QUERY(Eingabe e){
        return "UPDATE " + TABLE_EINGABE + " SET " +
                KEY_EINGABE_AUFGABE_ID +  " = '" + e.getAufgabeId() + ", " +
                KEY_EINGABE_EINGABE + " = '" + e.getText() + " " +
                "WHERE " + KEY_EINGABE_ID + " = '" + e.getId() + ";";
    }
    
    public static String DELETE_EINGABE_QUERY(Eingabe e){
        return "DELETE FROM " + TABLE_EINGABE + " " +
                "WHERE " + KEY_EINGABE_ID + " = '" + e.getId() + ";";
    }
    
    public static String GET_EINGABE_COUNT_QUERY(){
        return "SELECT COUNT(" + KEY_EINGABE_ID +  ")FROM " +
        TABLE_EINGABE + ";";
    }
  
    /**
     *##########################################################################
     * Kategorie Querys
     *##########################################################################
     */
    
    public static String INSERT_KATEGORIE_QUERY(Kategorie k){
        return "INSERT INTO " + TABLE_KATEGORIE + " " +
                "(" +
                    KEY_KATEGORIE_BERUFSWAHL_ID + ", " +
                    KEY_KATEGORIE_AUFGABE_ID + ", " +
                    KEY_KATEGORIE_KATEGORIEBEZEICHNUNG + ", " +
                    KEY_KATEGORIE_VERFUEGBARE_ZEIT +
                ") values(" +
                    k.getBerufswahlID() + ", " +
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
                KEY_KATEGORIE_BERUFSWAHL_ID + " = " + k.getBerufswahlID() + ", " +
                KEY_KATEGORIE_AUFGABE_ID + " = " + k.getAufgabeID() + ", " +
                KEY_KATEGORIE_KATEGORIEBEZEICHNUNG + " = " + k.getKategorieBezeichnung() + ", " +
                KEY_KATEGORIE_VERFUEGBARE_ZEIT + " = " + k.getVerfuegbareZeit() + " " +
                "WHERE " + KEY_KATEGORIE_ID + " = " + k.getId() + ";";
    }
    
    public static String DELETE_KATEGORIE_QUERY(Kategorie k){
        return "DELETE FROM " + TABLE_KATEGORIE + " " +
                "WHERE " + KEY_KATEGORIE_ID + " = " + k.getId() + ";";
    }
    
    public static String GET_KATEGORIE_COUNT_QUERY(){
        return "SELECT COUNT(" + KEY_KATEGORIE_ID +  ")FROM " +
        TABLE_KATEGORIE + ";";
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
                    KEY_LOESUNG_LOESUNG + ", " +
                    KEY_LOESUNG_MOEGLICHE_PUNKTE +
                ") values('" +
                    l.getAufgabeId() + "', '" +
                    l.getTextLoesung() + "', '" +
                    l.getPunkte() +
                "');";
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
                KEY_LOESUNG_AUFGABE_ID + " = '" + l.getAufgabeId() + "', " +
                KEY_LOESUNG_LOESUNG + " = '" + l.getTextLoesung() + "', " +
                KEY_LOESUNG_MOEGLICHE_PUNKTE + " '" + l.getPunkte() + "' " +
                "WHERE " + KEY_LOESUNG_ID + " = " + l.getId() + ";";
    }
    
    public static String DELETE_LOESUNG_QUERY(Loesung l){
        return "DELETE FROM " + TABLE_LOESUNG + " " +
                "WHERE " + KEY_LOESUNG_ID + " = " + l.getId() + ";";
    }
    
    public static String GET_LOESUNG_COUNT_QUERY(){
        return "SELECT COUNT(" + KEY_LOESUNG_ID +  ")FROM " +
        TABLE_LOESUNG + ";";
    }
    
    /**
     * #########################################################################
     * Permissions Querys
     * #########################################################################
     */
    
    public static String INSERT_PERMISSION_QUERY(Permissions p){
        return "INSERT INTO " + TABLE_PERMISSIONS + " (" +
                KEY_PERMISSIONS_DESCRIPTION + ") values('" +
                p.getDescription() + "');";
    }
    
    public static String GET_LAST_INSERTED_PERMISSIONS_ID_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_PERMISSIONS + ";";
    }
    
    public static String GET_PERMISSIONS_ENTRY_QUERY(int id){
        return "SELECT * FROM " + TABLE_PERMISSIONS + " " +
                "WHERE " + KEY_PERMISSIONS_ID + " = '" + id + "';";
    }
    
    public static String GET_ALL_PERMISSIONS_ENTRY_QUERY(){
        return "SELECT * FROM " + TABLE_PERMISSIONS + ";";
    }
    
    public static String UPDATE_PERMISSIONS_QUERY(Permissions p){
        return "UPDATE " + TABLE_PERMISSIONS + " SET " +
                KEY_PERMISSIONS_DESCRIPTION + " = '" + p.getDescription() + "' " +
                "WHERE " + KEY_PERMISSIONS_ID + " = '" + p.getId() + "';";
    }
    
    public static String DELETE_PERMISSIONS_QUERY(Permissions p){
        return "DELETE FROM " + TABLE_PERMISSIONS + " " +
                "WHERE " + KEY_PERMISSIONS_ID + " = '" + p.getId() + "';";
    }
    
    public static String GET_PERMISSIONS_COUNT_QUERY(){
        return "SELECT COUNT(" + KEY_PERMISSIONS_ID +  ")FROM " +
        TABLE_PERMISSIONS + ";";
    }
    
    /**
     * #########################################################################
     * Schwierigkeit Query
     * #########################################################################
     */
    
    public static String INSERT_SCHWIERIGKEIT_QUERY(Schwierigkeit s){
        return "INSERT INTO " + TABLE_SCHWIERIGKEIT + " (" +
                KEY_SCHWIERIGKEIT_AUFGABE_ID + ", " +
                KEY_SCHWIERIGKEIT_ERREICHTE_PUNKTZAHL + ", " +
                KEY_SCHWIERIGKEIT_MOEGLICHE_PUNKTZAHL + ") values('" +
                s.getIdAufgabe() + "', " +
                s.getErreichtePunktzahl() + "', " +
                s.getMoeglichePunktzahl() + "');";
    }
    
    public static String GET_LAST_INSERTED_SCHWIERIGKEIT_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_SCHWIERIGKEIT + ";";
    }
    
    public static String GET_SCHWIERIGKEIT_ENTRY_QUERY(int id){
        return "SELECT * FROM " + TABLE_SCHWIERIGKEIT + " " +
                "WHERE " + KEY_SCHWIERIGKEIT_ID + " = '" + id + "';";
    }
    
    public static String GET_ALL_SCHWIERIGKEIT_ENTRY_QUERY(){
        return "SELECT * FROM " + TABLE_SCHWIERIGKEIT + ";";
    }
    
    public static String UPDATE_SCHWIERIGKEIT_QUERY(Schwierigkeit s){
        return "UPDATE " + TABLE_SCHWIERIGKEIT + " SET " +
                KEY_SCHWIERIGKEIT_AUFGABE_ID + " = '" + s.getIdAufgabe() + "', " +
                KEY_SCHWIERIGKEIT_ERREICHTE_PUNKTZAHL + " = '" + s.getErreichtePunktzahl() + "', " +
                KEY_SCHWIERIGKEIT_MOEGLICHE_PUNKTZAHL + " = '" + s.getMoeglichePunktzahl() + "' " +
                "WHERE " + KEY_SCHWIERIGKEIT_ID + " = '" + s.getId() + "';";
    }
    
    public static String DELETE_SCHWIERIGKEIT_QUERY(Schwierigkeit s){
        return "DELETE FROM " + TABLE_SCHWIERIGKEIT + " WHERE " +
                KEY_SCHWIERIGKEIT_ID + " = '" + s.getId() + "';";
    }
    
    public static String GET_SCHWIERIGKEIT_COUNT_QUERY(){
        return "SELECT COUNT(" + KEY_SCHWIERIGKEIT_ID +  ")FROM " +
        TABLE_SCHWIERIGKEIT + ";";
    }
    
    /**
     * #########################################################################
     * Ergebnis Query
     * #########################################################################
     * @param e
     * @return 
     */
    
        public static String INSERT_ERGEBNIS_QUERY(Ergebnis e){
        return "INSERT INTO " + TABLE_ERGEBNIS + " (" +
                KEY_ERGEBNIS_BEWERBER_ID + ", " +
                KEY_ERGEBNIS_DATUM + ", " +
                KEY_ERGEBNIS_PUNKTZAHL + ", " +
                KEY_ERGEBNIS_ERGEBNIS + ") values('" +
                e.getId_Bewerber() + "', '" +
                e.getPruefungsDatum() + "', '" +
                e.getPunktzahl()+ "', '" +
                e.getErgebnis()+ "');";
    }
    
    public static String GET_LAST_INSERTED_ERGEBNIS_QUERY(){
        return "SELECT LAST_INSERT_ID() FROM " + TABLE_ERGEBNIS + ";";
    }
    
    public static String GET_ERGEBNIS_ENTRY_QUERY(int id){
        return "SELECT * FROM " + TABLE_ERGEBNIS + " " +
                "WHERE " + KEY_ERGEBNIS_ID + " = '" + id + "';";
    }
    
    public static String GET_ALL_ERGEBNIS_ENTRY_QUERY(){
        return "SELECT * FROM " + TABLE_ERGEBNIS + ";";
    }
    
    public static String UPDATE_ERGEBNIS_QUERY(Ergebnis e){
        return "UPDATE " + TABLE_ERGEBNIS + " SET " +
                KEY_ERGEBNIS_BEWERBER_ID + " = '" + e.getId_Bewerber() + "', " +
                KEY_ERGEBNIS_DATUM + " = '" + e.getPruefungsDatum()+ "', " +
                KEY_ERGEBNIS_PUNKTZAHL + " = '" + e.getPunktzahl()+ "' " +
                KEY_ERGEBNIS_ERGEBNIS + " = '" + e.getErgebnis()+ "' " +
                "WHERE " + KEY_ERGEBNIS_ID + " = '" + e.getId() + "';";
    }
    
    public static String DELETE_ERGEBNIS_QUERY(Ergebnis e){
        return "DELETE FROM " + TABLE_ERGEBNIS + " WHERE " +
                KEY_ERGEBNIS_ID + " = '" + e.getId() + "';";
    }
    
    public static String GET_ERGEBNIS_COUNT_QUERY(){
        return "SELECT COUNT(" + KEY_ERGEBNIS_ID +  ")FROM " +
        TABLE_ERGEBNIS + ";";
    }
}
