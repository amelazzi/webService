package com.client.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.server.rmi.interfaces.IProductRmi;

public class ProductStub {
	
	private ProductStub() {
		
	}
	
	public static IProductRmi getStub() throws Exception {
		
		try {
			IProductRmi stubProduct=(IProductRmi) Naming.lookup("productService");
			return stubProduct;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new Exception("Erreur de récupération du Stub");
	}
	
	

}
