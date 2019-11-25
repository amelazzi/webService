package com.server.launcher;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.server.rmi.impl.ProductRmi;
import com.server.rmi.interfaces.IProductRmi;

public class Main {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			IProductRmi productRmiService = new ProductRmi();
			Naming.rebind("productService", productRmiService);	
			System.out.print("Server OK");
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
