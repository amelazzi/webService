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
		//testUpdate();
		//testDelete(12);
		//TestUpdate();
		//TestAdd();
		//TestSelectAll();
		displayMany(productService.findAll());
		
	}
	
	public static void TestAdd() {
		Product product1 = new Product();
		//product1.setIdProduct(productService.getMaxId()+1);
        product1.setTitle("Livre Java");
		product1.setQuantity(5);
		product1.setPrice(23);
		product1.setDescription("ceci est une description du produit");
		product1.setAvailable(true);
		
		/*Product product2 = new Product();
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
		product3.setAvailable(true);*/
		
		
        System.out.println("*** Persist - start ***");
        productService.add(product1);
        //productService.add(product2);
        //productService.add(product3);
        
        TestSelectAll();
	}
	
	public static Product TestSelectAll(){
	      List<Product> listProducts = productService.findAll();
		  //displayMany(listProducts);
	      return listProducts.get(3);
	      
	}

	public static void testDelete(long i){
		Product product = new Product();
		product.setIdProduct(i);
		productService.delete(product);
	}
	
	public static String testUpdate(){
	      //List<Product> listProducts=productService.findAll();
	      //for (Product d : listProducts) {
		    //    d.setCreatedAt(new Date());
		Product p = new Product();
		p = TestSelectAll();
		System.out.println("id: " + p.getIdProduct());
		p.setAvailable(false);

		        productService.update(p);
		  //}
	      
	      //listProducts=productService.findAll();
	      //displayMany(listProducts);
	      
	      return "success";
	      
	   }
	
   
   public static void displayOne(Product demande) {
	   System.out.println("Product :");
	   System.out.println("-" + demande.toString());
   }
   
   public static void displayMany(List<Product> listProducts) {
	   System.out.println("Product list :");
	   for (Product d : listProducts) {
	        System.out.println(d.toString());
	      }
   }


   
   
}
