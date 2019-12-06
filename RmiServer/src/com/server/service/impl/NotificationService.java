package com.server.service.impl;
import java.util.List;

import com.server.entities.impl.Demande;
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
	public long getMaxId() {
		return notificationDao.getMaxId();
	}

	@Override
    public Notification add(Notification entity) {
    	try {
    		if(entity!=null) {
    			//notificationDao.openCurrentSessionwithTransaction();
                notificationDao.add(entity);
                //notificationDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (Exception e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public Notification update(Notification entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdNotification()!=0L) {
    				//notificationDao.openCurrentSessionwithTransaction();
    	            notificationDao.update(entity);
    	            //notificationDao.closeCurrentSessionwithTransaction();
    	            return entity;
    			}
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
	@Override
	public void delete(Notification notification) {
		try {
			//if(id!=0L) {
				//notificationDao.openCurrentSessionwithTransaction();
		        //Notification notification = notificationDao.findOneById(id);
		        notificationDao.delete(notification);
		        //notificationDao.closeCurrentSessionwithTransaction();
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Notification findOneById(Long id) {
		try {
			if(id!=0L) {
				//notificationDao.openCurrentSession();
		        Notification notification = notificationDao.findOneById(id);
		        //notificationDao.closeCurrentSession();
		        return notification;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Notification> findBy(String field, Object value) {
		List<Notification> notifs = notificationDao.findBy(field, value);
		return notifs;
	}

	@Override
    public List<Notification> findAll() {
    	try {
    		//notificationDao.openCurrentSession();
            List<Notification> notifications = notificationDao.findAll();
            //notificationDao.closeCurrentSession();
            return notifications;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
    		//notificationDao.openCurrentSessionwithTransaction();
            notificationDao.deleteAll();
            //notificationDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	
}

