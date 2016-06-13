/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table.Helper;

import java.io.IOException;
import java.net.Socket;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sriga
 */
public class Helper {
    
    public static final int maxAufgaben = 3;
    public static final int moeglichePunkte = 25;
    
    private static Random rng = new Random();
    
    public static int getRandom(int limit){
        return rng.nextInt(limit);
    }
    
    public static String decodeString(String input){
        input = input.replaceAll("Ã¼", "ü");
        input = input.replaceAll("Ã¤", "ä");
        input = input.replaceAll("Ã¶", "ö");
        input = input.replaceAll("ÃŸ", "ß");
        return input;
    }
    
    public static boolean checkInet(){
        try{
            Socket socket = new Socket("www.google.com", 80);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
}
