package com.client.servlet.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.client.rmi.ProductStub;
import com.server.entities.impl.Product;

/**
 * Servlet implementation class PersistProduct
 */
@WebServlet("/product/persist")
public class PersistProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersistProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product product1 = new Product();
		product1.setIdProduct(16);
		product1.setTitle("Livre React");
		product1.setQuantity(5);
		product1.setPrice(18);
		product1.setDescription("ceci est une description du produit");
		product1.setAvailable(false);
		
		try {
			if(product1.getIdProduct()==0L)
				ProductStub.getStub().add(product1);
			else
				ProductStub.getStub().update(product1);
			System.out.println("done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
