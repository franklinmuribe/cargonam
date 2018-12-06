/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.cargonam.service.persistence;

import com.java.cargonam.util.AlmacenPropiedades;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;


/**
 *
 * @author furibe
 */
public abstract class JpaDao<K, E> implements Dao<K, E> {
    
    protected Class<E> entityClass;
    protected Properties prop;
//    @PersistenceContext(unitName = "CadiviPersistenceUnit")
    protected EntityManagerFactory factory;
    protected EntityManager em;
    protected String className;
//  < private String USER;

    public JpaDao() {
        System.out.println("En el contructor de JpaDao......");
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
        this.className = this.entityClass.getSimpleName();
        this.getentityManager();
        
    }
    
    @Override
    public void persist(E entity) {
        this.beginTransaction();
        em.persist(entity);
        this.commitTransaction();
    }
    
    @Override
    public E merge(E entity) {
        this.beginTransaction();
        entity = this.em.merge(entity);
        this.commitTransaction();
        return entity;
    }
    
    @Override
    public void remove(E entity) {
        em.remove(entity);
    }
    
    @Override
    public E findById(K id) {
        return em.find(entityClass, id);
    }
    
    @Override
    public void beginTransaction() {
        System.out.println("this.em = " + this.em);
        em.getTransaction().begin();
    }
    
    @Override
    public void commitTransaction() {
        em.getTransaction().commit();
    }
    
    @Override
    public void close() {
        em.close();
    }
    
    @Override
    public List<E> findAll() {
        System.out.println("em = " + em);
        Query query = em.createNamedQuery(className + ".findAll").setHint("eclipselink.refresh", "true");
        return (List<E>) query.getResultList();
        
    }
    
 


    protected EntityManager getentityManager() {
        try {

            String PERSISTENCE_UNIT_NAME = AlmacenPropiedades.getPropiedad("PERSISTENCE_UNIT_NAME");


            System.out.println("PERSISTENCE_UNIT_NAME = " + PERSISTENCE_UNIT_NAME);
            //EntityManagerFactory emf = Persistence.createEntityManagerFactory("Convenio36OCTDPU");
            
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
           
            System.out.println("em = " + em);
            System.out.println("factory = " + factory);
            em = factory.createEntityManager();
            
            System.out.println("em = " + em);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return em;
        
    }
}
