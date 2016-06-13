/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//TODO: Read/Write File, get Mac 

package Security;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author sriga
 */
public class Crypt {
    
    private static BigInteger hexConv;
    private static Cipher aesCipher;
    private static SecretKeySpec keySpec;
    private static byte encryptedBytes[];
    private static MessageDigest sha256Encryption;
    
    private  static void writePasswordToFile(String password){
        File configTxt = new File("user.dir/Test/config.txt");
        List<String> lines = Arrays.asList(password);
        Path path = Paths.get(URI.create(configTxt.getAbsolutePath()));
        
        try {
            if (configTxt.exists()) {
                Files.write(path, lines, Charset.forName("UTF-8"));
            }else {
                configTxt.createNewFile();
                writePasswordToFile(password);
            }
        } catch (IOException ex) {
            //UIHook here
        }
    }
    
    private static String readPasswordFromFile(){
        File configTxt = new File("user.dir/Test/config.txt");
        Path path = Paths.get(URI.create(configTxt.getAbsolutePath()));
        
        try {
        
            if (configTxt.exists()) {
                return Files.readAllLines(path, Charset.defaultCharset()).get(1);

            }
        
        } catch (IOException ex) {
            //UIHook here
        }
        return "";
    }
    
    private static String getMac(){
        try {
            byte[] mac;
            InetAddress myIp = InetAddress.getLocalHost();
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(myIp);
            
            if (networkInterface != null) {

                mac = networkInterface.getHardwareAddress();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < mac.length; i++) {
                    builder.append(String.format("%02Xs", mac[i], (i < mac.length -1) ? ":" : ""));
                }
                return builder.toString();
            }else {
                return "5c:26:0a:03:14:e5 ";
            }
        } catch (SocketException | UnknownHostException ex) {
            Logger.getLogger(Crypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public static String encrypt(String password){

        try {
            sha256Encryption = MessageDigest.getInstance("SHA-256");
            sha256Encryption.update(getMac().getBytes());
            
            encryptedBytes = sha256Encryption.digest();
            
            keySpec = new SecretKeySpec(encryptedBytes, "AES");
            
            aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, keySpec);
            
            hexConv = new BigInteger(aesCipher.doFinal(password.getBytes()));
            
            return hexConv.toString(16);
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            //UIHook here
        }
        return "";
    };
    
    public static String decrypt(String password){
        String encryptedPassword = password;
        
        try {
            sha256Encryption = MessageDigest.getInstance("SHA-256");
            sha256Encryption.update(getMac().getBytes());
            
            encryptedBytes = sha256Encryption.digest();
            
            keySpec = new SecretKeySpec(encryptedBytes, "AES");
            
            aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.DECRYPT_MODE, keySpec);
            
            hexConv = new BigInteger(encryptedPassword, 16);
            
            return new String(aesCipher.doFinal(hexConv.toByteArray()));
        
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
            //UIHook here
        }
        return "";
    }
    
}
