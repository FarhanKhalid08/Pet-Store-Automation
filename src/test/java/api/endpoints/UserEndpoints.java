package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	
	public static Response createuser(User payload) {
		Response res= given()
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
		    .body(payload)
		.when()
		 .post(Routes.post_url);
		
		return res;
	}
	
	public static Response readuser(String username) {
		
		Response res= given()
		   .pathParam("username", username)
		.when()
		   .get(Routes.get_url);
		return res;
	}
	
	public static Response updateuser(String username, User payload) {
		
		Response res= given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username", username)
		   .body(payload) 
		.when()
		  .put(Routes.put_url);
		  
		  return res;
	} 
	
	public static Response deleteuser(String username) {
		
		Response res= given()
		   .pathParam("username", username)
		.when()
		  .delete(Routes.delete_url);
		
		return res;
	}
}
