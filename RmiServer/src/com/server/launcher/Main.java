package com.server.launcher;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import com.server.entities.interfaces.IEmprunt;
import com.server.rmi.impl.*;
import com.server.rmi.interfaces.*;

public class Main {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			
			IProductRmi productRmiService = new ProductRmi();
			Naming.rebind("productService", productRmiService);

			IUserRmi userRmiService = new UserRmi();
			Naming.bind("userService", userRmiService);

			IEmpruntRmi empruntRmiService = new EmpruntRmi();
			Naming.rebind("empruntService", empruntRmiService);

			IDemandeRmi demandeRmiService = new DemandeRmi();
			Naming.rebind("demandeService", demandeRmiService);

			ICommentRmi commentRmiService = new CommentRmi();
			Naming.rebind("commentService", commentRmiService);

			IRateRmi rateRmiService = new RateRmi();
			Naming.rebind("rateService", rateRmiService);

			INotificationRmi notificationRmiService = new NotificationRmi();
			Naming.rebind("notificationService", notificationRmiService);


			System.out.print("Server OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
