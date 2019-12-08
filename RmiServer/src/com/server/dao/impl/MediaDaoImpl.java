package com.server.dao.impl;


import java.sql.*;
import java.util.List;

import com.server.utils.Database;
import com.server.utils.PostgresDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.IMediaDao;
import com.server.entities.impl.Media;
import org.hibernate.cfg.Configuration;

import javax.sql.rowset.serial.SerialBlob;


public class MediaDaoImpl implements IMediaDao<Media, Long> {
 
    private Session currentSession;
    private Transaction currentTransaction;

    private Database database;
 
    public MediaDaoImpl() {
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
    public Blob arrayByteToBlob(byte[] picture) throws SQLException {
        Blob pictureBlob = new SerialBlob(picture);
        return pictureBlob;
    }

    @Override
    public byte[] blobToArrayByte(Blob picture) throws SQLException {
        //Blob blob = resultat.getBlob("photo");
        int blobLength = (int) picture.length();
        byte[] pictureByte = picture.getBytes(1, blobLength);
        return pictureByte;
    }

    @Override
    public void add(Media entity) {//throws IOException, SQLException {
        /*File file = entity.getImage();
        FileInputStream fis = new FileInputStream(entity.getImage());

        String url = "jdbc:postgresql://localhost:5432/rmidb";
        String user = "postgres";
        String password = "";
        Connection conn = DriverManager.getConnection(url, user, password);
        //Statement st = con.createStatement();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO media VALUES (?, ?, ?, ?, ?)");
        //PreparedStatement ps = conn.prepareStatement("INSERT INTO images VALUES (?, ?)");
        ps.setLong(1, entity.getIdMedia());
        ps.setString(2, entity.getName());
        ps.setDate(3,null);
        ps.setLong(4, entity.getProduct().getIdProduct());
        ps.setBinaryStream(5, fis, (int)file.length());
        ps.executeUpdate();
        ps.close();
        fis.close();*/
    }
    
    @Override
    public void update(Media entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Media findOneById(Long id) {
    	Media produit = (Media) getCurrentSession().get(Media.class, id);
        return produit; 
    }
    
    @Override
    public void delete(Media entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Media> findAll() {
    	List<Media> products = (List<Media>) getCurrentSession().createQuery("from Media").list();
        
        return products;
    }
    
    @Override
    public void deleteAll() {
        List<Media> entityList = findAll();
        for (Media entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<Media> findBy(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Media> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Media> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
