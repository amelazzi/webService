package com.server.dao.impl;

import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.server.utils.Database;
import com.server.utils.DateTool;
import com.server.utils.PostgresDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.IProductDao;
import com.server.entities.impl.Product;
import org.hibernate.cfg.Configuration;

import static java.time.temporal.ChronoUnit.DAYS;


public class ProductDaoImpl implements IProductDao<Product, Long> {
 
    private Session currentSession;
    private Transaction currentTransaction;

    private  Database database;

    public ProductDaoImpl() {
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
    public void add(Product entity) {
        //product1.setIdProduct(productService.getMaxId()+1);
        entity.setIdProduct(this.getMaxId()+1);
        database.insert("product", entity);
    }
    
    @Override
    public void update(Product entity) {
        database.update("product", entity);
    }
    
    @Override
    public Product findOneById(Long id) {
        Product product = findBy("idproduct", id).get(0);
        return product;
    }
    
    @Override
    public void delete(Product entity) {
        database.delete("product", "idProduct", entity.getIdProduct());
    }

    @Override
    public long getMaxId(){
        long id;
        String[][] data = database.executeQuery("select max(idProduct) as max from product");
        if(data[1][0]!=null)
            id = Long.parseLong(data[1][0]);
        else
            id = 0L;
        return id;
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Product> findAll() {
    	//List<Product> products = (List<Product>) getCurrentSession().createQuery("from Product").list();

        String[][] products = database.select("product");
        List<Product> productsList = new ArrayList<>();

        for(int i=1; i<products.length; i++){
            productsList.add(parseProduct(products,i));
        }

        return productsList;
    }
    
    @Override
    public void deleteAll() {
        List<Product> entityList = findAll();
        for (Product entity : entityList) {
            delete(entity);
        }
    }

    @Override
    public Product parseProduct(String[][] data, int i) {
        Product product = new Product();

        product.setIdProduct(Long.parseLong(data[i][0]));

        boolean available = data[i][1].equals("t")? true:false;;
        product.setAvailable(available);

        product.setCreatedAt(DateTool.stringToDate(data[i][2]));
        product.setDescription(data[i][3]);
        product.setPrice(Float.parseFloat(data[i][4]));
        product.setQuantity(Integer.valueOf(data[i][5]));
        product.setTitle(data[i][6]);

        return product;
    }

    @Override
    public List<Product> saleProduct(int dayNbr) {
        Date date = new Date();
        List<Product> productsList = findAll();
        List<Product> saleProducts = new ArrayList<>();
        int days;
        for(Product product: productsList){
            days = (int)( (date.getTime() - product.getCreatedAt().getTime()) / (1000 * 60 * 60 * 24));
            if(days>dayNbr)
                saleProducts.add(product);
        }
        return saleProducts;
    }

    @Override
	public List<Product> findBy(String field, Object value) {
		// TODO Auto-generated method stub
        String[][] products = database.select("product", field, value);
        List<Product> productsList = new ArrayList<>();

        for(int i=1; i<products.length; i++){
            productsList.add(parseProduct(products,i));
        }

        return productsList;
	}

	@Override
	public List<Product> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
}
