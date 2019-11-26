package com.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.server.dao.interfaces.IDemandeDao;
import com.server.entities.impl.Demande;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
 
 
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
    public void persist(Demande entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(Demande entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Demande findOneById(Long id) {
    	Demande demande = (Demande) getCurrentSession().get(Demande.class, id);
        return demande; 
    }
    
    @Override
    public void delete(Demande entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Demande> findAll() {
    	List<Demande> demandes = getCurrentSession().createQuery("select d from Demande d").list();
        
        return demandes;
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
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> findByProduct(Product product) {
		openCurrentSession();
		List<Demande> demandes = null;
		
		try {
			@SuppressWarnings("deprecation")
			Criteria criteria = getCurrentSession().createCriteria(Demande.class);
			criteria.add(Restrictions.eq("product", product));
			criteria.add(Restrictions.eq("isDone", false));
			demandes = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCurrentSession();
		return demandes;
	}
	
	@Override
	public List<UserImpl> findWaitingUserByProduct(Product product){
		List<Demande> demandes = this.findByProduct(product);
		List<UserImpl> users = new ArrayList<UserImpl>();
		if(demandes!=null) {
			for(Demande d:demandes) {
				users.add(d.getUser());
			}
		}
		
		return users;
	}
}
