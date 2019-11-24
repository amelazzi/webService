package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Demande;

public interface IDemandeService {
	public Demande save(Demande entity);
	
	public Demande update(Demande entity);
	
	public void delete(Long id);
	
	public Demande findOneById(Long id);
	
	public List<Demande> findBy(String field, String value);
    
    public List<Demande> findBy(String[] fields, Object[] values);
     
    public List<Demande> findAll();
    
    public List<Demande> findAllSortedBy(String field, String order);
	
	public void deleteAll();
	
}
