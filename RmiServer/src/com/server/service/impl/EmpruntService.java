package com.server.service.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
    private static ProductService productService;
    private static DemandeService demandeService;
    private static NotificationService notificationService;
 
    public EmpruntService() {
        empruntDao = new EmpruntDaoImpl();
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
					//add(demande);
				}catch (Exception e){
					throw new Exception("Impossible de faire une demande");
				}
				throw new Exception("demande en attente...");
			}
		}else{
			throw new Exception("vous avez deja empruntere ce livre");
		}


    	/*if(p.getQuantity()>=1) {
    		//procedure d'emprunt
    		Emprunt emprunt = new Emprunt();
    		emprunt.setProduct(p);
    		emprunt.setUser(u);
    		
    		try {
        		this.add(emprunt);
        		p.setQuantity(p.getQuantity()-1);
        		productService.update(p);
        		return 1;
			} catch (Exception e) {
				System.out.println("Impossible d'emprunter");
				return 0;
			}
    	}else {
    		//procedure de mise en attente parmis les demandes
    		Demande demande = new Demande();
    		demande.setProduct(p);
    		demande.setUser(u);
    		
    		try {
				demandeService.save(demande);
			} catch (Exception e) {
				System.out.println("Impossible de le mettre dans les attentes");
				return 0;
			}
    		return -1;
    	}*/
    }
    
	@Override
    public boolean restituer(Emprunt emprunt) {
    	if(!emprunt.getIsReturned()){
    		emprunt.setIsReturned(true);
    		emprunt.setReturnedAt(new Date());
    		update(emprunt);
    		emprunt.getProduct().setQuantity(emprunt.getProduct().getQuantity()+1);
    		productService.update(emprunt.getProduct());
    		return true;
		}else
			return false;
    	/*if(!emprunt.getIsReturned()) {
    		emprunt.setReturnedAt(new Date());
    		emprunt.setIsReturned(true);
    		try {
				this.update(emprunt);
				Product product = emprunt.getProduct();
				product.setQuantity(product.getQuantity()+1);
				productService.update(product);
				
				//notification au user..
				try {
					UserImpl user =this.checkPriority(emprunt);
					//System.out.println("-"+user.toString());
					if(user!=null) {
						System.out.println("here");	
						Notification notification = new Notification();
						notification.setMessage("Notification demande: Le produit que vous avez souhait� "
								+ "emprunter est maintenant disponible. Veuillez valider l'emprunt");
						notificationService.save(notification);
					}
				} catch (Exception e) {
					System.out.println("Impossible de notifier");
					e.printStackTrace();
					return false;
				}
				
				
				return true;
			} catch (Exception e) {
				System.out.println("Impossible de restituer");
				//e.printStackTrace();
				return false;
			}
    	}*/
    }
    
    public List<UserImpl> getWaitingUsers(Emprunt emprunt) {
    	Product product =emprunt.getProduct();
    	List<Demande> listDemandes =demandeService.findByProduct(product);
    	List<UserImpl> waitingUsers = new ArrayList<UserImpl>();
    	if(listDemandes!=null) {
    		waitingUsers = demandeService.findWaitingUserByProduct(product);
    		return waitingUsers;
    	}
    	return null;
    }
    
    @SuppressWarnings("unused")
	public UserImpl checkPriority(Emprunt emprunt) {
    	List<UserImpl> students = new ArrayList<>();
    	List<UserImpl> teachers = new ArrayList<>();
    	List<UserImpl> users = this.getWaitingUsers(emprunt);
     	
    	UserImpl user = new UserImpl();
    	
    	if(users!=null) {
    		for(UserImpl u:users) {
        		if("teacher".equals(u.getStatus())) {
        			teachers.add(u);
        		}else {
        			students.add(u);
        		}
        	}
    		
    		if(teachers!=null) {
    			return lessEmprunt(teachers);
    		}
    		
    		if(students!=null) {
    			return lessEmprunt(students);
    		}
			
    	}
    	
		return null;
	}
    
    public UserImpl lessEmprunt(List<UserImpl> users) {
    	Collections.sort(users,new Comparator<UserImpl>() {
    				public int compare(UserImpl u1, UserImpl u2) {
    					return Integer.valueOf(u1.getTotalEmprunt()).compareTo(u2.getTotalEmprunt());
    				}
    			});
    	for(UserImpl u:users) {
    		System.out.println("-"+u.toString());
    	}
    	
    	
    	return (users.size()>0)?users.get(0):null;
    }
    
    
}

