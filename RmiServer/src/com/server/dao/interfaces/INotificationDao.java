package com.server.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.server.entities.impl.UserImpl;
 
public interface INotificationDao<T, Id extends Serializable> {
 
	public void persist(T entity);
    
    public void update(T entity);
     
    public T findOneById(Id id);
     
    public List<T> findByUser(UserImpl user);
     
    public List<T> findAll();
     
    public void delete(T entity);
    
    public void deleteAll();
     
}
