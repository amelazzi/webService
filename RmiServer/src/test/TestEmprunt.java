package test;
import java.rmi.RemoteException;
import java.util.List;


import com.server.entities.impl.Emprunt;
import com.server.entities.impl.UserImpl;
import com.server.service.impl.EmpruntService;
import com.server.service.impl.ProductService;
import com.server.service.impl.UserService;


public class TestEmprunt
{	
	static EmpruntService empruntService = new EmpruntService();
	static UserService userService = new UserService();
	static ProductService productService  = new ProductService();
	
	public static void main(String[] args) throws RemoteException {
		//TestSelectAll();
		//TestUpdate();
		//testRestituter();
		//testCheckPriority();
		Emprunt emprunt = new Emprunt();
		emprunt.setIdEmprunt(4L);
		//emprunt.setUser(userService.findOneById(3L));
		//emprunt.setIsReturned(true);
		//empruntService.add(emprunt);*/
		empruntService.delete(emprunt);
		displayMany(empruntService.findAll());
		//empruntService.restituer(empruntService.findOneById(2L));


	}
	
	public void testEmprunter() {
		
	}
	
	public static void testRestituter() {
		Emprunt emprunt = empruntService.findOneById((long)12);
		empruntService.restituer(emprunt);
		displayOne(emprunt);
	}
	
	public static void testCheckPriority() {
		Emprunt emprunt = empruntService.findOneById((long)5);
		UserImpl user = null;
		user = empruntService.checkPriority(emprunt);
		displayOne(emprunt);
		//System.out.println("-User: " + user.toString());
	}
	
	public static String TestSelectAll(){
	      List<Emprunt> listEmprunts=empruntService.findAll();
		  displayMany(listEmprunts);
	      return "success";
	      
	}
	
	public static String TestUpdate(){
	      List<Emprunt> listEmprunts=empruntService.findAll();
	      for (Emprunt e : listEmprunts) {
		        e.setIsReturned(false);
		        empruntService.update(e);
		  }
	      
	      listEmprunts=empruntService.findAll();
	      displayMany(listEmprunts);
	      
	      return "success";
	      
	   }
	
   
   public static void displayOne(Emprunt emprunt) {
	   System.out.println("Emprunt :");
	   System.out.println("-" + emprunt.toString());
   }
   
   public static void displayMany(List<Emprunt> listEmprunts) {
	   System.out.println("Emprunt list :");
	   for (Emprunt d : listEmprunts) {
	        System.out.println("-" + d.toString());
	      }
   }

   
   
}