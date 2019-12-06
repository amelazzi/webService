package com.client.rmi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
}
