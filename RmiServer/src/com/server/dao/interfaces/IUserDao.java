package com.server.dao.interfaces;

import java.io.Serializable;
import java.util.List;
 
public interface IUserDao<T, Id extends Serializable> {
 
    public void persist(T entity);
     
    public void update(T entity);
     
    public T findOneById(Id id);
    
    public Boolean checkLogin(String email, String password);
     
    public List<T> findBy(String field, String value);
    
    public List<T> findBy(String[] fields, Object[] values);
     
    public List<T> findAll();
    
    public List<T> findAllSortedBy(String field, String order);
     
    public void delete(T entity);
    
    public void deleteAll();
     
}
