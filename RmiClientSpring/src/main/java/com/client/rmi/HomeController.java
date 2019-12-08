package com.client.rmi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.UserException;
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
	public String index(Locale locale, Model model) {
		
		return "index";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Locale locale, Model model, UserImpl user) {
		//UserImpl user= new UserImpl();
		
		model.addAttribute("user", user);
		return "register";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Locale local, Model model, UserImpl user, 
			@RequestParam("confirm") String confirm, HttpServletRequest request) {
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
			
			if(!confirm.isEmpty()&&user.getPassword().equals(confirm)) {
				try {
					System.out.println("Identique");
					request.setAttribute("success_msg", success);
					//UserStub.getStub().add(user);
					success="Incription reussi veuillez vous connecter avec vos identifiants";
					request.setAttribute("success_msg", success);
					//return "redirect:/";
				} catch (Exception e) {
					errors=e.getMessage();
					request.setAttribute("error_msg", errors);
					e.printStackTrace();
				}
				
			}else {
				errors="Erreur de connexion, les mot de passe ne sont pas confirmes";
				request.setAttribute("error_msg", errors);
			}
			
		}
		System.out.println("Registratio, "+user);
		return "/register";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Product> products=new ArrayList<Product>();
		try {
			products=ProductStub.getStub().findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(Product p:products) {
			System.out.println(p.toString());
		}
		model.addAttribute("products", products );
		
		return "home";
	}
	
	@RequestMapping(value = {"/langue/{l}" }, method = RequestMethod.POST)
	public String changelocal(Locale locale, Model model,@PathVariable String l, HttpServletRequest request, HttpServletResponse response) {
		String local= l;
		if(!local.isEmpty()) {
			Internationnalization.changeLocal(request, response, local);
		}
		String referer = request.getHeader("Referer");
		return "redirect:"+referer;
	}
	
}
