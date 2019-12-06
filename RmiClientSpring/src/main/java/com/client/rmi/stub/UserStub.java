package com.client.rmi.stub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.server.rmi.interfaces.IProductRmi;
import com.server.rmi.interfaces.IUserRmi;

public class UserStub {
	
	private UserStub() {
		
	}
	
	public static IUserRmi getStub() throws Exception {
		
		try {
			IUserRmi stubUser=(IUserRmi) Naming.lookup("userService");
			return stubUser;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new Exception("Erreur de récupération du Stub");
	}
	
	

}
