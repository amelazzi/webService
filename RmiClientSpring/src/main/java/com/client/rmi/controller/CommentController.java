package com.client.rmi.controller;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.server.entities.impl.Comment;

@Controller
public class CommentController {
	
	@RequestMapping(value = {"/comment/add"}, method = RequestMethod.GET)
	public String add(Locale locale, Model model, Comment comment) throws RemoteException, Exception {
		System.out.print("comment: " + comment.toString());
		model.addAttribute("comment", comment);
		return "redirect:/home";
	}
	

}
