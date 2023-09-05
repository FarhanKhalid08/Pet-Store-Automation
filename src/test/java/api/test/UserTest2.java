package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpointswithPropertiesfile;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest2 {

	User userpayload;
	Faker faker;
	public Logger logger;
	
	@BeforeTest
	public void setupdata() {
		
		faker= new Faker();
		userpayload= new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger= LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testcreateuser() {
		
		logger.info("------------Creating User-----------------------");
		
		Response res= UserEndpointswithPropertiesfile.createuser(userpayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("-------------------User Created------------------");
	}
	
	@Test(priority=2)
	public void testreaduser() {
		
		logger.info("-------------Reading User--------------------------");
		
		 Response res=UserEndpointswithPropertiesfile.readuser(this.userpayload.getUsername());
		 res.then().log().all();
		 Assert.assertEquals(res.getStatusCode(), 200);
		 
		 logger.info("-------------------Read the User Successfully------------------");
	}
	
	@Test(priority=3)
	public void testupdateuser() {
		
		logger.info("-------------Updating the User--------------------------");
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setEmail(faker.internet().emailAddress());
		
		Response res =UserEndpointswithPropertiesfile.updateuser(this.userpayload.getUsername(), userpayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("-------------User Updated--------------------------");
		logger.info("-------------Reading User after Updation--------------------------");
		
		//checking data after update
		Response responseafterupdate = UserEndpointswithPropertiesfile.readuser(this.userpayload.getUsername());
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testdeleteuser() {
		
		logger.info("-------------Deleting User--------------------------");
		
		Response res= UserEndpointswithPropertiesfile.deleteuser(this.userpayload.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
		
		logger.info("-------------User deleted successfully--------------------------");
	}
	
}
