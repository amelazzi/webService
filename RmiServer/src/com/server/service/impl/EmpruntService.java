package com.server.service.impl;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.server.dao.impl.DemandeDaoImpl;
import org.hibernate.HibernateException;

import com.server.dao.impl.EmpruntDaoImpl;
import com.server.entities.impl.Demande;
import com.server.entities.impl.Emprunt;
import com.server.entities.impl.Notification;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
import com.server.service.interfaces.IEmpruntService;

 
public class EmpruntService implements IEmpruntService{
 
    private static EmpruntDaoImpl empruntDao;
    private static DemandeDaoImpl demandeDao;
    private static ProductService productService;
    private static DemandeService demandeService;
    private static NotificationService notificationService;
 
    public EmpruntService() {
        empruntDao = new EmpruntDaoImpl();
        demandeDao = new DemandeDaoImpl();
        productService= new ProductService();
        demandeService= new DemandeService();
        notificationService= new NotificationService();

    }
    
    public EmpruntDaoImpl empruntDao() {
        return empruntDao;
    }
    
    @Override
    public Emprunt add(Emprunt entity) {
    	try {
    		if(entity!=null) {
    			//empruntDao.openCurrentSessionwithTransaction();
                empruntDao.add(entity);
                //empruntDao.closeCurrentSessionwithTransaction();
                return entity;
    		}
		} catch (Exception e) {
			e.printStackTrace();	
		}
    	return null;
    }
    
    @Override
    public Emprunt update(Emprunt entity) {
    	try {
    		if(entity!=null) {
    			if(entity.getIdEmprunt()!=0L) {
    				//empruntDao.openCurrentSessionwithTransaction();
    	            empruntDao.update(entity);
    	            //empruntDao.closeCurrentSessionwithTransaction();
    	            return entity;
    			}
    		}
    		
		} catch (HibernateException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
	@Override
	public void delete(Emprunt emprunt) {
		try {
			//if(id!=0L) {
				//empruntDao.openCurrentSessionwithTransaction();
		        //Emprunt emprunt = empruntDao.findOneById(id);
		        empruntDao.delete(emprunt);
		        //empruntDao.closeCurrentSessionwithTransaction();
			//}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Emprunt findOneById(Long id) {
		try {
			if(id!=0L) {
				//empruntDao.openCurrentSession();
		        Emprunt emprunt = empruntDao.findOneById(id);
		        //empruntDao.closeCurrentSession();
		        return emprunt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Emprunt> findByUser(Long idUser){
		try {
			//empruntDao.openCurrentSession();
			List<Emprunt> emprunts = empruntDao.findByUser(idUser);
			//empruntDao.closeCurrentSession();
			return emprunts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    @Override
    public List<Emprunt> findAll() {
    	try {
    		//empruntDao.openCurrentSession();
            List<Emprunt> emprunts = empruntDao.findAll();
            //empruntDao.closeCurrentSession();
            return emprunts;
		} catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }
    
    @Override
    public void deleteAll() {
    	try {
    		//empruntDao.openCurrentSessionwithTransaction();
            empruntDao.deleteAll();
            //empruntDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

	@Override
	public boolean checkEmprunt(Product product, UserImpl user) {
		List<Emprunt> emprunts = empruntDao.findBy("iduser", Long.toString(user.getIdUser()));
		for(Emprunt e:emprunts){
			if((product.getIdProduct()==e.getProduct().getIdProduct()) && (e.getIsReturned()))
				return false;
		}
		return true;
	}

	@Override
	public List<Emprunt> findBy(String field, Object value) {
		// TODO Auto-generated method stub
		try {
			//empruntDao.openCurrentSession();
			List<Emprunt> emprunts = empruntDao.findBy(field, value);
			//empruntDao.closeCurrentSession();
			return emprunts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
	
	@Override
	public int emprunter(Product p, UserImpl u) throws Exception {
    	//On vérifie s'il a droit d'emprunter le livre ( qu'il a rendu le livre)
    	if(checkEmprunt(p, u)){
			if(p.getQuantity()>=1){
				Emprunt emprunt = new Emprunt();
				emprunt.setProduct(p);
				emprunt.setUser(u);
				try{
					add(emprunt);
					p.setQuantity(p.getQuantity()-1);
					productService.update(p);
					System.out.println("Emprunter accorder");
				}catch (Exception e){
					throw new Exception("Impossible d'emprunter");
				}
				return 1;
			}else{
				try{
					Demande demande = new Demande();
					demande.setProduct(p);
					demande.setUser(u);
					demandeService.add(demande);
				}catch (Exception e){
					throw new Exception("Impossible de faire une demande");
				}
				throw new Exception("demande en attente...");
			}
		}else{
			throw new Exception("vous avez deja empruntere ce livre");
		}
    }
    
	@Override
    public boolean restituer(Emprunt emprunt) {
    	if(emprunt!=null && !emprunt.getIsReturned()){
    		emprunt.setIsReturned(true);
    		emprunt.setReturnedAt(new Date());
    		update(emprunt);
    		emprunt.getProduct().setQuantity(emprunt.getProduct().getQuantity()+1);
    		productService.update(emprunt.getProduct());
			notifier(emprunt);
    		return true;
		}else
			return false;
    }

    public void notifier(Emprunt emprunt){
		List<UserImpl> students=new ArrayList<UserImpl>();
		List<UserImpl> teachers=new ArrayList<UserImpl>();
		List<Notification> notifications=new ArrayList<Notification>();

		//trouver les demandes relative à ce produit.
		List<Demande> demandes = demandeService.findByProduct(emprunt.getProduct().getIdProduct(), false);
		//Extraire les utilisateurs de ces demandes en
		if(demandes!=null){
			for(Demande d:demandes){
				if(d.getUser().getStatus()=="teacher"){
					teachers.add(d.getUser());
				}

				if(d.getUser().getStatus()=="student"){
					students.add(d.getUser());
				}
				Notification notif= new Notification();
				notif.setMessage("Le livre <<"+emprunt.getProduct().getTitle().toUpperCase()+">> que vous avez demandé est maintenant disponible");
				notif.setDemande(d);
				notifications.add(notif);
			}

			//S'il y a des demandes Envoyer des notifications à ces utilisateur
			if(teachers!=null)
				sendNotif(teachers, notifications, emprunt);
			else
				if(students!=null)
					sendNotif(students, notifications, emprunt);
		}
	}

    public void sendNotif(List<UserImpl> users, List<Notification> notifications, Emprunt emprunt){
		if(users.size()>1){
			Map<Long, Integer> list=new HashMap<Long, Integer>();
			for(UserImpl t: users)
				list.put(t.getIdUser(), t.getTotalEmprunt());

			Integer min = Collections.min(list.values());
			Long key= getKeyByValue(list,min);
			for(Notification n:notifications)
				if(n.getDemande().getUser().getIdUser()==key)
					if(n.getDemande().getProduct()==emprunt.getProduct())
						notificationService.add(n);

		}else
			for(Notification n:notifications)
				if(n.getDemande().getUser()==users.get(0))
					notificationService.add(n);
    }

	public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
		for (Map.Entry<T, E> entry : map.entrySet()) {
			if (Objects.equals(value, entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

}

