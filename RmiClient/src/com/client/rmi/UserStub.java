package com.client.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import com.server.rmi.interfaces.IProductRmi;
import com.server.rmi.interfaces.IUserRmi;

public class UserStub {
	
	private UserStub() {
		
	}
	
	public static IUserRmi getStub() throws Exception {
		try {
			IUserRmi stubUser=(IUserRmi) Naming.lookup("rmi://localhost:1099/userService");
			return stubUser;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
		throw new Exception("Erreur de récupération du Stub");
	}
	
	

}
