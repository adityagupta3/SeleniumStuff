 package test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddLocation;
import pojo.location;

import static  io.restassured.RestAssured.*;


import java.util.ArrayList;
import java.util.Arrays;

public class SpecBuilder {
	
	public static void main (String[] args) {
		
		//POJO Object serialization
		
		AddLocation body = new AddLocation();
		body.setAccuracy(50);
		body.setName("Frontline house");
		body.setPhone_number("(+91) 983 893 3937");
		body.setWebsite("http://google.com");
		body.setLanguage("French-IN");
		body.setAddress("29, side layout, cohen 09");
		
		ArrayList<String> types = new ArrayList<String>(Arrays.asList("shoe park","shop"));
		

		body.setTypes(types);
		
		location loc = new location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		
		body.setLocation(loc);
		
		RequestSpecification req =  new RequestSpecBuilder()
			.setBaseUri("https://rahulshettyacademy.com")
			.setContentType(ContentType.JSON)
			.addQueryParam("key", "qaclick123")
			.build();
		
		ResponseSpecification res = new ResponseSpecBuilder()
									.expectStatusCode(200) 
									.expectContentType(ContentType.JSON)
									.build();
		
		///REST ASSURED REQUEST
		
		//RestAssured.baseURI = "";
		
		given()
			.spec(req)
			.body(body).log().all()
		.when()	
			.post("/maps/api/place/add/json")
		.then()
			.spec(res).log().all();
			
		//System.out.println(resp);
			
	
		
	}

}
