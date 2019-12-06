package com.server.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.server.entities.impl.Notification;
import com.server.entities.impl.UserImpl;
 
public interface INotificationDao<T, Id extends Serializable> {
 
	public long getMaxId();

    public void add(T entity);
    
    public void update(T entity);

    public Notification parseNotif(String[][] data, int i);
     
    public T findOneById(Id id);
     
    public List<T> findBy(String field, Object value);
     
    public List<T> findAll();
     
    public void delete(T entity);
    
    public void deleteAll();
     
}
