package com.server.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.INotificationDao;
import com.server.entities.impl.Notification;
import com.server.entities.impl.UserImpl;
import org.hibernate.cfg.Configuration;


public class NotificationDaoImpl implements INotificationDao<Notification, Long> {
 
    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public NotificationDaoImpl() {
    }
    
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    @SuppressWarnings("static-access")
    private static SessionFactory getSessionFactory() {
    	/*HibernateFiveUtils utils=new HibernateFiveUtils();
    	return utils.getSessionFactory();*/
        Configuration config = new Configuration();
        SessionFactory session=config.configure("hibernate.cfg.xml").buildSessionFactory();
        //session.openSession();
        return session;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
    
    @Override
    public void persist(Notification entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(Notification entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Notification findOneById(Long id) {
    	Notification produit = (Notification) getCurrentSession().get(Notification.class, id);
        return produit; 
    }
    
    @Override
    public void delete(Notification entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Notification> findAll() {
    	List<Notification> products = (List<Notification>) getCurrentSession().createQuery("from Notification").list();
        
        return products;
    }
    
    @Override
    public void deleteAll() {
        List<Notification> entityList = findAll();
        for (Notification entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<Notification> findByUser(UserImpl user) {
		// TODO Auto-generated method stub
		return null;
	}

}
