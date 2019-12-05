package com.server.dao.impl;

import java.util.List;

import com.server.utils.Database;
import com.server.utils.PostgresDataSource;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.server.dao.interfaces.IUserDao;
import com.server.entities.impl.UserImpl;
import com.server.utils.EncodeSha;
 
 
public class UserDaoImpl implements IUserDao<UserImpl, Long> {
 
    private Session currentSession;
    private Transaction currentTransaction;

    private Database database;
 
    public UserDaoImpl() {
        String hostname = "localhost";
        String dbName = "rmidb";
        String user = "postgres";
        String pwd = "";

        PostgresDataSource postgresDataSource = new PostgresDataSource(
                hostname, dbName, user, pwd);

        database = new Database(postgresDataSource);
    }
    
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        //currentSession = getSessionFactory().openSession();
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
    public void add(UserImpl entity) {
        entity.setIdUser(this.getMaxId()+1);
        database.insert("userimpl", entity);
    }
    
    @Override
    public void update(UserImpl entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public long getMaxId() {
        String[][] data = database.executeQuery("select max(idUser) as max from userimpl");
        long id = Long.parseLong(data[1][0]);
        return id;
    }

    @Override
    public UserImpl findOneById(Long id) {
    	UserImpl produit = (UserImpl) getCurrentSession().get(UserImpl.class, id);
        return produit; 
    }
    
    @Override
    public void delete(UserImpl entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<UserImpl> findAll() {
    	List<UserImpl> products = (List<UserImpl>) getCurrentSession().createQuery("from UserImpl").list();
        
        return products;
    }
    
    @Override
    public void deleteAll() {
        List<UserImpl> entityList = findAll();
        for (UserImpl entity : entityList) {
            delete(entity);
        }
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

	@Override
    public Boolean checkLogin(String email, String password){
        openCurrentSession();
        Criteria criteria = getCurrentSession().createCriteria(UserImpl.class);
        UserImpl user = (UserImpl) criteria.add(Restrictions.eq("email", email))
                .uniqueResult();
        closeCurrentSession();
        if(user!=null){
            if(user.getPassword().equals(EncodeSha.getHash(password))) {
                System.out.println("mot de passe correcte");
                return true;
            }else{
                System.out.println("mot de passe incorrecte");
                return false;
            }
        }else{
            System.out.println("l'utilisateur n'existe pas");
            //return null;
            return false;
        }
    }

}
