package APITestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Utility.BaseTest;
import io.restassured.response.Response;

public class GetUser extends BaseTest {

	Response getListRes;

	@BeforeMethod
	public void setUp() {

		RequestURL.BaseURL();

	}

	@Test
	public void getUser() {

		myTest = myExtent.createTest("Verify Get User");
		// Ability to view selected user profile with the GET method
		getListRes = given().when().get(RequestURL.ServiceURL() + "2").then().assertThat().statusCode(200).extract()
				.response();

		String UserResBody = getListRes.asString();

		myTest.log(Status.INFO , "The response body for searched user" + UserResBody);
		

	}

}
