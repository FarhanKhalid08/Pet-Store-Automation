package api.endpoints;

/* Swagger URI: https://petstore.swagger.io
 * 
 * Create User (post): https://petstore.swagger.io/v2/user
 * Read User (get): https://petstore.swagger.io/v2/user/{username}
 * Update User (put): https://petstore.swagger.io/v2/user/{username}
 * Delete User (delete): https://petstore.swagger.io/v2/user/{username}
*/

public class Routes {
	
	
	public static String base_url="https://petstore.swagger.io/v2/";
	
	public static String post_url = base_url+"user";
	public static String get_url = base_url+"user/{username}";
	public static String put_url = base_url+"user/{username}";
	public static String delete_url = base_url+"user/{username}";

}
