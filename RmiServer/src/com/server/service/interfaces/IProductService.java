package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Product;

public interface IProductService {
	public Product save(Product entity);
	
	public Product update(Product entity);
	
	public void delete(Long id);
	
	public Product findOneById(Long id);
	
	public List<Product> findBy(String field, String value);
    
    public List<Product> findBy(String[] fields, Object[] values);
     
    public List<Product> findAll();
    
    public List<Product> findAllSortedBy(String field, String order);
	
	public void deleteAll();
	
}
