package com.client.rmi.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.rmi.stub.ProductStub;
import com.server.entities.impl.Product;

@Controller
public class ProductController {
	
	@RequestMapping(value = "/admin/product", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		List<Product> produits=new ArrayList<Product>();
		try {
			produits=ProductStub.getStub().findAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		model.addAttribute("products", produits );
		return "admin/product/list";
	}
	
	@RequestMapping(value = {"/admin/product/add"}, method = RequestMethod.GET)
	public String add(Locale locale, Model model) throws RemoteException, Exception {
		Product product = new Product();
		
		model.addAttribute("product", product);
		return "admin/product/save";
	}
	
	@RequestMapping(value = {"/admin/product/{id}" }, method = RequestMethod.GET)
	public String detail(Locale locale, Model model, @PathVariable String id) throws RemoteException, Exception {
		Product product = new Product();
		if(null!=id){
			long idProduct = Long.parseLong(id);
			product = (Product) ProductStub.getStub().findOneById(idProduct);
		}else {
			System.out.println("Element introuvable");
			return "redirect:/admin/product/";
		}
		
		model.addAttribute("product", product);
		return "admin/product/details";
	}
	
	@RequestMapping(value = {"/admin/product/{id}/edit" }, method = RequestMethod.GET)
	public String edit(Locale locale, Model model, @PathVariable String id) throws RemoteException, Exception {
		Product product = new Product();
		if(null!=id){
			long idProduct = Long.parseLong(id);
			product = (Product) ProductStub.getStub().findOneById(idProduct);
		}
		
		model.addAttribute("product", product);
		return "admin/product/save";
	}
	
	@RequestMapping(value = {"/admin/product/{id}/delete" }, method = RequestMethod.POST)
	public String delete(Locale locale, Model model, @PathVariable String id) throws RemoteException, Exception {
		Product product = new Product();
		if(null!=id){
			long idProduct = Long.parseLong(id);
			product = (Product) ProductStub.getStub().findOneById(idProduct);
			ProductStub.getStub().remove(product);
		}
		
		return "redirect:/admin/product/";
	}
	
	@RequestMapping(value = "/admin/product/save", method = RequestMethod.POST)
	public String save(Locale local, Model model, Product product) throws RemoteException, Exception {
		if(product!=null) {
			product.setImage("https://x.kinja-static.com/assets/images/logos/placeholders/default.png");
			if(product.getIdProduct()!=0L) {
				ProductStub.getStub().update(product);
			}else {
				ProductStub.getStub().add(product);
			}
		}
		
		model.addAttribute("product", product);
		return "redirect:/admin/product/";
	}
	
	
}
