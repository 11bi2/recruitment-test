/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Table;

import java.util.ArrayList;

/**
 *
 * @author sriga
 * @param <T>
 */
public abstract class Table<T> {
    
    public abstract void create(T args);
    public abstract Integer getLastInsertedId();
    public abstract T getEntry(int id);
    public abstract ArrayList<T> getAllEntrys();
    public abstract void update(T args);
    public abstract void delete(T args);
    public abstract int getCount();
    
}
