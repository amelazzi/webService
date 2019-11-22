package test;

import java.rmi.RemoteException;

import com.server.entities.impl.Product;
import com.server.service.impl.ProductService;

import antlr.collections.List;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws RemoteException {
		ProductService prodService = new ProductService();
		
        Product product1 = new Product();
        product1.setTitle("Livre Java");
		product1.setQuantity(5);
		product1.setPrice(23);
		product1.setDescription("ceci est une description du produit");
		product1.setAvailable(true);
		
		Product product2 = new Product();
        product2.setTitle("Livre Java");
		product2.setQuantity(5);
		product2.setPrice(23);
		product2.setDescription("ceci est une description du produit");
		product2.setAvailable(true);
		
		Product product3 = new Product();
        product3.setTitle("Livre Java");
		product3.setQuantity(5);
		product3.setPrice(23);
		product3.setDescription("ceci est une description du produit");
		product3.setAvailable(true);
		
		
        System.out.println("*** Persist - start ***");
        prodService.save(product1);
        prodService.save(product2);
        prodService.save(product3);
        
        
        //List<Product> books1 = bookService.findAll();
        //System.out.println("Products Persisted are :");
        //for (Product b : books1) {
          //  System.out.println("-" + b.toString());
        //}
        /*System.out.println("*** Persist - end ***");
        System.out.println("*** Update - start ***");
        product1.setTitle("The Idiot");
        bookService.update(product1);
        System.out.println("Product Updated is =>" +bookService.findById(product1.getId()).toString());
        System.out.println("*** Update - end ***");
        System.out.println("*** Find - start ***");
        String id1 = product1.getId();
        Product another = bookService.findById(id1);
        System.out.println("Product found with id " + id1 + " is =>" + another.toString());
        System.out.println("*** Find - end ***");
        System.out.println("*** Delete - start ***");
        String id3 = product3.getId();
        bookService.delete(id3);
        System.out.println("Deleted book with id " + id3 + ".");
        System.out.println("Now all books are " + bookService.findAll().size() + ".");
        System.out.println("*** Delete - end ***");
        System.out.println("*** FindAll - start ***");
        List<Product> books2 = bookService.findAll();
        System.out.println("Products found are :");
        for (Product b : books2) {
            System.out.println("-" + b.toString());
        }
        System.out.println("*** FindAll - end ***");
        System.out.println("*** DeleteAll - start ***");
        bookService.deleteAll();
        System.out.println("Products found are now " + bookService.findAll().size());
        System.out.println("*** DeleteAll - end ***");
         System.exit(0);*/


	}

}
