/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fafic.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luanl
 */
public class JpaPersistence {

    public final EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.fafic_ProjetoFinalSD_war_1.0-SNAPSHOTPU");
    public final EntityManager em;

    public JpaPersistence() {
        em = emf.createEntityManager();

    }

    public EntityManager getEm() {
        return em;
       
    }

    public void save(Object o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
        em.close();
        
    }
    
    public void del(Object o) {
        em.getTransaction().begin();
        em.remove(o);
        em.getTransaction().commit();
        em.close();
        
    }
}
