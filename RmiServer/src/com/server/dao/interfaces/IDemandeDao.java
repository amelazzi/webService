package com.server.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import com.server.entities.impl.Demande;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
 
public interface IDemandeDao<T, Id extends Serializable> {

    public long getMaxId();

    public void add(T entity);
     
    public void update(T entity);
     
    public T findOneById(Id id);

    public Demande parseDemande(String[][] data, int i);

    public List<T> findBy(String field, Object value);
    
    public List<T> findBy(String[] fields, Object[] values);
     
    public List<T> findAll();
    
    public List<T> findAllSortedBy(String field, String order);

    public List<Demande> findByProduct(Long idProduct, boolean isDone);
    
    public List<UserImpl> findWaitingUserByProduct(Product product);
     
    public void delete(T entity);
    
    public void deleteAll();
     
}
