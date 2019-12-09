package com.client.rmi.controller;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.rmi.stub.EmpruntStub;
import com.client.rmi.stub.ProductStub;
import com.client.rmi.stub.UserStub;
import com.server.entities.impl.Emprunt;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
import com.server.entities.interfaces.IEmprunt;

@Controller
public class EmprunterController {
	@RequestMapping(value = "/emprunter/{idproduct}", method = RequestMethod.GET)
	public String confirmation(Locale locale, Model model, HttpServletRequest request, @PathVariable String idproduct) {
		HttpSession session = request.getSession();
		UserImpl user=null;
		Product product = null;
		Emprunt emprunt = new Emprunt();
		
		if(session.getAttribute("user")==null) {
			System.out.println("Vous devez être connecté");
			return "redirect:/";
		}
				
		if(null!=idproduct){
			long idP = Long.parseLong(idproduct);
			long idUser = ((UserImpl) session.getAttribute("user")).getIdUser();
			try {
				product = (Product) ProductStub.getStub().findOneById(idP);
				user= (UserImpl) UserStub.getStub().findOneById(idUser);
				emprunt.setProduct(product);
				emprunt.setUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Vous devez selectionner un produit");
			return "redirect:/home";
		}
		
		model.addAttribute("product",product);
		model.addAttribute("user",user);
		model.addAttribute("emprunt",emprunt);
		System.out.println(emprunt.toString());
		
		return "emprunt/confirm";
	}
	
	@RequestMapping(value = "/emprunt/save", method = RequestMethod.POST)
	public String save(Locale local, Model model, Emprunt emprunt, @RequestParam("idProduct") String idProduct, @RequestParam("idUser") String idUser) throws RemoteException, Exception {
		Product product = null;
		UserImpl user=null;
		String error_msg=null;
		
		EmpruntStub.getStub().add(emprunt);
		if(null!=idProduct && idUser!=null){
			long idP = Long.parseLong(idProduct);
			long idU = Long.parseLong(idUser);
			try {
				product = (Product) ProductStub.getStub().findOneById(idP);
				user= (UserImpl) UserStub.getStub().findOneById(idU);
				emprunt.setProduct(product);
				emprunt.setUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(emprunt.toString());
			System.out.println("Produit of emprunt: "+ emprunt.getProduct());
			System.out.println("User of emprunt: "+ emprunt.getUser());
		}
		
		if(user!=null && product!=null) {
			try {
				EmpruntStub.getStub().emprunter(product, user);
				return "redirect:/emprunt";
			} catch (Exception e) {
				error_msg=e.getMessage();
				model.addAttribute("error_msg", error_msg);
			}
			
		}
		
		model.addAttribute("user", user);
		model.addAttribute("product", product);
		model.addAttribute("emprunt", emprunt);
		return "emprunt/confirm";
	}
	
	@RequestMapping(value = "/emprunt", method = RequestMethod.GET)
	public String index(Locale locale, Model model, HttpServletRequest request) {
		List<Emprunt> emprunts=new ArrayList<Emprunt>();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")==null) {
			System.out.println("Vous devez être connecté");
			return "redirect:/";
		}
		
		UserImpl user= (UserImpl) session.getAttribute("user");
		try {
			emprunts=EmpruntStub.getStub().findByUser(user.getIdUser());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("emprunts", emprunts);
		return "emprunt/index";
	}
	
	@RequestMapping(value = "/admin/emprunt", method = RequestMethod.GET)
	public String listAll(Locale locale, Model model, HttpServletRequest request) {
		List<Emprunt> emprunts=new ArrayList<Emprunt>();
		HttpSession session=request.getSession();
		
		if(session.getAttribute("user")==null) {
			/*UserImpl user= (UserImpl) session.getAttribute("user");
			if(user.getRole()!="admin") {
				System.out.println("Vous avez pas les droits d'admin");
				return "redirect:/home";
			}*/
			System.out.println("Vous devez être connecté");
			return "redirect:/";
		}
		
		try {
			emprunts=EmpruntStub.getStub().findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("emprunts", emprunts);
		return "admin/emprunt/list";
	}
	
	@RequestMapping(value = "/emprunt/restitution/{idEmprunt}", method = RequestMethod.GET)
	public String restituer(Locale locale, Model model, HttpServletRequest request, @PathVariable String idEmprunt) {
		Emprunt emprunt=new Emprunt();
		String error_msg=null;
		String succes_msg=null;
		if(idEmprunt!=null){
			long id=Long.parseLong(idEmprunt);
			
			try {
				emprunt = (Emprunt) EmpruntStub.getStub().findOneById(id);
				System.out.println(emprunt);
				if(EmpruntStub.getStub().restituer(emprunt)) {
					succes_msg="Restitution effectuée avec succes";
				}else {
					error_msg="Une erreur s'est produite lors de la restitution";
				}
			} catch (Exception e) {
				error_msg=e.getMessage();
				e.printStackTrace();
			}
		}
		
		model.addAttribute("errors_msg",error_msg);
		model.addAttribute("success_msg",succes_msg);
		return "redirect:/emprunt";
	}
	
}
