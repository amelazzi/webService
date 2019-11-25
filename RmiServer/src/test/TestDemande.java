package test;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;


import com.server.entities.impl.Demande;
import com.server.entities.impl.Product;
import com.server.service.impl.DemandeService;
import com.server.service.impl.EmpruntService;
import com.server.service.impl.ProductService;


public class TestDemande
{	
	static DemandeService demandeService = new DemandeService();
	static EmpruntService empruntService = new EmpruntService();
	static ProductService productService = new ProductService();
	
	public static void main(String[] args) throws RemoteException {
		//TestSelectAll();
		TestFindByProduct();
		//TestUpdate();
		
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