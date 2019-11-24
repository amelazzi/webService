package com.server.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.IUserDao;
import com.server.entities.impl.UserImpl;
 
 
public class UserDaoImpl implements IUserDao<UserImpl, Long> {
 
    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public UserDaoImpl() {
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
    	HibernateFiveUtils utils=new HibernateFiveUtils();
    	return utils.getSessionFactory();
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
    public void persist(UserImpl entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(UserImpl entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public UserImpl findOneById(Long id) {
    	UserImpl produit = (UserImpl) getCurrentSession().get(UserImpl.class, id);
        return produit; 
    }
    
    @Override
    public void delete(UserImpl entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<UserImpl> findAll() {
    	List<UserImpl> products = (List<UserImpl>) getCurrentSession().createQuery("from UserImpl").list();
        
        return products;
    }
    
    @Override
    public void deleteAll() {
        List<UserImpl> entityList = findAll();
        for (UserImpl entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<UserImpl> findBy(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserImpl> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserImpl> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
