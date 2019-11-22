package com.server.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.IProductDao;
import com.server.entities.impl.Product;
 
 
public class ProductDaoImpl implements IProductDao<Product, String> {
 
    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public ProductDaoImpl() {
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
    	HibernateUtils utils=new HibernateUtils();
    	return utils.getSessionFactory();
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
    public void persist(Product entity) {
        getCurrentSession().save(entity);
    }
    
    @Override
    public void update(Product entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Product findOneById(String id) {
    	Product produit = (Product) getCurrentSession().get(Product.class, id);
        return produit; 
    }
    
    @Override
    public void delete(Product entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Product> findAll() {
        List<Product> books = (List<Product>) getCurrentSession().createQuery("from Product").list();
        return books;
    }
    
    @Override
    public void deleteAll() {
        List<Product> entityList = findAll();
        for (Product entity : entityList) {
            delete(entity);
        }
    }
}
