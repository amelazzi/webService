package com.client.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.client.rmi.UserStub;
import com.server.entities.impl.UserImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//errors="Erreur";
		//request.setAttribute("errors", errors);
		request.getRequestDispatcher( "/WEB-INF/views/register.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserImpl user=new UserImpl();
		user.setEmail((String) request.getParameter("email"));
		user.setFirstName((String) request.getParameter("firstname"));
		user.setLastName((String) request.getParameter("lastname"));
		user.setPassword((String)  request.getParameter("password"));
		String confirm=(String) request.getParameter("confirm");
		String errors=null;
		String success=null;
		System.out.println(user.toString());
		if(!confirm.isEmpty()&&user.getPassword().equals(confirm)) {
			try {
				//UserStub.getStub().add(user);
				success="Incription reussi veuillez vous connecter avec vos identifiants";
				request.setAttribute("success_msg", success);
				response.sendRedirect( request.getContextPath()+"/login");
			} catch (Exception e) {
				errors="Erreur de connexion, le serveur ne repond pas";
				request.setAttribute("error_msg", errors);
				e.printStackTrace();
			}
		}else {
			errors="Erreur de connexion, les mot de passe ne sont pas confirmes";
			request.setAttribute("user", user);
			request.setAttribute("error_msg", errors);
			
			doGet(request, response);
		}
		
	}
	

}
