package com.client.rmi.stub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.server.rmi.interfaces.IDemandeRmi;

public class DemandeStub {

	private DemandeStub() {
		
	}
	
	public static IDemandeRmi getStub() throws Exception {
		
		try {
			IDemandeRmi stubDemande=(IDemandeRmi) Naming.lookup("demandeService");
			return stubDemande;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new Exception("Erreur de récupération du Stub");
	}

}
