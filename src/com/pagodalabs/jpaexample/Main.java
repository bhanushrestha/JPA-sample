/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.jpaexample;

import com.pagodalabs.jpaexample.dao.ContactsDAO;
import com.pagodalabs.jpaexample.dao.impl.ContactsDAOImpl;
import com.pagodalabs.jpaexample.entities.Contacts;

/**
 *
 * @author Bhanu
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ContactsDAO cDAO = new ContactsDAOImpl("JPAExamplePU");
        
        //cDAO.insert(new Contacts(0,"Bhanu","Shrestha","bhanu@live.com","9841990900"));
        //System.out.println("Record Inserted");
        
        //cDAO.delete(101);
        //System.out.println("Record Deleted");
        
       //cDAO.update(new Contacts(10,"Go","Bye","goback@mail.com","9812312312"));
       //System.out.println("Record Updated");
        
        for(Contacts c: cDAO.getAll()){
            System.out.println(c.toString());
        }
               
    }
    
}
