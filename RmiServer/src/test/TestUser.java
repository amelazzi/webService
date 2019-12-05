package test;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;


import com.server.entities.impl.UserImpl;
import com.server.service.impl.UserService;
import com.server.utils.EncodeSha;


public class TestUser
{	
	
	static UserService userService = new UserService();
	
	public static void main(String[] args) throws RemoteException {
		//TestSelectAll();
		//TestUpdate();
		//TestAdd();
		userService.deleteAll();
		//testLoginCheck("ea_azzi@esi.dz","amel");
		//userService.findAll();
		displayMany(userService.findAll());
		
	}
	
	public static boolean testLoginCheck(String email, String password) {
		return userService.checkLogin(email, password);
	}
	
	public static void TestAdd() {
		UserImpl user = new UserImpl();

		user.setBirthday(new Date());
		user.setDomain("Design");
		user.setEmail("Bob@mail.com");
		user.setFirstName("bob");
		user.setLastName("mastigas");
		user.setGraduate("M2");
		user.setMatricule(1806);
		user.setPassword(EncodeSha.getHash("pwd"));
		user.setPhone("0669573582");
		user.setStatus("teacher");
		
		userService.add(user);
        
        //TestSelectAll();
	}

	public static UserImpl TestSelectAll(){
	      List<UserImpl> listUserImpls=userService.findAll();
		  //displayMany(listUserImpls);
	      return listUserImpls.get(0);
	      
	}
	
	public static String TestUpdate(){
		UserImpl user = new UserImpl();
		user = TestSelectAll();
		System.out.println("id: " + user.getIdUser());
		user.setPhone("0642702698");

		userService.update(user);
		//}

		//listProducts=productService.findAll();
		//displayMany(listProducts);

		return "success";
	      
	   }
	
   
   public static void displayOne(UserImpl demande) {
	   System.out.println("UserImpl :");
	   System.out.println("-" + demande.toString());
   }
   
   public static void displayMany(List<UserImpl> listUserImpls) {
	   System.out.println("UserImpl list :");
	   for (UserImpl d : listUserImpls) {
	        System.out.println("-" + d.toString());
	      }
   }

   
   
}
