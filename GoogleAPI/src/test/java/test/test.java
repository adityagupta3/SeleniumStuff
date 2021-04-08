 package test;

import io.restassured.RestAssured;
import pojo.AddLocation;
import pojo.location;

import static  io.restassured.RestAssured.*;


import java.util.ArrayList;
import java.util.Arrays;

public class test {
	
	public static void main (String[] args) {
		
		//POJO Object serialization
		
		AddLocation body = new AddLocation();
		body.setAccuracy(50);
		body.setName("Frontline house");
		body.setPhone_number("(+91) 983 893 3937");
		body.setWebsites("http://google.com");
		body.setLanguage("French-IN");
		body.setAddress("29, side layout, cohen 09");
		
		ArrayList<String> types = new ArrayList<String>(Arrays.asList("shoe park","shop"));
		

		body.setTypes(types);
		
		location loc = new location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		
		body.setLocation(loc);
		
		///REST ASSURED REQUEST
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given()
			.queryParam("key", "qaclick123")
			.body(body).log().all()
		.when()	
			.post("/maps/api/place/add/json")
		.then()
			.assertThat().statusCode(200).log().all();
			
		//System.out.println(resp);
			
	
		
	}

}
