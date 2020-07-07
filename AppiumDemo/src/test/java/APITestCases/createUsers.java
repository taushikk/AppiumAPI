package APITestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Utility.BaseTest;
import Utility.TestData;
import io.restassured.response.Response;

public class createUsers extends BaseTest {

	@BeforeMethod
	public void setUp() {

		RequestURL.BaseURL();

	}

	@Test
	public void postUser() throws NullPointerException {

		myTest = myExtent.createTest("Verify Create User");
		Response postres = given().body(TestData.Payload()).when().post(RequestURL.ServiceURL()).then().extract()
				.response();

		String postResString = postres.asString();

		
		myTest.log(Status.INFO , "Status code is - " + postres.getStatusCode());
		myTest.log(Status.INFO , "Time taken is - " + postres.getTime());
		myTest.log(Status.INFO , "The headers are - " + postres.getHeaders());
		myTest.log(Status.INFO , "The resposne body for create user" + postResString);
		
	}

}
