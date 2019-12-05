package com.server.dao.interfaces;

import com.server.entities.impl.Emprunt;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
import com.server.rmi.impl.UserRmi;

import java.io.Serializable;
import java.util.List;
 
public interface IEmpruntDao<T, Id extends Serializable> {

    public long getMaxId();

    public void add(T entity);
     
    public void update(T entity);

    public Emprunt parseEmprunt(String[][] data, int i);
     
    public T findOneById(Id id);
     
    public List<T> findBy(String field, String value);
    
    public List<T> findBy(String[] fields, Object[] values);
     
    public List<T> findAll();
    
    public List<T> findAllSortedBy(String field, String order);
     
    public void delete(T entity);
    
    public void deleteAll();
     
}
