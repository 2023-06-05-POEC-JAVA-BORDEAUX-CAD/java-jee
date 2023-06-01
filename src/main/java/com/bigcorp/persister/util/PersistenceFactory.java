package com.bigcorp.persister.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceFactory {

    /**
     *
     */
    private static final String PERSISTENCE_UNIT_NAME = "PersisterPU";
    public static PersistenceFactory INSTANCE = new PersistenceFactory();
    private boolean init;
    private EntityManagerFactory emf;

    private PersistenceFactory(){}

    public EntityManager gEntityManager(){
        if(this.init){
            this.emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            this.init = true;
        }
        return this.emf.createEntityManager();

    } 
    
}
