package com.server.dao.impl;

import java.util.List;

import com.server.utils.Database;
import com.server.utils.PostgresDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.ICommentDao;
import com.server.entities.impl.Comment;
import org.hibernate.cfg.Configuration;


public class CommentDaoImpl implements ICommentDao<Comment, Long> {
 
    private Session currentSession;
    private Transaction currentTransaction;

    private Database database;
 
    public CommentDaoImpl() {
        PostgresDataSource postgresDataSource = new PostgresDataSource();

        database = new Database(postgresDataSource);
    }
    
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
    
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    @SuppressWarnings("static-access")
    private static SessionFactory getSessionFactory() {
    	/*HibernateFiveUtils utils=new HibernateFiveUtils();
    	return utils.getSessionFactory();*/
        Configuration config = new Configuration();
        SessionFactory session=config.configure("hibernate.cfg.xml").buildSessionFactory();
        //session.openSession();
        return session;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public long getMaxId() {
        long id;
        String[][] data = database.executeQuery("select max(idcomment) as max from comment");
        if(data[1][0]!=null)
            id = Long.parseLong(data[1][0]);
        else
            id = 0L;
        return id;
    }

    @Override
    public void add(Comment entity) {
        entity.setIdComment(this.getMaxId()+1);
        database.insert("comment", entity);
    }
    
    @Override
    public void update(Comment entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Comment findOneById(Long id) {
    	Comment produit = (Comment) getCurrentSession().get(Comment.class, id);
        return produit; 
    }
    
    @Override
    public void delete(Comment entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Comment> findAll() {
    	List<Comment> products = (List<Comment>) getCurrentSession().createQuery("from Comment").list();
        
        return products;
    }
    
    @Override
    public void deleteAll() {
        List<Comment> entityList = findAll();
        for (Comment entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<Comment> findBy(String field, String value) {
		// TODO Auto-generated method stub
		return null;
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
