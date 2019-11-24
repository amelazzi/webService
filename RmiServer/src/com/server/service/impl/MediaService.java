package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.MediaDaoImpl;
import com.server.entities.impl.Media;
import com.server.service.interfaces.IMediaService;

 
public class MediaService implements IMediaService{
 
    private static MediaDaoImpl productDao;
 
    public MediaService() {
        productDao = new MediaDaoImpl();
    }
    
    public MediaDaoImpl productDao() {
        return productDao;
    }
    
    @Override
    public Media save(Media entity) {
    	try {
    		if(entity!=null) {
    			productDao.openCurrentSessionwithTransaction();
                productDao.persist(entity);
                productDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (HibernateException e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public Media update(Media entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdMedia()!=0L) {
    				productDao.openCurrentSessionwithTransaction();
    	            productDao.update(entity);
    	            productDao.closeCurrentSessionwithTransaction();
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
				productDao.openCurrentSessionwithTransaction();
		        Media media = productDao.findOneById(id);
		        productDao.delete(media);
		        productDao.closeCurrentSessionwithTransaction();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Media findOneById(Long id) {
		try {
			if(id!=0L) {
				productDao.openCurrentSession();
		        Media product = productDao.findOneById(id);
		        productDao.closeCurrentSession();
		        return product;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Media> findAll() {
    	try {
    		productDao.openCurrentSession();
            List<Media> products = productDao.findAll();
            productDao.closeCurrentSession();
            return products;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
    		productDao.openCurrentSessionwithTransaction();
            productDao.deleteAll();
            productDao.closeCurrentSessionwithTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
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

