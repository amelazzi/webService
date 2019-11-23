package com.server.dao.interfaces;

import java.util.List;

public interface IGenericDao<E> {
	
	public E save(E entity);
	
	public E update(E entity);
	
	public void remove(Long id);
	
	public E findOneById(Long id);
	
	public E findOneBy(String field, Object value); 
	
	public E findOneBy(String[] fields, Object[] values);
	
	public List<E> findAll();
	
	public List<E> findAllSortedBy(String field, String order);
	
	public int countBy(String field, String value);
}
