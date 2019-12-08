package com.client.rmi.stub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.server.rmi.interfaces.IEmpruntRmi;
import com.server.rmi.interfaces.IProductRmi;
import com.server.rmi.interfaces.IUserRmi;

public class EmpruntStub {
	
	private EmpruntStub() {
		
	}
	
	public static IEmpruntRmi getStub() throws Exception {
		
		try {
			IEmpruntRmi stubEmprunt=(IEmpruntRmi) Naming.lookup("empruntService");
			return stubEmprunt;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new Exception("Erreur de récupération du Stub");
	}
	
	

}
