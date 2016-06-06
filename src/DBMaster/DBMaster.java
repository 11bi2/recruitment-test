/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBMaster;

import Classes.SessionManager;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author sriga
 */
public class DBMaster extends Observable {

    private static DBMaster myDatabase = null;
    private Connection session = null;
    private String url = null;

    private DBMaster(){}

    public static DBMaster getDatabase(){
        if (myDatabase == null) {
            myDatabase = new DBMaster();
        }
        return myDatabase;
    }
    
    public Connection getSession(){
        return this.session;
    }
    
    public void terminateSession(){
        if (myDatabase != null) {
            try {
                this.session.close();
                this.setChanged();
                this.notifyObservers();
            } catch (SQLException ex) {
                Logger.getLogger(DBMaster.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public boolean checkSession(){
        try {
            return session.isClosed();
        } catch (SQLException ex) {
            Logger.getLogger(DBMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public void startSession(String host, int port, String user, String password){
        try {
            this.url = "jdbc:mysql://" + host + ":" + port + "/cobra" ;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            session = DriverManager.getConnection(url, user, password);
            this.setChanged();
            this.notifyObservers();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(DBMaster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static BufferedImage getBlobFromDatabase(Blob b){
        try {
            byte[] blobBytes;
            BufferedImage blobImage;
            ByteArrayInputStream reader;
            
            blobBytes = b.getBytes(1, (int) b.length());
            b.free();
            
            reader = new ByteArrayInputStream(blobBytes);
            
            blobImage = ImageIO.read(reader);
            reader.close();
            
            return blobImage;            
        } catch (SQLException | IOException ey) {
            //UIHook here
        }
        return null;
    }
    
    public void initSession(){
        
    }
    
}
