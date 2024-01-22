package api.endpoints;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Used for creating Create, Read, Update and Delete requests (CRUD) to the user API
public class UserEndPoints2 {
	
	//Method created for getting URLs from the properties file
	//Pass name of properties file into the constructor. 
	// No need to pass the whole path.
	public static ResourceBundle getURL() {
		//Load the properties file
		ResourceBundle routes=ResourceBundle.getBundle("routes"); 
		return routes;
	}
	
	public static Response createUser(User payload){
		
		String post_url=getURL().getString("post_url");
		Response response=RestAssured.given()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(post_url);
		
		return response;
	}

	public static Response readUser(String userName){
		String get_url=getURL().getString("get_url");
		Response response=RestAssured.given()
		.pathParam("username", userName)		
		.when()
		.get(get_url);
		
		return response;
	}

	public static Response updateUser(String userName, User payload){
	
		String update_url=getURL().getString("update_url");
		Response response=RestAssured.given()
				.contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
				.when()
				.put(update_url);
				
				return response;
	}

	public static Response deleteUser(String userName, User payload){
		
		String delete_url=getURL().getString("delete_url");
		Response response=RestAssured.given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.when()
				.delete(delete_url);
				
				return response;
	}
}
