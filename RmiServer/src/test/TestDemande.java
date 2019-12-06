package test;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;


import com.server.entities.impl.Demande;
import com.server.entities.impl.Product;
import com.server.service.impl.DemandeService;
import com.server.service.impl.EmpruntService;
import com.server.service.impl.ProductService;
import com.server.service.impl.UserService;


public class TestDemande
{	
	static DemandeService demandeService = new DemandeService();
	static EmpruntService empruntService = new EmpruntService();
	static ProductService productService = new ProductService();
	static UserService userService = new UserService();
	
	public static void main(String[] args) throws RemoteException {
		//TestSelectAll();
		//TestFindByProduct();
		//TestUpdate();
		//displayMany(demandeService.findBy("iduser", 3L));
		//demandeService.deleteAll();
		testAdd();
		TestSelectAll();

	}

	public static void testAdd(){
		Demande demande = new Demande();
		demande.setProduct(productService.findOneById(12L));
		demande.setUser(userService.findOneById(3L));

		Demande demande2 = new Demande();
		demande2.setProduct(productService.findOneById(11L));
		demande2.setUser(userService.findOneById(3L));

		Demande demande3 = new Demande();
		demande3.setProduct(productService.findOneById(15L));
		demande3.setUser(userService.findOneById(2L));

		demandeService.add(demande);
		demandeService.add(demande2);
		demandeService.add(demande3);
	}
	
	public static String TestSelectAll(){
	      List<Demande> listDemandes=demandeService.findAll();
		  displayMany(listDemandes);
	      return "success";
	      
	}
	
	public static String TestUpdate(){
	      List<Demande> listDemandes=demandeService.findAll();
	      for (Demande d : listDemandes) {
		        d.setDesiredAt(new Date());
		        demandeService.update(d);
		  }
	      
	      listDemandes=demandeService.findAll();
	      displayMany(listDemandes);
	      
	      return "success";
	      
	   }
	
   public static String TestFindByProduct(){
	  Product prod = productService.findOneById((long) 2);  
      List<Demande> listDemandes=demandeService.findByProduct(prod);
      displayMany(listDemandes);
      
      return "success";
      
   }
   
   public static void displayOne(Demande demande) {
	   System.out.println("Demande :");
	   System.out.println("-" + demande.toString());
   }
   
   public static void displayMany(List<Demande> listDemandes) {
	   System.out.println("Demande list :");
	   for (Demande d : listDemandes) {
	        System.out.println("-" + d.toString());
	      }
   }

   
   
}