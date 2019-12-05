package com.client.servlet.product;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.client.rmi.ProductStub;
import com.client.utils.FileManager;
import com.client.utils.FlickrService;
import com.server.entities.impl.Product;
import com.server.utils.DateTool;
import com.server.utils.EncodeSha;

/**
 * Servlet implementation class PersistProduct
 */
<<<<<<< HEAD:RmiClient/src/com/client/servlet/product/_PersistProduct.java
@WebServlet("/product/persist")
public class _PersistProduct extends HttpServlet {
=======
@WebServlet("/essting/product/persist")
public class PersistProduct extends HttpServlet {
>>>>>>> 8bc73530bbcd5d72ba63061d77363c05d0974350:RmiClient/src/com/client/servlet/product/PersistProduct.java
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public _PersistProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Product product = new Product();
		
		
		/*try {
			if(product.getIdProduct()==0L)
				ProductStub.getStub().add(product);
			else
				ProductStub.getStub().update(product);
			System.out.println("done");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error");
			e.printStackTrace();
		}*/
		
		request.setAttribute("product", product);
		request.getRequestDispatcher( "/WEB-INF/views/product/persistence.jsp" ).forward( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long id=Long.parseLong(request.getParameter("idProduct"));
		Product product = null;
		if(id!=0L) {
			product = new Product();
		}else {
			try {
				product = (Product) ProductStub.getStub().findOneById(id);
			} catch (Exception e) {
				//Message d'erreur
			}
		}
		
		product=this.parseData(request, product);
		
		request.setAttribute("product", product);
		
		try {
			if(product.getIdProduct()!=0L) {
				ProductStub.getStub().update(product);
			}else {
				ProductStub.getStub().add(product);
			}
			
			request.getRequestDispatcher( "/WEB-INF/views/product/list.jsp" ).forward( request, response );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}
	
	private Product parseData(HttpServletRequest request, Product product) throws IOException, ServletException {
		product.setTitle(request.getParameter("title"));
		boolean available = request.getParameter("available")=="1"?true:false;
		product.setAvailable(available);
		product.setDescription(request.getParameter("description"));
		product.setPrice(Float.parseFloat(request.getParameter("title")));
		product.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		Date createdAt = DateTool.stringToDate(request.getParameter("description"));
		product.setCreatedAt(createdAt);
		
		Part file = request.getPart("image");
		String image =null;
		if(file!=null) {
			image=FileManager.upload(file);
		}
		
		product.setImage(image);
		return product;
	}

}
