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
		TestAdd();
		//testLoginCheck("ea_azzi@esi.dz","amel");
		
	}
	
	public static boolean testLoginCheck(String email, String password) {
		return userService.checkLogin(email, password);
	}
	
	public static void TestAdd() {
		UserImpl user = new UserImpl();
		user.setBirthday(new Date());
		user.setDomain("Informatique");
		user.setEmail("amel@mail.com");
		user.setFirstName("Azzi");
		user.setLastName("amel");
		user.setGraduate("Master2");
		user.setMatricule(1234);
		user.setPassword(EncodeSha.getHash("password"));
		user.setPhone("0669573582");
		
		userService.add(user);
        
        //TestSelectAll();
	}
	
	public static String TestSelectAll(){
	      List<UserImpl> listUserImpls=userService.findAll();
		  displayMany(listUserImpls);
	      return "success";
	      
	}
	
	public static String TestUpdate(){
	      List<UserImpl> listUserImpls=userService.findAll();
	      for (UserImpl u : listUserImpls) {
		        u.setBirthday(new Date());
		        userService.update(u);
		  }
	      
	      listUserImpls=userService.findAll();
	      displayMany(listUserImpls);
	      
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
