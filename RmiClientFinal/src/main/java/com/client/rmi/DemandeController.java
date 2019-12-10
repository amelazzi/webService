package com.client.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.client.rmi.stub.DemandeStub;
import com.client.rmi.stub.NotificationStub;
import com.client.rmi.stub.ProductStub;
import com.server.entities.impl.Demande;
import com.server.entities.impl.Notification;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;

@Controller
public class DemandeController {
	public DemandeController() {}
	
	@RequestMapping(value = "/demande", method = RequestMethod.GET)
	public String index(Locale locale, Model model, HttpServletRequest request) throws RemoteException, Exception {
		HttpSession httpSession = request.getSession();
		
		UserImpl user = new UserImpl();
		if(httpSession.getAttribute("user")==null) {
			return "redirect:/";
		}
		
		user = (UserImpl) httpSession.getAttribute("user");
		
		List<Demande> demandes = new ArrayList<Demande>();
		demandes = DemandeStub.getStub().findBy("iduser", user.getIdUser());
		
		model.addAttribute("demandes", demandes);
		return "demande/index";
	}
	
	@RequestMapping(value = "/admin/demande", method = RequestMethod.GET)
	public String list(Locale locale, Model model, HttpServletRequest request) throws RemoteException, Exception {
		HttpSession httpSession = request.getSession();
		
		if(httpSession.getAttribute("user")==null) {
			return "redirect:/";
		}
		
		List<Demande> demandes = new ArrayList<Demande>();
		demandes = DemandeStub.getStub().findAll();
		
		model.addAttribute("demandes", demandes);
		return "admin/demande/list";
	}
	
	@RequestMapping(value ="/demande/cancel/{idDemande}", method = RequestMethod.GET)
	public String cancel(Locale locale, Model model, HttpServletRequest request, @PathVariable String idDemande) {
		if(null!=idDemande){
			Demande demande=new Demande();
			long idD = Long.parseLong(idDemande);
			try {
				demande = (Demande) DemandeStub.getStub().findOneById(idD);
				demande.setIsDone(true);
				DemandeStub.getStub().update(demande);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return "redirect:/demande";
	}
}
