package test;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.server.entities.impl.Emprunt;
import com.server.entities.impl.Product;
import com.server.entities.impl.UserImpl;
import com.server.service.impl.ProductService;
import com.server.service.impl.UserService;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws RemoteException {
		UserService service = new UserService();

		UserImpl user = new UserImpl();
		user.setEmail("ea_azzi@esi.dz");
		user.setPassword("amel");

		System.out.println("*** Persist - start ***");
		service.save(user);
		System.out.println("*** User Saved ***");
		/*
		 * ProductService service = new ProductService();
		 * 
		 * UserService userService = new UserService();
		 * 
		 * EmpruntService empruntService = new EmpruntService();
		 * 
		 * /*Product product1 = new Product(); product1.setTitle("Livre Java");
		 * product1.setQuantity(5); product1.setPrice(23);
		 * product1.setDescription("ceci est une description du produit");
		 * product1.setAvailable(true);
		 * 
		 * Product product2 = new Product(); product2.setTitle("Livre C");
		 * product2.setQuantity(5); product2.setPrice(23);
		 * product2.setDescription("ceci est une description du produit");
		 * product2.setAvailable(true);
		 * 
		 * Product product3 = new Product(); product3.setTitle("Livre Python");
		 * product3.setQuantity(5); product3.setPrice(23);
		 * product3.setDescription("ceci est une description du produit");
		 * product3.setAvailable(true);
		 * 
		 * 
		 * System.out.println("*** Persist - start ***"); service.save(product1);
		 * service.save(product2); service.save(product3);
		 */

		/*
		 * System.out.println("*** select all***"); List<Product> products = new
		 * ArrayList<Product>(); products = service.findAll();
		 * System.out.println("Products Persisted are :"); for (Product p : products) {
		 * System.out.println("-" + p.toString()); }
		 */

		/*
		 * System.out.println("*** select one***"); Product produit =
		 * service.findOneById((long) 1); System.out.println("-"+produit.toString());
		 */

		UserImpl user = new UserImpl();
		user.setBirthday(new Date());
		user.setDomain("Informatique");
		user.setEmail("user@mail.com");
		user.setFirstName("Diallo");
		user.setLastName("Mamadou");
		user.setGraduate("Master2");
		user.setMatricule(1234);
		EncodeSha hash = new EncodeSha();
		user.setPassword(hash.getHash("password"));
		user.setPhone("0612345678");

		userService.save(user);

		Product produit = service.findOneById((long) 1);

		empruntService.emprunter(produit, user);

		System.out.println("*** select all emprunt***");
		List<Emprunt> emprunts = new ArrayList<Emprunt>();
		emprunts = empruntService.findAll();
		System.out.println("Emprunts persisted are :");
		for (Emprunt e : emprunts) {
			System.out.println("-" + e.toString());
		}

	}

}
