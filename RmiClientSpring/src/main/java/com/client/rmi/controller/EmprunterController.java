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
	public String index(Locale locale, Model model) {
		List<Emprunt> emprunts=new ArrayList<Emprunt>();
		
		model.addAttribute("emprunts", emprunts);
		return "emprunt/index";
	}
	/*
	@RequestMapping(value = "/emprunter", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		List<UserImpl> users=new ArrayList<UserImpl>();
		try {
			users=UserStub.getStub().findAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		model.addAttribute("users", users );
		return "admin/user/list";
	}
	
	@RequestMapping(value = {"/admin/user/add"}, method = RequestMethod.GET)
	public String add(Locale locale, Model model) throws RemoteException, Exception {
		UserImpl user= new UserImpl();
		
		model.addAttribute("user", user);
		return "admin/user/save";
	}
	
	@RequestMapping(value = {"/admin/user/{id}" }, method = RequestMethod.GET)
	public String detail(Locale locale, Model model, @PathVariable String id) throws RemoteException, Exception {
		UserImpl user = new UserImpl();
		if(null!=id){
			long idUser = Long.parseLong(id);
			user = (UserImpl) UserStub.getStub().findOneById(idUser);
		}else {
			System.out.println("Element introuvable");
			return "redirect:/admin/user/";
		}
		
		model.addAttribute("user", user);
		return "admin/user/details";
	}
	
	@RequestMapping(value = {"/admin/user/{id}/edit" }, method = RequestMethod.GET)
	public String edit(Locale locale, Model model, @PathVariable String id) throws RemoteException, Exception {
		UserImpl user = new UserImpl();
		if(null!=id){
			long idUser = Long.parseLong(id);
			user = (UserImpl) UserStub.getStub().findOneById(idUser);
		}
		
		model.addAttribute("user", user);
		return "admin/user/save";
	}
	
	@RequestMapping(value = {"/admin/user/{id}/delete" }, method = RequestMethod.POST)
	public String delete(Locale locale, Model model, @PathVariable String id) throws RemoteException, Exception {
		UserImpl user = new UserImpl();
		if(null!=id){
			long idUser = Long.parseLong(id);
			user = (UserImpl) UserStub.getStub().findOneById(idUser);
			UserStub.getStub().remove(user);
		}
		
		return "redirect:/admin/user/";
	}
	
	@RequestMapping(value = "/admin/user/save", method = RequestMethod.POST)
	public String save(Locale local, Model model, UserImpl user) throws RemoteException, Exception {
		if(user!=null) {
			user.setPassword("password");
			if(user.getIdUser()!=0L) {
				UserStub.getStub().update(user);
			}else {
				UserStub.getStub().add(user);
			}
		}
		
		model.addAttribute("user", user);
		return "redirect:/admin/user/";
	}
	
	@InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
    }
	*/
	
}
