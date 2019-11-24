package com.server.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.IDemandeDao;
import com.server.entities.impl.Demande;
 
 
public class DemandeDaoImpl implements IDemandeDao<Demande, Long> {
 
    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public DemandeDaoImpl() {
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
    public void persist(Demande entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(Demande entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Demande findOneById(Long id) {
    	Demande produit = (Demande) getCurrentSession().get(Demande.class, id);
        return produit; 
    }
    
    @Override
    public void delete(Demande entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Demande> findAll() {
    	List<Demande> products = (List<Demande>) getCurrentSession().createQuery("from demande").list();
        
        return products;
    }
    
    @Override
    public void deleteAll() {
        List<Demande> entityList = findAll();
        for (Demande entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<Demande> findBy(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Demande> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Demande> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
