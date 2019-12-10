package com.server.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.server.service.impl.DemandeService;
import com.server.utils.Database;
import com.server.utils.DateTool;
import com.server.utils.PostgresDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.server.dao.interfaces.INotificationDao;
import com.server.entities.impl.Notification;
import com.server.entities.impl.UserImpl;
import org.hibernate.cfg.Configuration;


public class NotificationDaoImpl implements INotificationDao<Notification, Long> {
 
    private Session currentSession;
    private Transaction currentTransaction;

    private Database database;
    private DemandeService demandeService = new DemandeService();
 
    public NotificationDaoImpl() {
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
        String[][] data = database.executeQuery("select max(idNotification) as max from notification");
        if(data[1][0]!=null)
            id = Long.parseLong(data[1][0]);
        else
            id = 0L;
        return id;
    }

    @Override
    public void add(Notification entity) {
        entity.setIdNotification(this.getMaxId()+1);
        database.insert("notification", entity);
    }
    
    @Override
    public void update(Notification entity) {
        database.update("notification", entity);
    }

    @Override
    public Notification parseNotif(String[][] data, int i) {
        Notification notif = new Notification();

        notif.setIdNotification(Long.parseLong(data[i][0]));

        boolean isread = data[i][1].equals("t")? true:false;;
        notif.setIsRead(isread);

        notif.setMessage(data[i][2]);
        notif.setSendAt(DateTool.stringToDate(data[i][3]));

        notif.setDemande(demandeService.findOneById(Long.parseLong(data[i][4])));

        return notif;
    }

    @Override
    public Notification findOneById(Long id) {
        Notification notif = findBy("idNotification", id).get(0);
        return notif;
    }

    @Override
    public List<Notification> findBy(String field, Object value) {
        String[][] notifs = database.select("notification", field, value);
        List<Notification> notifsList = new ArrayList<>();

        for(int i=1; i<notifs.length; i++){
            notifsList.add(parseNotif(notifs,i));
        }

        return notifsList;
    }

    @Override
    public void delete(Notification entity) {
        database.delete("notification", "idnotification", entity.getIdNotification());
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public List<Notification> findAll() {
        String[][] notifs = database.select("notification");
        List<Notification> notifsList = new ArrayList<>();

        for(int i=1; i<notifs.length; i++){
            notifsList.add(parseNotif(notifs,i));
        }

        return notifsList;
    }
    
    @Override
    public void deleteAll() {
        List<Notification> entityList = findAll();
        for (Notification entity : entityList) {
            delete(entity);
        }
    }


}
