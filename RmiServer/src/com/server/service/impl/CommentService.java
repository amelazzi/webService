package com.server.service.impl;
import java.util.List;

import org.hibernate.HibernateException;

import com.server.dao.impl.CommentDaoImpl;
import com.server.entities.impl.Comment;
import com.server.service.interfaces.ICommentService;

 
public class CommentService implements ICommentService{
 
    private static CommentDaoImpl commentDao;
 
    public CommentService() {
        commentDao = new CommentDaoImpl();
    }
    
    public CommentDaoImpl productDao() {
        return commentDao;
    }
    
    @Override
    public Comment add(Comment entity) {
    	try {
    		if(entity!=null) {
    			//commentDao.openCurrentSessionwithTransaction();
                commentDao.add(entity);
                //commentDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (Exception e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public Comment update(Comment entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdComment()!=0L) {
    				//commentDao.openCurrentSessionwithTransaction();
    	            commentDao.update(entity);
    	            //commentDao.closeCurrentSessionwithTransaction();
    	            return entity;
    			}
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }
    
	@Override
	public void delete(Long id) {
		try {
			if(id!=0L) {
				commentDao.openCurrentSessionwithTransaction();
		        Comment comment = commentDao.findOneById(id);
		        commentDao.delete(comment);
		        commentDao.closeCurrentSessionwithTransaction();
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Comment findOneById(Long id) {
		try {
			if(id!=0L) {
				//commentDao.openCurrentSession();
		        Comment comment = commentDao.findOneById(id);
		        //commentDao.closeCurrentSession();
		        return comment;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Comment> findAll() {
    	try {
    		//commentDao.openCurrentSession();
            List<Comment> comment = commentDao.findAll();
            //commentDao.closeCurrentSession();
            return comment;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
    		commentDao.openCurrentSessionwithTransaction();
            commentDao.deleteAll();
            commentDao.closeCurrentSessionwithTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    }

	@Override
	public List<Comment> findBy(String field, Object value) {
		// TODO Auto-generated method stub
		List<Comment> comments = commentDao.findBy(field, value);
		return comments;
	}

	@Override
	public List<Comment> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comment> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}

