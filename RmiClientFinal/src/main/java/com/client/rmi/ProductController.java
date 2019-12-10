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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.client.rmi.stub.CommentStub;
import com.client.rmi.stub.ProductStub;
import com.client.rmi.stub.RateStub;
import com.client.utils.FileManager;
import com.server.entities.impl.Comment;
import com.server.entities.impl.Product;
import com.server.entities.impl.Rate;
import com.server.entities.impl.UserImpl;

@Controller
public class ProductController {
	
	@RequestMapping(value = "/admin/product", method = RequestMethod.GET)
	public String index(Locale locale, Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			System.out.println("Vous devez être connecté");
			return "redirect:/";
		}
		
		
		List<Product> produits=new ArrayList<Product>();
		try {
			produits=ProductStub.getStub().findAll();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		model.addAttribute("products", produits);
		return "admin/product/list";
	}
	
	@RequestMapping(value = {"/admin/product/add"}, method = RequestMethod.GET)
	public String add(Locale locale, Model model, HttpServletRequest request) throws RemoteException, Exception {
		Product product = new Product();
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			System.out.println("Vous devez être connecté");
			return "redirect:/";
		}
		
		model.addAttribute("product", product);
		return "admin/product/save";
	}
	
	@RequestMapping(value = {"/product/{id}" }, method = RequestMethod.GET)
	public String detail(Locale locale, Model model, @PathVariable String id, HttpServletRequest request) throws RemoteException, Exception {
		HttpSession session=request.getSession();
		Product product = new Product();
		Comment comment = new Comment();
		UserImpl user=new UserImpl();
		Rate rate = new Rate();
		
		
		if(session.getAttribute("user")==null) {
			session.setAttribute("error_msg", "Vous devez être connecté");
			return "redirect:/";
		}
		
		user=(UserImpl) session.getAttribute("user");
		
		List<Comment> comments = new ArrayList<Comment>();
		if(null!=id){
			long idProduct = Long.parseLong(id);
			product = (Product) ProductStub.getStub().findOneById(idProduct);
			rate.setProduct(product);
			comments = CommentStub.getStub().findAll();			
		}else {
			System.out.println("Element introuvable");
			return "redirect:/home";
		}
		
		model.addAttribute("rate", rate);
		model.addAttribute("user", user);
		model.addAttribute("comment", comment);
		model.addAttribute("product", product);
		model.addAttribute("comments", comments);
		
		return "admin/product/details";
	}
	
	@RequestMapping(value = {"/admin/product/{id}/edit" }, method = RequestMethod.GET)
	public String edit(Locale locale, Model model, @PathVariable String id, HttpServletRequest request) throws RemoteException, Exception {
		Product product = new Product();
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			System.out.println("Vous devez être connecté");
			return "redirect:/";
		}
		
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
	public String save(Locale local, Model model, Product product, @RequestParam("photo") MultipartFile file) throws RemoteException, Exception {
		if(product!=null) {
			String urlPhoto="https://farm66.static.flickr.com/65535/49185014886_2998070a66_z.jpg";
			if (!file.isEmpty() && file!=null) {
				urlPhoto=FileManager.upload(file);
			}
			product.setImage(urlPhoto);
			int max =(product.getDescription().length()<254)?product.getDescription().length():254;
			product.setDescription(product.getDescription().substring(0, max));
			if(product.getIdProduct()!=0L) {
				ProductStub.getStub().update(product);
			}else {
				ProductStub.getStub().add(product);
			}
		}
		
		model.addAttribute("product", product);
		return "redirect:/admin/product/";
	}
	
	@RequestMapping(value = "/rating", method = RequestMethod.POST)
	public String rating(Locale local, Model model, 
			@RequestParam("rateValue") String rateValue, 
			@RequestParam("photo") String idProduct) throws RemoteException, Exception {
		
		Product product = new Product();
		Rate rate = new Rate();
		
		if(null!=idProduct){
			long idP= Long.parseLong(idProduct);
			product = (Product) ProductStub.getStub().findOneById(idP);
			ProductStub.getStub().remove(product);
			if(rateValue!=null) {
				rate.setProduct(product);
				rate.setValue(Integer.parseInt(rateValue));
				RateStub.getStub().add(rate);
			}
		}
		
		return "redirect:/product/"+idProduct;
	}

	
}
