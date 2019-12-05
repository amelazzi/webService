package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.UserDaoImpl;
import com.server.entities.impl.UserImpl;
import com.server.service.interfaces.IUserService;
import com.server.utils.EncodeSha;

 
public class UserService implements IUserService{
 
    private static UserDaoImpl userDao;
    EncodeSha hash = new EncodeSha(); 
    public UserService() {
        userDao = new UserDaoImpl();
    }
    
    public UserDaoImpl userDao() {
        return userDao;
    }
    
    @Override
    public UserImpl add(UserImpl entity) {
    	try {
    		if(entity!=null) {
    			entity.setPassword(EncodeSha.getHash(entity.getPassword()));
    			//userDao.openCurrentSessionwithTransaction();
                userDao.add(entity);
                //userDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (HibernateException e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public UserImpl update(UserImpl entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdUser()!=0L) {
    				userDao.openCurrentSessionwithTransaction();
    	            userDao.update(entity);
    	            userDao.closeCurrentSessionwithTransaction();
    	            return entity;
    			}
    		}
    		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
	@Override
	public void delete(Long id) {
		try {
			if(id!=0L) {
				userDao.openCurrentSessionwithTransaction();
		        UserImpl user = userDao.findOneById(id);
		        userDao.delete(user);
		        userDao.closeCurrentSessionwithTransaction();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserImpl findOneById(Long id) {
		try {
			if(id!=0L) {
				userDao.openCurrentSession();
		        UserImpl user = userDao.findOneById(id);
		        userDao.closeCurrentSession();
		        return user;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<UserImpl> findAll() {
    	try {
    		//userDao.openCurrentSession();
            List<UserImpl> users = userDao.findAll();
            //userDao.closeCurrentSession();
            return users;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
    		userDao.openCurrentSessionwithTransaction();
            userDao.deleteAll();
            userDao.closeCurrentSessionwithTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    }
    
    @Override
    public Boolean checkLogin(String email, String password) {
    	return userDao.checkLogin(email, password);
    }

	@Override
	public List<UserImpl> findBy(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserImpl> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserImpl> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int totalEmprunt(List<UserImpl> listUser) {
		/*
		 SELECT count(*)
		 FROM `user` u, emprunt e 
		 WHERE u.iduser = e.idemprunt
		 		and e.isdone=false;
		 */
		
		
		return 0;
	}
}

