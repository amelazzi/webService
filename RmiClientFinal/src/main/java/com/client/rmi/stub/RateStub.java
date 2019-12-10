package com.client.rmi.stub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.server.rmi.interfaces.IProductRmi;
import com.server.rmi.interfaces.IRateRmi;
import com.server.rmi.interfaces.IUserRmi;

public class RateStub {
	
	private RateStub() {
		
	}
	
	public static IRateRmi getStub() throws Exception {
		
		try {
			IRateRmi stubRate=(IRateRmi) Naming.lookup("rateService");
			return stubRate;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new Exception("Erreur de récupération du Stub");
	}
	
	

}
