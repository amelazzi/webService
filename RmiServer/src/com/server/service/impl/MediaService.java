package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.ProductDaoImpl;
import com.server.entities.impl.Product;
import com.server.service.interfaces.IProductService;

 
public class MediaService implements IProductService{
 
    private static ProductDaoImpl productDao;
 
    public MediaService() {
        productDao = new ProductDaoImpl();
    }
    
    public ProductDaoImpl productDao() {
        return productDao;
    }
    
    @Override
    public Product save(Product entity) {
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
    public Product update(Product entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdProduct()!=0L) {
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
		        Product book = productDao.findOneById(id);
		        productDao.delete(book);
		        productDao.closeCurrentSessionwithTransaction();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product findOneById(Long id) {
		try {
			if(id!=0L) {
				productDao.openCurrentSession();
		        Product product = productDao.findOneById(id);
		        productDao.closeCurrentSession();
		        return product;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Product> findAll() {
    	try {
    		productDao.openCurrentSession();
            List<Product> products = productDao.findAll();
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
	public List<Product> findBy(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}

