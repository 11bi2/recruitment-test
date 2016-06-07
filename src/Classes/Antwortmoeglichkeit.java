/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sriga
 */
public class Antwortmoeglichkeit {
    
    private int idAntwortMoeglichkeit;
    private int idAufgaben;
    private String antwortMoeglichkeit1;
    private String antwortMoeglichkeit2;
    private String antwortMoeglichkeit3;
    private String antwortMoeglichkeit4;
    private String antwortMoeglichkeit5;
    
    public int getIdAntwortMoeglichkeit() {
        return idAntwortMoeglichkeit;
    }

    public void setIdAntwortMoeglichkeit(int idAntwortMoeglichkeit) {
        this.idAntwortMoeglichkeit = idAntwortMoeglichkeit;
    }

    public int getIdAufgaben() {
        return idAufgaben;
    }

    public void setIdAufgaben(int idAufgaben) {
        this.idAufgaben = idAufgaben;
    }

    public String getAntwortMoeglichkeit1() {
        return antwortMoeglichkeit1;
    }

    public void setAntwortMoeglichkeit1(String antwortMoeglichkeit1) {
        this.antwortMoeglichkeit1 = antwortMoeglichkeit1;
    }

    public String getAntwortMoeglichkeit2() {
        return antwortMoeglichkeit2;
    }

    public void setAntwortMoeglichkeit2(String antwortMoeglichkeit2) {
        this.antwortMoeglichkeit2 = antwortMoeglichkeit2;
    }

    public String getAntwortMoeglichkeit3() {
        return antwortMoeglichkeit3;
    }

    public void setAntwortMoeglichkeit3(String antwortMoeglichkeit3) {
        this.antwortMoeglichkeit3 = antwortMoeglichkeit3;
    }

    public String getAntwortMoeglichkeit4() {
        return antwortMoeglichkeit4;
    }

    public void setAntwortMoeglichkeit4(String antwortMoeglichkeit4) {
        this.antwortMoeglichkeit4 = antwortMoeglichkeit4;
    }

    public String getAntwortMoeglichkeit5() {
        return antwortMoeglichkeit5;
    }

    public void setAntwortMoeglichkeit5(String antwortMoeglichkeit5) {
        this.antwortMoeglichkeit5 = antwortMoeglichkeit5;
    }

public Antwortmoeglichkeit(int idAntwortMoeglichkeit, int idAufgaben, String antwortMoeglichkeit1, String antwortMoeglichkeit2, String antwortMoeglichkeit3, String antwortMoeglichkeit4, String antwortMoeglichkeit5){
        setIdAntwortMoeglichkeit(idAntwortMoeglichkeit);
        setIdAufgaben(idAufgaben);
        setAntwortMoeglichkeit1(antwortMoeglichkeit1);
        setAntwortMoeglichkeit2(antwortMoeglichkeit2);
        setAntwortMoeglichkeit3(antwortMoeglichkeit3);
        setAntwortMoeglichkeit4(antwortMoeglichkeit4);
        setAntwortMoeglichkeit5(antwortMoeglichkeit5);
    }    


public static Antwortmoeglichkeit fromResultSet(ResultSet res){
        try {
            return new Antwortmoeglichkeit(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7));
        } catch (SQLException ex) {
            Logger.getLogger(Antwortmoeglichkeit.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}

}

