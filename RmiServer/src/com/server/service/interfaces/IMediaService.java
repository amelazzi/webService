package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Media;

public interface IMediaService {
	public Media save(Media entity);
	
	public Media update(Media entity);
	
	public void delete(Long id);
	
	public Media findOneById(Long id);
	
	public List<Media> findBy(String field, String value);
    
    public List<Media> findBy(String[] fields, Object[] values);
     
    public List<Media> findAll();
    
    public List<Media> findAllSortedBy(String field, String order);
	
	public void deleteAll();
	
}
