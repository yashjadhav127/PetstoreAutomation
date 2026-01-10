package api.endpoints;

import io.restassured.response.Response;


import static  io.restassured.RestAssured.*;
import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

import api.payload.User;

import static api.endpoints.Routes.*;

public class Userendpoints {
	
	
	public static Response CreateUser(User user) {
		
		Response res= given()
						.contentType("application/json")
				    	.body(user)
				    	.when()
				    .post(post_url);
				    
				
		return res;
		
	}
	
	
	public static Response readUser(String username) {
		
		
		Response res=given()
						.contentType("application/json")
						.pathParams("username", username)
					.when()
						.get(Routes.get_url);
		
		
		return res;
		
		
		
	}
	
	
	public static Response updateUser(String username,User user) {
		
		Response res= given()
							.contentType("application/json")
							.pathParam("username",username)
							.body(user)
					  .when()
					  		.put(Routes.update_url);
	    return res;
		
		
		
	}
	
	
	public static Response deleteUser(String username) {
		
		Response res= given()
				.contentType("application/json")
				.pathParam("username",username)
		  .when()
		  		.delete(Routes.delete_url);
       
		return res;
		
	}

}
