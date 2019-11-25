package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Notification;
import com.server.entities.impl.UserImpl;

public interface INotificationService {
	public Notification save(Notification entity);
	
	public Notification update(Notification entity);
	
	public void delete(Long id);
	
	public Notification findOneById(Long id);
	
	public List<Notification> findByUser(UserImpl user);
     
    public List<Notification> findAll();
	
	public void deleteAll();
	
}
