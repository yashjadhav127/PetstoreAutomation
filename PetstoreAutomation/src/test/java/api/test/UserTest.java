package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.payload.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTest {
	
	Faker faker;
	
	User user;
	
   @BeforeClass
   public void setupData() {
	
	  
	  
	  faker=new Faker();
	  
	  user= new User();
	  
	  user.setId(faker.idNumber().hashCode());
	  user.setFirstName(faker.name().firstName());
	  user.setLastName(faker.name().lastName());
	  user.setUsername(faker.name().username());
	  user.setEmail(faker.internet().emailAddress());
	  user.setPassword(faker.internet().password(true));
	  user.setPhone(faker.phoneNumber().phoneNumber());
	  
  }
   
   
   
    @Test(priority=2)
    public void testpostUser() {
	  
	  Response response = Userendpoints.CreateUser(user);
	  
	  Assert.assertEquals(response.getStatusCode(),200);
	  
	  response.then().log().all();
	 
	 
	 }
    
    
    
    @Test(priority=3)
    public  void testgetuser() {
    	
    	Response response=Userendpoints.readUser(user.getUsername());
    	
    	Assert.assertEquals(response.getStatusCode(), 200 );
    	
    	response.then().log().all();
    	
    }
    
    
    
    @Test(priority=4)
    public void testupdateuser() {
    	
    	Response response= Userendpoints.updateUser(user.getUsername(),user);
    	
    	
    	Assert.assertEquals(response.getStatusCode(), 200 );
    	
    	
    	response.then().log().all();
    
    	
    }
    
    
    
    @Test(priority=5)
    public void testdeleteuser() {
    	
    	Response response = Userendpoints.deleteUser(user.getUsername());
    	
    	
    	Assert.assertEquals(response.getStatusCode(), 200 );
    	
    	
    	response.then().log().all();
    	
    }
   
   
	


}
