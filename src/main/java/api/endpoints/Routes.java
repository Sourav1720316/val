package api.endpoints;


/*Keep all the URLs in this class. We can get the URLs from swagger.
 * Base URI = https://petstore.swagger.io/
 * Endpoints
 * POST = /user
 * Get = /user/{username}  [{username} = Path parameters]
 * 
 */

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Model
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
}
