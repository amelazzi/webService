package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Notification;
import com.server.entities.impl.UserImpl;

public interface INotificationService {

	public long getMaxId();

	public Notification add(Notification entity);
	
	public Notification update(Notification entity);
	
	public void delete(Long id);
	
	public Notification findOneById(Long id);
	
	public List<Notification> findBy(String field, Object value);
     
    public List<Notification> findAll();
	
	public void deleteAll();
	
}
