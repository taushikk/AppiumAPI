package APITestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Utility.BaseTest;
import io.restassured.response.Response;

public class GetUsers extends BaseTest {

	Response getRes;

	@BeforeMethod
	public void setUp() {
		RequestURL.BaseURL();

	}

	@Test
	public void getAllUsers() {
		myTest = myExtent.createTest("Verify Get All User");
		
		// Ability to get users list with the GET method
		getRes = given().when().get(RequestURL.GetUsersServiceURL()).then().assertThat().statusCode(200).extract()
				.response();

		String reponseBody = getRes.asString();

	
		myTest.log(Status.INFO , "Status Code is" + getRes.getStatusCode());
		
		myTest.log(Status.INFO , "Time taken " + + getRes.getTime());
		
		myTest.log(Status.INFO , "The headers are" +getRes.getHeaders() );
		

		System.out.println("The response body displaying the list of users");
		System.out.println(reponseBody);
		System.out.println("--------------------------------");
	}

}
