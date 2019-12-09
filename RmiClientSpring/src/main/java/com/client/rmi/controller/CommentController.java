package com.client.rmi.controller;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.rmi.stub.ProductStub;
import com.client.rmi.stub.UserStub;
import com.server.entities.impl.Comment;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;

@Controller
public class CommentController {
	
	@RequestMapping(value = {"/comment/add"}, method = RequestMethod.GET)
	public String add(Locale locale, Model model, Comment comment, 
			@RequestParam("idUser") String idUser,  
			@RequestParam("idProduct") String idProduct,
			@RequestParam("content") String content) throws RemoteException, Exception {
		Product product =new Product();
		UserImpl user = new UserImpl();
		
		if(null==idProduct && idUser==null){
			System.out.println("Impossible d'ajouter un commentaire, utilisateur ou produit inconnu");
			return "redirect:/";
		}
		
		long idP = Long.parseLong(idProduct);
		product = (Product) ProductStub.getStub().findOneById(idP);
		
		long idU = Long.parseLong(idUser);
		user = (UserImpl) UserStub.getStub().findOneById(idU);
		
		
		comment.setProduct(product);
		comment.setUser(user);
		comment.setContent(content.substring(0, 254));
		
		System.out.print("comment: " + comment.toString());
		
		
		model.addAttribute("comment", comment);
		return "redirect:/product/"+idProduct;
	}
	

}
