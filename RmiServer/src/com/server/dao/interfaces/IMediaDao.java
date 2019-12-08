package com.server.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
 
public interface IMediaDao<T, Id extends Serializable> {

    public Blob arrayByteToBlob (byte[] picture) throws SQLException;

    public byte[] blobToArrayByte (Blob picture) throws SQLException;
 
    public void add(T entity) throws IOException, SQLException;
     
    public void update(T entity);
     
    public T findOneById(Id id);
     
    public List<T> findBy(String field, String value);
    
    public List<T> findBy(String[] fields, Object[] values);
     
    public List<T> findAll();
    
    public List<T> findAllSortedBy(String field, String order);
     
    public void delete(T entity);
    
    public void deleteAll();
     
}
