package com.server.dao.interfaces;

import com.server.entities.impl.Product;

import java.io.Serializable;
import java.util.List;
 
public interface IProductDao<T, Id extends Serializable> {
 
    public void add(T entity);
     
    public void update(T entity);

    public long getMaxId();
     
    public T findOneById(Id id);
    
    public List<T> findBy(String field, Object value);
    
    public List<T> findBy(String[] fields, Object[] values);
     
    public List<T> findAll();
    
    public List<T> findAllSortedBy(String field, String order);
     
    public void delete(T entity);
    
    public void deleteAll();

    public Product parseProduct(String[][] data, int i);
     
}
