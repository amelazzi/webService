package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.DemandeDaoImpl;
import com.server.entities.impl.Demande;
import com.server.service.interfaces.IDemandeService;

 
public class DemandeService implements IDemandeService{
 
    private static DemandeDaoImpl demandeDao;
 
    public DemandeService() {
        demandeDao = new DemandeDaoImpl();
    }
    
    public DemandeDaoImpl demandeDao() {
        return demandeDao;
    }
    
    @Override
    public Demande save(Demande entity) {
    	try {
    		if(entity!=null) {
    			demandeDao.openCurrentSessionwithTransaction();
                demandeDao.persist(entity);
                demandeDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (HibernateException e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public Demande update(Demande entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdDemande()!=0L) {
    				demandeDao.openCurrentSessionwithTransaction();
    	            demandeDao.update(entity);
    	            demandeDao.closeCurrentSessionwithTransaction();
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
				demandeDao.openCurrentSessionwithTransaction();
		        Demande demande = demandeDao.findOneById(id);
		        demandeDao.delete(demande);
		        demandeDao.closeCurrentSessionwithTransaction();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Demande findOneById(Long id) {
		try {
			if(id!=0L) {
				demandeDao.openCurrentSession();
		        Demande demande = demandeDao.findOneById(id);
		        demandeDao.closeCurrentSession();
		        return demande;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Demande> findAll() {
    	try {
    		demandeDao.openCurrentSession();
            List<Demande> demandes = demandeDao.findAll();
            demandeDao.closeCurrentSession();
            return demandes;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
    		demandeDao.openCurrentSessionwithTransaction();
            demandeDao.deleteAll();
            demandeDao.closeCurrentSessionwithTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
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

