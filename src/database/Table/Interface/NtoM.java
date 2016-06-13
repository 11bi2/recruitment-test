/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * #############################################################################
 * Deprecheated
 * #############################################################################
 */

package database.Table.Interface;

import java.util.ArrayList;

/**
 *
 * @author sriga
 */
public interface NtoM<T, E> {
    
    public abstract NtoM getInstance();
    public abstract void create(T args1, E args2);
    public abstract ArrayList<T> getEntrysN(E args);
    public abstract ArrayList<E> getEntrysM(T args);
    public abstract void deleteN(T args);
    public abstract void deleteM(E args);
}
