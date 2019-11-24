package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Emprunt;

public interface IEmpruntService {
	public Emprunt save(Emprunt entity);
	
	public Emprunt update(Emprunt entity);
	
	public void delete(Long id);
	
	public Emprunt findOneById(Long id);
	
	public List<Emprunt> findBy(String field, String value);
    
    public List<Emprunt> findBy(String[] fields, Object[] values);
     
    public List<Emprunt> findAll();
    
    public List<Emprunt> findAllSortedBy(String field, String order);
	
	public void deleteAll();
	
}
