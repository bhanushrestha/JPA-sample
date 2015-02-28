/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.jpaexample.dao.impl;

import com.pagodalabs.jpaexample.dao.ContactsDAO;
import com.pagodalabs.jpaexample.entities.Contacts;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Bhanu
 */
public class ContactsDAOImpl implements ContactsDAO{
    
    private EntityManager manager;
    private EntityManagerFactory factory;
    
    public ContactsDAOImpl(String pUnit){
        factory = Persistence.createEntityManagerFactory(pUnit);
        manager = factory.createEntityManager();
    }

    @Override
    public int insert(Contacts contacts) {
        int id = 0;
        manager.getTransaction().begin();
        manager.persist(contacts);
        manager.flush();
        
        id = contacts.getId();
        manager.getTransaction().commit();
        return id;
    }

    @Override
    public int delete(Integer id) {
        Contacts c = searchById(id);
        if (c != null) {
            manager.getTransaction().begin();
            manager.remove(c);
            manager.getTransaction().commit();
            manager.close();
        }
        return 1;    
    }

    @Override
    public int update(Contacts contacts) {
       manager.getTransaction().begin();
       manager.merge(contacts);
       manager.getTransaction().commit();
       return 1;
    }

    @Override
    public List<Contacts> getAll() {
     return (List<Contacts>) manager.createQuery("SELECT c FROM Contacts c").getResultList();
    }

    @Override
    public Contacts searchById(int id) {
      return (Contacts)manager.find(Contacts.class, id);
    }
    
}
