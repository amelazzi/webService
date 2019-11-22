package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Product;
import com.server.exceptions.MyExceptions;

public interface IProductService {
	public Product save(Product entity);
	
	public Product update(Product entity);
	
	public void delete(Long id);
	
	public Product findOneById(Long id);
	
	public List<Product> findAll();
	
	public void deleteAll();
	
}
