package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.ProductDaoImpl;
import com.server.entities.impl.Product;
import com.server.service.interfaces.IProductService;

 
public class ProductService implements IProductService{
 
    private static ProductDaoImpl productDao;
 
    public ProductService() {
        productDao = new ProductDaoImpl();
    }
    
    public ProductDaoImpl productDao() {
        return productDao;
    }
    
    @Override
    public Product add(Product entity) {
    	try {
    		if(entity!=null) {
    			//productDao.openCurrentSessionwithTransaction();
                productDao.add(entity);
                //productDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (HibernateException e) {
			e.printStackTrace();	
		}
    	return null;
    }

	@Override
	public long getMaxId() {
		return productDao.getMaxId();
	}

	@Override
    public Product update(Product entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdProduct()!=0L) {
    				//productDao.openCurrentSessionwithTransaction();
    	            productDao.update(entity);
    	            //productDao.closeCurrentSessionwithTransaction();
    	            return entity;
    			}
    		}
    		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
	@Override
	public void delete(Product product) {
		try {
			//if(product.getIdProduct()!=0L) {
				//productDao.openCurrentSessionwithTransaction();
		        //Product product = productDao.findOneById(id);
		        productDao.delete(product);
		        //productDao.closeCurrentSessionwithTransaction();
			//}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product findOneById(Long id) {
		try {
			if(id!=0L) {
				//productDao.openCurrentSession();
		        Product product = productDao.findOneById(id);
		        //productDao.closeCurrentSession();
		        return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Product> findAll() {
    	try {
    		//productDao.openCurrentSession();
            List<Product> products = productDao.findAll();
            //productDao.closeCurrentSession();
            return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
    		//productDao.openCurrentSessionwithTransaction();
            productDao.deleteAll();
            //productDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Override
	public List<Product> findBy(String field, Object value) {
		// TODO Auto-generated method stub
		List<Product> products = productDao.findBy(field, value);
		return products;
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

