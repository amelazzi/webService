package com.client.rmi.stub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.server.rmi.interfaces.INotificationRmi;

public class NotificationStub {
	private NotificationStub() {
		
	}
	
	public static INotificationRmi getStub() throws Exception {
		
		try {
			INotificationRmi stubNotification=(INotificationRmi) Naming.lookup("notificationService");
			return stubNotification;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new Exception("Erreur de récupération du Stub");
	}

}
