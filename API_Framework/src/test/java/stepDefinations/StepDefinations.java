package stepDefinations;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;

import java.io.IOException;

import resources.APIResources;
import resources.TestData;
import resources.Utils;

public class StepDefinations {

	public static RequestSpecification request;
	public static Response response;
	public static String place_id;
	JsonPath js;

	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String language, String address)  throws IOException {



		request = given()
					.spec(Utils.requestSpecification())
					.body(TestData.AddPlace_Payload(name,language,address));

		

	}

	@When("When user calls {string} with {string}")
	public void when_user_calls_with_method(String resource,String method) {
		
		
		if(method.equalsIgnoreCase("POST")) {
			
			response = request
					.when() 
						.post(APIResources.valueOf(resource).getresource());
			
		} else if (method.equalsIgnoreCase("GET")) {
			
			response = request
					.when() 
						.get(APIResources.valueOf(resource).getresource());		
		}
//		response = request
//					.when() 
//						.post(APIResources.valueOf(resource).getresource())
//					.then()
//						.spec(Utils.responseSpecification())
//						.extract().response();
	}

	
	
	@Then("Response is success with code {int}")
	public void response_is_success_with_code(int statusCode) {
		

		//System.out.println(response.getStatusCode());
		assertEquals(statusCode, response.getStatusCode());
	}

	
	
	@Then("{string} in response is {string}")
	public void in_response_is(String keyValue, String expectedValue) {
		System.out.println(response.asString());
		
		assertEquals(Utils.getJsonPath(keyValue, response), expectedValue);


	}
	
	
	@Then("verify {string} is added using {string} with {string}")
	public void verify_is_added_using(String id, String resource, String name) throws IOException {
		place_id = Utils.getJsonPath(id, response);
		request = given()
				.spec(Utils.requestSpecification())
				.queryParam(id, place_id);
		
		when_user_calls_with_method(resource, "GET");
		assertEquals(Utils.getJsonPath("name", response), name);
	}

	
	@Given("Delete Place payload")
	public void delete_place_payload() throws IOException {
		
		request = given()
			.spec(Utils.requestSpecification())
			.body(TestData.DeletePlace_Payload(place_id));
	    
	}


}
