package com.client.rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.i18n.Internationnalization;
import com.client.rmi.stub.ProductStub;
import com.client.rmi.stub.UserStub;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model, UserImpl user) {
		
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(Locale locale, Model model, UserImpl user, HttpServletRequest request) {
		HttpSession session = request.getSession();
        session.invalidate();
		
		model.addAttribute("user", user);
		return "index";
	}
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(Locale local, Model model, UserImpl user, 
			@RequestParam("password") String password, HttpServletRequest request) throws RemoteException, Exception {
		HttpSession session = request.getSession();
		String errors=null;
		if(user.getEmail() !=null && !user.getEmail().isEmpty()) {
			if(password !=null && !password.isEmpty()) {
				try {
					if(UserStub.getStub().login(user.getEmail(), password)) {
						List<UserImpl> users = (List<UserImpl>) UserStub.getStub().findBy("email",user.getEmail());
						user=users.get(0);
						session.setAttribute("user", user);
						return "redirect:/home";
					}else {
						session.setAttribute("user", null);
						errors="Erreur identifiant incorrecte, vérifier votre email et mot de passe";
					}
				} catch (Exception e) {
					errors=e.getMessage();
					e.printStackTrace();
				}
			}
		}else{
			errors="Erreur de connexion, l'eamil et le mot de passe ne doivent pas être vide";
		}
		
		session.setAttribute("user", user);
		model.addAttribute("error_msg",errors);
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model, UserImpl user) {
		
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Locale local, Model model, UserImpl user, 
			@RequestParam("confirm") String confirm, HttpServletRequest request) throws RemoteException, Exception {
		String errors=null;
		String success=null;
		
		if(user!=null) {
			user.setBirthday(new Date());
			user.setGraduate("non defini");
			user.setMatricule(99999);
			user.setPhone("non défini");
			user.setRole("user");
			user.setStatus("student");
			user.setDomain("non defini");
			
			model.addAttribute("user", user);
			
			if(!confirm.isEmpty()&&user.getPassword().equals(confirm)) {
				if(UserStub.getStub().findBy("email", user.getEmail()).size()>0) {
					errors="Erreur d'inscription, cette adresse email existe déjà";
					request.setAttribute("error_msg", errors);
					return "register";
				}
				
				try {
					request.setAttribute("success_msg", success);
					UserStub.getStub().add(user);
					success="Incription reussi veuillez vous connecter avec vos identifiants";
					request.setAttribute("success_msg", success);
					return "redirect:/";
				} catch (Exception e) {
					errors=e.getMessage();
					request.setAttribute("error_msg", errors);
					e.printStackTrace();
				}
				
			}else {
				errors="Erreur d'inscription, les mot de passe ne sont pas confirmes";
				request.setAttribute("error_msg", errors);
			}
			
		}
		
		return "register";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Product> products=new ArrayList<Product>();
		try {
			products=ProductStub.getStub().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("products", products );
		
		return "home";
	}
	
	@RequestMapping(value = {"/langue/{l}" }, method = RequestMethod.GET)
	public String changelocal(Locale locale, Model model,@PathVariable String l, HttpServletRequest request, HttpServletResponse response) {
		String local= l;
		if(!local.isEmpty()) {
			Internationnalization.changeLocal(request, response, local);
		}
		String referer = request.getHeader("Referer");
		return "redirect:"+referer;
	}
	
}
