package com.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.server.entities.impl.Product;
import com.server.service.impl.ProductService;
import com.server.service.impl.UserService;
import com.server.utils.Database;
import com.server.utils.DateTool;
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
    private UserService userService = new UserService();
    private ProductService productService = new ProductService();
 
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
    public Comment parseComment(String[][] data, int i) {
        Comment comment = new Comment();

        comment.setIdComment(Long.parseLong(data[i][0]));
        comment.setContent(data[i][1]);
        comment.setCreateAt(DateTool.stringToDate(data[i][2]));
        comment.setProduct(productService.findOneById(Long.parseLong(data[i][3])));
        comment.setUser(userService.findOneById(Long.parseLong(data[i][4])));

        return comment;
    }

    @Override
    public void update(Comment entity) {
        database.update("comment", entity);
    }
    
    @Override
    public Comment findOneById(Long id) {
        Comment comment = findBy("idComment", id).get(0);
        return comment;
    }
    
    @Override
    public void delete(Comment entity) {
        database.delete("comment", "idComment", entity.getIdComment());
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Comment> findAll() {
        String[][] comments = database.select("comment");
        List<Comment> commentList = new ArrayList<>();

        for(int i=1; i<comments.length; i++){
            commentList.add(parseComment(comments,i));
        }

        return commentList;
    }
    
    @Override
    public void deleteAll() {
        List<Comment> entityList = findAll();
        for (Comment entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<Comment> findBy(String field, Object value) {
		// TODO Auto-generated method stub
        String[][] comments = database.select("comment", field, value);
        List<Comment> commentsList = new ArrayList<>();

        for(int i=1; i<comments.length; i++){
            commentsList.add(parseComment(comments,i));
        }

        return commentsList;
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
