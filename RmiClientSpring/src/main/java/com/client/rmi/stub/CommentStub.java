package com.client.rmi.stub;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.server.rmi.interfaces.ICommentRmi;

public class CommentStub {
	
	private CommentStub() {
		
	}
	
	public static ICommentRmi getStub() throws Exception {
		
		try {
			ICommentRmi stubComment=(ICommentRmi) Naming.lookup("commentService");
			return stubComment;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		throw new Exception("Erreur de récupération du Stub");
	}

}
