package api.test;

import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DDTest {

	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testpostuser(String userId,String username,String Firstname,String Lastname,String Email,String Password,String Phone) {
		
		User user = new User();
		int id=Integer.parseInt(userId);
		user.setId(id);
		
		user.setUsername(username);
		user.setFirstName(Firstname);
		user.setLastName(Lastname);
		user.setPassword(Password);
		user.setEmail(Email);
		user.setPhone(Phone);
		
		
		Response response = Userendpoints.CreateUser(user);
		  
		Assert.assertEquals(response.getStatusCode(),200);
		  
		
		
	}
	
	
	@Test(priority=2,dataProvider="GetUserName",dataProviderClass=DataProviders.class)
	public void testdeleteuser(String username)
	{
		
		
		Response response = Userendpoints.deleteUser(username);
    	
    	
    	Assert.assertEquals(response.getStatusCode(), 200 );
    	
    	
    	
		
	}
	
	
	
}
