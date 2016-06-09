/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mail;

import Database_Objects.Bewerber;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author sriga
 */
public class Mailer {
    private static final String HOST = "localhost";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String FROM = "admin@bewerbungstest.com";
    
    private static Properties props = System.getProperties();
    private static Session session;
    
    public static void sendMail(Bewerber b) throws MessagingException{
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        session = Session.getInstance(props, auth());
        
        
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(InternetAddress.parse(FROM)[0]);
        msg.setSubject("Your registration");
        msg.addRecipient(Message.RecipientType.TO, InternetAddress.parse(b.geteMail())[0]);
        
        msg.setText("Your username and Password:");
        Transport.send(msg);
    }
    
    private static javax.mail.Authenticator auth(){ 
       return new javax.mail.Authenticator(){
            protected PasswordAuthentication PwAuth() {
                return new PasswordAuthentication(USERNAME, PASSWORD.toCharArray());
            }        
        };
    }
}
