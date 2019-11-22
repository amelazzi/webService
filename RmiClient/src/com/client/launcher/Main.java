package com.client.launcher;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import com.server.entities.impl.Product;
import com.server.rmi.interfaces.IProductRmi;

public class Main {

	public static void main(String[] args) {
		
			IProductRmi stubProduct;
			try {
				stubProduct = (IProductRmi) Naming.lookup("productService");
				System.out.print("Client OK");
				
				Product product1 = new Product();
		        product1.setTitle("Livre Java");
				product1.setQuantity(5);
				product1.setPrice(23);
				product1.setDescription("ceci est une description du produit");
				product1.setAvailable(true);
				
				Product product2 = new Product();
		        product2.setTitle("Livre Python");
				product2.setQuantity(5);
				product2.setPrice(23);
				product2.setDescription("ceci est une description du produit");
				product2.setAvailable(true);
				
				Product product3 = new Product();
		        product3.setTitle("Livre C");
				product3.setQuantity(5);
				product3.setPrice(23);
				product3.setDescription("ceci est une description du produit");
				product3.setAvailable(true);
				
				
		        System.out.println("*** Add product - start ***");
		        stubProduct.add(product1);
		        stubProduct.add(product2);
		        stubProduct.add(product3);
				
				
				System.out.print("***List Product****");
				List<Product> list = stubProduct.findAll();
				for(Product p:list) {
					System.out.print("Title "+ p.getTitle()+" Price "+p.getPrice());
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
			
	}

}
