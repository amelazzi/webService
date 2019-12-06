package com.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.server.service.impl.ProductService;
import com.server.utils.Database;
import com.server.utils.PostgresDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.IRateDao;
import com.server.entities.impl.Rate;
import org.hibernate.cfg.Configuration;

import javax.xml.crypto.Data;


public class RateDaoImpl implements IRateDao<Rate, Long> {
 
    private Session currentSession;
    private Transaction currentTransaction;

    private ProductService productService = new ProductService();

    Database database;
 
    public RateDaoImpl() {
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
        String[][] data = database.executeQuery("select max(idRate) as max from rate");
        if(data[1][0]!=null)
            id = Long.parseLong(data[1][0]);
        else
            id = 0L;
        return id;
    }

    @Override
    public void add(Rate entity) {
        entity.setIdRate(this.getMaxId()+1);
        database.insert("rate", entity);
    }
    
    @Override
    public void update(Rate entity) {
        database.update("rate", entity);
    }

    @Override
    public Rate parseRate(String[][] data, int i) {
        Rate rate = new Rate();

        rate.setIdRate(Long.parseLong(data[i][0]));
        rate.setValue(Integer.valueOf(data[i][1]));
        rate.setProduct(productService.findOneById(Long.parseLong(data[i][2])));
        return rate;
    }

    @Override
    public Rate findOneById(Long id) {
        Rate rate = findBy("idrate", id).get(0);
        return rate;
    }
    
    @Override
    public void delete(Rate entity) {
        database.delete("rate", "idRate", entity.getIdRate());
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Rate> findAll() {
        String[][] rates = database.select("rate");
        List<Rate> ratesList = new ArrayList<>();

        for(int i=1; i<rates.length; i++){
            ratesList.add(parseRate(rates,i));
        }

        return ratesList;
    }
    
    @Override
    public void deleteAll() {
        List<Rate> entityList = findAll();
        for (Rate entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<Rate> findBy(String field, Object value) {
		// TODO Auto-generated method stub
        String[][] rates = database.select("rate", field, value);
        List<Rate> ratesList = new ArrayList<>();

        for(int i=1; i<rates.length; i++){
            ratesList.add(parseRate(rates,i));
        }

        return ratesList;
	}

	@Override
	public List<Rate> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rate> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
