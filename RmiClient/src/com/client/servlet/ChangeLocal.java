package com.client.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import com.client.i18n.Internationnalization;

/**
 * Servlet implementation class ChangeLocal
 */
@WebServlet("/langue")
public class ChangeLocal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeLocal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String goBack = request.getHeader("referer");
		String local= request.getParameter("l");
		if(!local.isEmpty()) {
			Internationnalization.changeLocal(request, response, local);
		}
		
		response.sendRedirect(request.getHeader("referer"));
	}

}
