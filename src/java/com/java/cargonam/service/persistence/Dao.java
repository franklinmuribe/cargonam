    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.service.persistence;

import java.util.List;

/**
 *
 * @author furibe
 */
public interface Dao<K, E> {

    void persist(E entity);

    void remove(E entity);
    
    public E merge(E entity);

    E findById(K id);

    List<E> findAll();

    public void beginTransaction();

    public void commitTransaction();

    public void close();
    

    
 
}
