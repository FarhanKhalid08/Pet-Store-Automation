package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpointswithPropertiesfile {

	
	public static ResourceBundle getUrl() {
		
		ResourceBundle routes= ResourceBundle.getBundle("routes");
		return routes;
	}
	
	
	public static Response createuser(User payload) {
		String post_url=getUrl().getString("post_url");
		
		Response res= given()
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
		    .body(payload)
		.when()
		 .post(post_url);
		
		return res;
	}
	
	public static Response readuser(String username) {
		String get_url= getUrl().getString("get_url");
		
		Response res= given()
		   .pathParam("username", username)
		.when()
		   .get(get_url);
		return res;
	}
	
	public static Response updateuser(String username, User payload) {
		String put_url=getUrl().getString("put_url");
		
		Response res= given()
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .pathParam("username", username)
		   .body(payload) 
		.when()
		  .put(put_url);
		   return res;
	} 
	
	public static Response deleteuser(String username) {
		String delete_url=getUrl().getString("delete_url");
		
		Response res= given()
		   .pathParam("username", username)
		.when()
		  .delete(delete_url);
		
		return res;
	}
}
