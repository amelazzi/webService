package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Demande;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;

public interface IDemandeService {
	public Demande add(Demande entity);
	
	public Demande update(Demande entity);
	
	public void delete(Long id);
	
	public Demande findOneById(Long id);
	
	public List<Demande> findBy(String field, Object value);
    
    public List<Demande> findBy(String[] fields, Object[] values);
     
    public List<Demande> findAll();
    
    public List<Demande> findAllSortedBy(String field, String order);
    
    public List<Demande> findByProduct(Product product);
    
    public List<UserImpl> findWaitingUserByProduct(Product product);
	
	public void deleteAll();
	
}
