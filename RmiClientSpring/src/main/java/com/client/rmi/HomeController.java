package com.client.rmi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.client.i18n.Internationnalization;
import com.client.rmi.stub.ProductStub;
import com.server.entities.impl.Product;

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
	public String register(Locale locale, Model model) {
		
		return "register";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<Product> produits=new ArrayList<Product>();
		try {
			produits=ProductStub.getStub().findAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		model.addAttribute("products", produits );
		
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
