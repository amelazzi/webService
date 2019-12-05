package com.server.service.interfaces;

import java.util.List;

import com.server.entities.impl.UserImpl;

public interface IUserService {
	public UserImpl add(UserImpl entity);
	
	public UserImpl update(UserImpl entity);
	
	public void delete(UserImpl user);
	
	public UserImpl findOneById(Long id);
	
	public List<UserImpl> findBy(String field, Object value);
    
    public List<UserImpl> findBy(String[] fields, Object[] values);
     
    public List<UserImpl> findAll();
    
    public List<UserImpl> findAllSortedBy(String field, String order);
    
    public Boolean checkLogin(String email, String password);
	
	public void deleteAll();
	
}
