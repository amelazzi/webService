package test;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;


import com.server.dao.impl.UserDaoImpl;
import com.server.entities.impl.UserImpl;
import com.server.service.impl.UserService;
import com.server.utils.EncodeSha;


public class TestUser
{	
	
	static UserService userService = new UserService();
	static UserDaoImpl userDao = new UserDaoImpl();
	
	public static void main(String[] args) throws RemoteException {
		//TestSelectAll();
		//TestUpdate();
		//TestAdd();
		//userService.delete(userService.findOneById(2L));
		//testLoginCheck("ea_azzi@esi.dz","amel");
		//userService.findAll();
		//displayMany(userService.findAll());
		displayOne(userService.findOneById(4L));
		//System.out.println("max id: " + userDao.getMaxId());
		
	}
	
	public static boolean testLoginCheck(String email, String password) {
		return userService.checkLogin(email, password);
	}
	
	public static void TestAdd() {
		UserImpl user = new UserImpl();

		user.setBirthday(new Date());
		user.setDomain("Sport");
		user.setEmail("adel@mail.com");
		user.setFirstName("bob");
		user.setLastName("mastigas");
		user.setGraduate("M2");
		user.setMatricule(1901);
		user.setPassword(EncodeSha.getHash("pwd"));
		user.setPhone("0646702698");
		user.setStatus("teacher");

		UserImpl user2 = new UserImpl();

		user2.setBirthday(new Date());
		user2.setDomain("SSIO");
		user2.setEmail("faycal@mail.com");
		user2.setFirstName("amel");
		user2.setLastName("azzi");
		user2.setGraduate("M2");
		user2.setMatricule(1806);
		user2.setPassword(EncodeSha.getHash("pwd"));
		user2.setPhone("0669573582");
		user2.setStatus("student");

		UserImpl user3 = new UserImpl();

		user3.setBirthday(new Date());
		user3.setDomain("SSIO");
		user3.setEmail("sadia@mail.com");
		user3.setFirstName("mamadou");
		user3.setLastName("hassimiou");
		user3.setGraduate("M2");
		user3.setMatricule(1806);
		user3.setPassword(EncodeSha.getHash("pwd"));
		user3.setPhone("0669573582");
		user3.setStatus("student");
		
		userService.add(user);
		userService.add(user2);
		userService.add(user3);
        
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
