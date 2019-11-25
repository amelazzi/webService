package test;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;


import com.server.entities.impl.Product;
import com.server.service.impl.ProductService;


public class TestProduct
{	
	
	static ProductService productService = new ProductService();
	
	public static void main(String[] args) throws RemoteException {
		//TestSelectAll();
		//TestUpdate();
		//TestAdd();
		
	}
	
	public void TestAdd() {
		Product product1 = new Product();
        product1.setTitle("Livre Java");
		product1.setQuantity(5);
		product1.setPrice(23);
		product1.setDescription("ceci est une description du produit");
		product1.setAvailable(true);
		
		Product product2 = new Product();
        product2.setTitle("Livre C");
		product2.setQuantity(5);
		product2.setPrice(23);
		product2.setDescription("ceci est une description du produit");
		product2.setAvailable(true);
		
		Product product3 = new Product();
        product3.setTitle("Livre Python");
		product3.setQuantity(5);
		product3.setPrice(23);
		product3.setDescription("ceci est une description du produit");
		product3.setAvailable(true);
		
		
        System.out.println("*** Persist - start ***");
        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        
        TestSelectAll();
	}
	
	public static String TestSelectAll(){
	      List<Product> listProducts=productService.findAll();
		  displayMany(listProducts);
	      return "success";
	      
	}
	
	public static String TestUpdate(){
	      List<Product> listProducts=productService.findAll();
	      for (Product d : listProducts) {
		        d.setCreatedAt(new Date());
		        productService.update(d);
		  }
	      
	      listProducts=productService.findAll();
	      displayMany(listProducts);
	      
	      return "success";
	      
	   }
	
   
   public static void displayOne(Product demande) {
	   System.out.println("Product :");
	   System.out.println("-" + demande.toString());
   }
   
   public static void displayMany(List<Product> listProducts) {
	   System.out.println("Product list :");
	   for (Product d : listProducts) {
	        System.out.println("-" + d.toString());
	      }
   }

   
   
}