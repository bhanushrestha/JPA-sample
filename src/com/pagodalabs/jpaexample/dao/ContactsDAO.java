/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pagodalabs.jpaexample.dao;

import com.pagodalabs.jpaexample.entities.Contacts;
import java.util.List;

/**
 *
 * @author Bhanu
 */
public interface ContactsDAO {

   public int insert(Contacts contacts);
   public int delete(Integer id);
   public int update(Contacts contacts);
   public Contacts searchById(int id);
   public List<Contacts> getAll();
}
