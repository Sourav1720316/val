package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {

	User userPayload;
		
	@BeforeClass
	public void setup() 
	{
		userPayload=new User();
		userPayload.setId(2);
		userPayload.setUsername("Sourav");
		userPayload.setFirstName("Sourav");
		userPayload.setLastName("Das");
		userPayload.setEmail("abc@xyz.com");
		userPayload.setPassword("abc123");
		userPayload.setPhone("6576973748");
		userPayload.setUserStatus(2);	
	}
	
	
	@Test(priority=1)
	public void testPostUser() {
		
		Response response=UserEndPoints2.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
//		Assert.assertEquals(response.getBody().jsonPath().get("id"), "2");
	}
	
	
	@Test(priority=2)
	public void testGetUser() {
		
		Response response=UserEndPoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=3)
	public void testUpdateUser() {
		userPayload.setUsername("Pom");
		userPayload.setLastName("Biswas");
		Response response=UserEndPoints2.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=4)
	public void testDeleteUser() {
		Response response=UserEndPoints2.deleteUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
}