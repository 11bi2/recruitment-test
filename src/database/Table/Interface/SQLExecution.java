/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table.Interface;

import java.sql.ResultSet;

/**
 *
 * @author sriga
 */
public interface SQLExecution {
    ResultSet executeQuery(String query);
    void executeUpdate(String query);
}
