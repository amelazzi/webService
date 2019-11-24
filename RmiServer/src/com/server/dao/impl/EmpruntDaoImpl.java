package com.server.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.IEmpruntDao;
import com.server.entities.impl.Emprunt;
 
 
public class EmpruntDaoImpl implements IEmpruntDao<Emprunt, Long> {
 
    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public EmpruntDaoImpl() {
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
    public void persist(Emprunt entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(Emprunt entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Emprunt findOneById(Long id) {
    	Emprunt produit = (Emprunt) getCurrentSession().get(Emprunt.class, id);
        return produit; 
    }
    
    @Override
    public void delete(Emprunt entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Emprunt> findAll() {
    	List<Emprunt> products = (List<Emprunt>) getCurrentSession().createQuery("from Emprunt").list();
        
        return products;
    }
    
    @Override
    public void deleteAll() {
        List<Emprunt> entityList = findAll();
        for (Emprunt entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<Emprunt> findBy(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emprunt> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emprunt> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
