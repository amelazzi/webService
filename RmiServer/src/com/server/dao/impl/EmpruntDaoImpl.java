package com.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.server.service.impl.ProductService;
import com.server.service.impl.UserService;
import com.server.utils.Database;
import com.server.utils.DateTool;
import com.server.utils.PostgresDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.IEmpruntDao;
import com.server.entities.impl.Emprunt;
import org.hibernate.cfg.Configuration;


public class EmpruntDaoImpl implements IEmpruntDao<Emprunt, Long> {
 
    private Session currentSession;
    private Transaction currentTransaction;

    Database database;
    ProductService productService = new ProductService();
    UserService userService = new UserService();
 
    public EmpruntDaoImpl() {
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
        String[][] data = database.executeQuery("select max(idEmprunt) as max from emprunt");
        if(data[1][0]!=null)
            id = Long.parseLong(data[1][0]);
        else
            id = 0L;
        return id;
    }

    @Override
    public void add(Emprunt entity) {
        entity.setIdEmprunt(this.getMaxId()+1);
        database.insert("emprunt", entity);
    }
    
    @Override
    public void update(Emprunt entity) {
        database.update("emprunt", entity);
    }

    @Override
    public Emprunt parseEmprunt(String[][] data, int i) {
        Emprunt emprunt = new Emprunt();

        emprunt.setIdEmprunt(Long.parseLong(data[i][0]));
        emprunt.setCreatedAt(DateTool.stringToDate(data[i][1]));

        boolean isReturned = data[i][2]=="t"? true:false;
        emprunt.setIsReturned(isReturned);

        emprunt.setReturnedAt(DateTool.stringToDate(data[i][3]));
        emprunt.setToGiveBackAt(DateTool.stringToDate(data[i][4]));
        emprunt.setProduct(productService.findOneById(Long.parseLong(data[i][5])));
        emprunt.setUser(userService.findOneById(Long.parseLong(data[i][6])));

        return emprunt;
    }

    @Override
    public Emprunt findOneById(Long id) {
        Emprunt emprunt = findBy("idemprunt", id).get(0);
        return emprunt;
    }
    
    @Override
    public void delete(Emprunt entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Emprunt> findAll() {
        String[][] emprunts = database.select("emprunt");
        List<Emprunt>empruntsList = new ArrayList<>();

        for(int i=1; i<emprunts.length; i++){
            empruntsList.add(parseEmprunt(emprunts,i));
        }

        return empruntsList;
    }
    
    @Override
    public void deleteAll() {
        List<Emprunt> entityList = findAll();
        for (Emprunt entity : entityList) {
            delete(entity);
        }
    }

	@Override

	public List<Emprunt> findBy(String field, Object value) {
		// TODO Auto-generated method stub
        String[][] emprunts = database.select("emprunt", field, value);
        List<Emprunt> empruntsList = new ArrayList<>();

        for(int i=1; i<emprunts.length; i++){
            empruntsList.add(parseEmprunt(emprunts,i));
        }

        return empruntsList;
	}

	@Override
	public List<Emprunt> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emprunt> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
