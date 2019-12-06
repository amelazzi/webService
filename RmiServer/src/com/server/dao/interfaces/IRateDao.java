package com.server.dao.interfaces;

import com.server.entities.impl.Rate;

import java.io.Serializable;
import java.util.List;
 
public interface IRateDao<T, Id extends Serializable> {
    public long getIdMax();
 
    public void persist(T entity);
     
    public void update(T entity);

    public Rate parseRate(String[][] data, int i);
     
    public T findOneById(Id id);
     
    public List<T> findBy(String field, Object value);
    
    public List<T> findBy(String[] fields, Object[] values);
     
    public List<T> findAll();
    
    public List<T> findAllSortedBy(String field, String order);
     
    public void delete(T entity);
    
    public void deleteAll();
     
}
