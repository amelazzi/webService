package com.server.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.IRateDao;
import com.server.entities.impl.Rate;
 
 
public class RateDaoImpl implements IRateDao<Rate, Long> {
 
    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public RateDaoImpl() {
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
    public void persist(Rate entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(Rate entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Rate findOneById(Long id) {
    	Rate produit = (Rate) getCurrentSession().get(Rate.class, id);
        return produit; 
    }
    
    @Override
    public void delete(Rate entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Rate> findAll() {
    	List<Rate> products = (List<Rate>) getCurrentSession().createQuery("from Rate").list();
        
        return products;
    }
    
    @Override
    public void deleteAll() {
        List<Rate> entityList = findAll();
        for (Rate entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<Rate> findBy(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rate> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rate> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
