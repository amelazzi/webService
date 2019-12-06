package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Emprunt;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;

public interface IEmpruntService {
	public Emprunt add(Emprunt entity);
	
	public Emprunt update(Emprunt entity);

	public void delete(Emprunt emprunt);
	
	public Emprunt findOneById(Long id);
	
	public List<Emprunt> findBy(String field, String value);
    
    public List<Emprunt> findBy(String[] fields, Object[] values);
     
    public List<Emprunt> findAll();
    
    public List<Emprunt> findAllSortedBy(String field, String order);
	
	public void deleteAll();

	public boolean checkEmprunt(Product product, UserImpl user);
	
	public int emprunter(Product product, UserImpl user);
	
	public boolean restituer(Emprunt emprunt);
	
}
