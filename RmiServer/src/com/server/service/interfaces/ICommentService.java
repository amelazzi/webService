package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.Comment;

public interface ICommentService {
	public Comment add(Comment entity);
	
	public Comment update(Comment entity);
	
	public void delete(Long id);
	
	public Comment findOneById(Long id);
	
	public List<Comment> findBy(String field, Object value);
    
    public List<Comment> findBy(String[] fields, Object[] values);
     
    public List<Comment> findAll();
    
    public List<Comment> findAllSortedBy(String field, String order);
	
	public void deleteAll();
	
}
