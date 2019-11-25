package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.NotificationDaoImpl;
import com.server.entities.impl.Notification;
import com.server.entities.impl.UserImpl;
import com.server.service.interfaces.INotificationService;

 
public class NotificationService implements INotificationService{
 
    private static NotificationDaoImpl notificationDao;
 
    public NotificationService() {
        notificationDao = new NotificationDaoImpl();
    }
    
    public NotificationDaoImpl notificationDao() {
        return notificationDao;
    }
    
    @Override
    public Notification save(Notification entity) {
    	try {
    		if(entity!=null) {
    			notificationDao.openCurrentSessionwithTransaction();
                notificationDao.persist(entity);
                notificationDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (HibernateException e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public Notification update(Notification entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdNotification()!=0L) {
    				notificationDao.openCurrentSessionwithTransaction();
    	            notificationDao.update(entity);
    	            notificationDao.closeCurrentSessionwithTransaction();
    	            return entity;
    			}
    		}
    		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
	@Override
	public void delete(Long id) {
		try {
			if(id!=0L) {
				notificationDao.openCurrentSessionwithTransaction();
		        Notification notification = notificationDao.findOneById(id);
		        notificationDao.delete(notification);
		        notificationDao.closeCurrentSessionwithTransaction();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Notification findOneById(Long id) {
		try {
			if(id!=0L) {
				notificationDao.openCurrentSession();
		        Notification notification = notificationDao.findOneById(id);
		        notificationDao.closeCurrentSession();
		        return notification;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Notification> findAll() {
    	try {
    		notificationDao.openCurrentSession();
            List<Notification> notifications = notificationDao.findAll();
            notificationDao.closeCurrentSession();
            return notifications;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
    		notificationDao.openCurrentSessionwithTransaction();
            notificationDao.deleteAll();
            notificationDao.closeCurrentSessionwithTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    }

	@Override
	public List<Notification> findByUser(UserImpl user) {
		// TODO Auto-genenotificationd method stub
		return null;
	}
    
    
	
}

