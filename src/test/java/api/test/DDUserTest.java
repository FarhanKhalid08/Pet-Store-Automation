package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDUserTest {

	public Logger logger;
	
	@Test(priority=1,dataProvider="data",dataProviderClass=DataProviders.class)
	public void testcreateuser(String userid, String username,String fname,String lname, String email,String password, String phone) {
		logger= LogManager.getLogger(this.getClass());
				
		logger.info("---------------------Data Driven Testing for Creating Users------------------");		
	    User userpayload=new User();
		
		userpayload.setId(Integer.parseInt(userid));
		userpayload.setUsername(username);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		userpayload.setPhone(phone);
		
		Response res= UserEndpoints.createuser(userpayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
		public void testdeleteuserbyusername(String username) {
		
		logger= LogManager.getLogger(this.getClass());
		logger.info("---------------------Data Driven Testing for Deleting Users------------------");		
		Response res= UserEndpoints.deleteuser(username);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
