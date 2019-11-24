package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.EmpruntDaoImpl;
import com.server.entities.impl.Emprunt;
import com.server.service.interfaces.IEmpruntService;

 
public class EmpruntService implements IEmpruntService{
 
    private static EmpruntDaoImpl empruntDao;
 
    public EmpruntService() {
        empruntDao = new EmpruntDaoImpl();
    }
    
    public EmpruntDaoImpl empruntDao() {
        return empruntDao;
    }
    
    @Override
    public Emprunt save(Emprunt entity) {
    	try {
    		if(entity!=null) {
    			empruntDao.openCurrentSessionwithTransaction();
                empruntDao.persist(entity);
                empruntDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (HibernateException e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public Emprunt update(Emprunt entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdEmprunt()!=0L) {
    				empruntDao.openCurrentSessionwithTransaction();
    	            empruntDao.update(entity);
    	            empruntDao.closeCurrentSessionwithTransaction();
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
				empruntDao.openCurrentSessionwithTransaction();
		        Emprunt emprunt = empruntDao.findOneById(id);
		        empruntDao.delete(emprunt);
		        empruntDao.closeCurrentSessionwithTransaction();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Emprunt findOneById(Long id) {
		try {
			if(id!=0L) {
				empruntDao.openCurrentSession();
		        Emprunt emprunt = empruntDao.findOneById(id);
		        empruntDao.closeCurrentSession();
		        return emprunt;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Emprunt> findAll() {
    	try {
    		empruntDao.openCurrentSession();
            List<Emprunt> emprunts = empruntDao.findAll();
            empruntDao.closeCurrentSession();
            return emprunts;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
    		empruntDao.openCurrentSessionwithTransaction();
            empruntDao.deleteAll();
            empruntDao.closeCurrentSessionwithTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
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

