package com.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.server.service.impl.ProductService;
import com.server.service.impl.UserService;
import com.server.utils.Database;
import com.server.utils.DateTool;
import com.server.utils.PostgresDataSource;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.server.dao.interfaces.IDemandeDao;
import com.server.entities.impl.Demande;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
 
 
public class DemandeDaoImpl implements IDemandeDao<Demande, Long> {
 
    private Session currentSession;
    private Transaction currentTransaction;

    private  Database database;
    private UserService userService = new UserService();
    private ProductService productService = new ProductService();
 
    public DemandeDaoImpl() {
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
        String[][] data = database.executeQuery("select max(idDemande) as max from demande");
        if(data[1][0]!=null)
            id = Long.parseLong(data[1][0]);
        else
            id = 0L;
        return id;
    }

    @Override
    public void add(Demande entity) {
        entity.setIdDemande(this.getMaxId()+1);
        database.insert("demande", entity);
    }
    
    @Override
    public void update(Demande entity) {
        getCurrentSession().update(entity);
    }
    
    @Override
    public Demande findOneById(Long id) {
    	Demande demande = (Demande) getCurrentSession().get(Demande.class, id);
        return demande; 
    }

    @Override
    public Demande parseDemande(String[][] data, int i) {
        Demande demande = new Demande();

        demande.setIdDemande(Long.parseLong(data[i][0]));
        demande.setCreatedAt(DateTool.stringToDate(data[i][1]));
        demande.setDesiredAt(DateTool.stringToDate(data[i][2]));

        boolean isDone = data[i][3]=="t"? true:false;
        demande.setIsDone(isDone);

        demande.setProduct(productService.findOneById(Long.parseLong(data[i][4])));
        demande.setUser(userService.findOneById(Long.parseLong(data[i][5])));

        return demande;
    }

    @Override
    public void delete(Demande entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Demande> findAll() {
        String[][] demandes = database.select("demande");
        List<Demande> demandesList = new ArrayList<>();

        for(int i=1; i<demandes.length; i++){
            demandesList.add(parseDemande(demandes,i));
        }

        return demandesList;
    }
    
    @Override
    public void deleteAll() {
        List<Demande> entityList = findAll();
        for (Demande entity : entityList) {
            delete(entity);
        }
    }

	@Override
	public List<Demande> findBy(String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Demande> findBy(String[] fields, Object[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Demande> findAllSortedBy(String field, String order) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Demande> findByProduct(Product product) {
		openCurrentSession();
		List<Demande> demandes = null;
		
		try {
			@SuppressWarnings("deprecation")
			Criteria criteria = getCurrentSession().createCriteria(Demande.class);
			criteria.add(Restrictions.eq("product", product));
			criteria.add(Restrictions.eq("isDone", false));
			demandes = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeCurrentSession();
		return demandes;
	}
	
	@Override
	public List<UserImpl> findWaitingUserByProduct(Product product){
		List<Demande> demandes = this.findByProduct(product);
		List<UserImpl> users = new ArrayList<UserImpl>();
		if(demandes!=null) {
			for(Demande d:demandes) {
				users.add(d.getUser());
			}
		}
		
		return users;
	}
}
