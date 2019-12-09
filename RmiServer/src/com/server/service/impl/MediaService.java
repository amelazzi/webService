package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.MediaDaoImpl;
import com.server.entities.impl.Media;
import com.server.service.interfaces.IMediaService;

 
public class MediaService implements IMediaService{
 
    private static MediaDaoImpl mediaDao;
 
    public MediaService() {
		mediaDao = new MediaDaoImpl();
    }
    
    public MediaDaoImpl productDao() {
        return mediaDao;
    }
    
    @Override
    public Media add(Media entity) {
    	try {
    		if(entity!=null) {
    			//productDao.openCurrentSessionwithTransaction();
				mediaDao.add(entity);
                //productDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (Exception e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public Media update(Media entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdMedia()!=0L) {
					//mediaDao.openCurrentSessionwithTransaction();
					mediaDao.update(entity);
					//mediaDao.closeCurrentSessionwithTransaction();
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
				mediaDao.openCurrentSessionwithTransaction();
		        Media media = mediaDao.findOneById(id);
				mediaDao.delete(media);
				mediaDao.closeCurrentSessionwithTransaction();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Media findOneById(Long id) {
		try {
			if(id!=0L) {
				mediaDao.openCurrentSession();
		        Media product = mediaDao.findOneById(id);
				mediaDao.closeCurrentSession();
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
			mediaDao.openCurrentSession();
            List<Media> products = mediaDao.findAll();
			mediaDao.closeCurrentSession();
            return products;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
			mediaDao.openCurrentSessionwithTransaction();
			mediaDao.deleteAll();
			mediaDao.closeCurrentSessionwithTransaction();
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

