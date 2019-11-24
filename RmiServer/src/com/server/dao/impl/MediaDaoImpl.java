package com.server.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.IMediaDao;
import com.server.entities.impl.Media;
 
 
public class MediaDaoImpl implements IMediaDao<Media, Long> {
 
    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public MediaDaoImpl() {
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
    public void persist(Media entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(Media entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Media findOneById(Long id) {
    	Media produit = (Media) getCurrentSession().get(Media.class, id);
        return produit; 
    }
    
    @Override
    public void delete(Media entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Media> findAll() {
    	List<Media> products = (List<Media>) getCurrentSession().createQuery("from Media").list();
        
        return products;
    }
    
    @Override
    public void deleteAll() {
        List<Media> entityList = findAll();
        for (Media entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<Media> findBy(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Media> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Media> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
