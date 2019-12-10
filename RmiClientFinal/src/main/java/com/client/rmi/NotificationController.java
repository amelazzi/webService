package com.client.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.client.rmi.stub.DemandeStub;
import com.client.rmi.stub.NotificationStub;
import com.server.entities.impl.Demande;
import com.server.entities.impl.Notification;
import com.server.entities.impl.UserImpl;

@Controller
public class NotificationController {
	public NotificationController() {}
	
	@RequestMapping(value = "/notification", method = RequestMethod.GET)
	public String index(Locale locale, Model model, HttpServletRequest request) throws RemoteException, Exception {
		HttpSession httpSession = request.getSession();
		
		UserImpl user = new UserImpl();
		if(httpSession.getAttribute("user")==null) {
			return "redirect:/";
		}
		
		user = (UserImpl) httpSession.getAttribute("user");
		
		List<Demande> demandes = new ArrayList<Demande>();
		demandes = DemandeStub.getStub().findBy("iduser", user.getIdUser());
		
		List<Notification> notifications = new ArrayList<Notification>();
		try {
			for(Demande d: demandes) {
				notifications.add((Notification)NotificationStub.getStub().findBy("idDemande", d.getIdDemande()));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		model.addAttribute("notifications", notifications);
		return "notification/index";
	}
}
