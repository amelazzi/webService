package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Product;


public interface IProduitService {
	public Product save(Product entity);
	
	public Product update(Product entity);
	
	public void remove(Long id);
	
	public Product findOneById(Long id);
	
	public Product findOneBy(String field, Object value); 
	
	public Product findOneBy(String[] fields, Object[] values);
	
	public List<Product> findAll();
	
	public List<Product> findAllSortedBy(String field, String order);
	
	public int countBy(String field, String value);
}
