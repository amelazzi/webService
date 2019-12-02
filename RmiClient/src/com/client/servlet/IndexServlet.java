package com.client.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.client.rmi.UserStub;
import com.server.entities.impl.UserImpl;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/login")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String errors=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//errors="Erreur";
		request.setAttribute("error_msg", errors);
		request.getRequestDispatcher( "/WEB-INF/views/index.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) request.getAttribute("email");
		String password=(String) request.getAttribute("password");
		if(email !=null && !email.isEmpty()) {
			if(password !=null && !password.isEmpty()) {
				try {
					UserStub.getStub().login(email, password);
					UserImpl user = (UserImpl) UserStub.getStub().findOneById((long) 1);
					session.setAttribute("user", user);
					response.sendRedirect( request.getContextPath()+"/home");
				} catch (Exception e) {
					errors="Erreur de connexion, le serveur ne repond pas";
					e.printStackTrace();
				}
				errors="Erreur de connexion, le mot de passe ne dois pas être vide";
			}
			errors="Erreur de connexion, le mot de passe ne dois pas être vide";
		}
		request.setAttribute("error_msg", errors);
		doGet(request, response);
	}

}
