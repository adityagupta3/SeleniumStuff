package REST_ASSURED;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

  
import files.Payload;

public class Basics {
	
	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		String response = 	given()
								.queryParam("key", "qaclick123")
								.header("Content-Type", "application/json")
								.body(Payload.addPlace())
							.when()
								.post("maps/api/place/add/json")
							.then()
								.assertThat()
									.statusCode(200)
									.body("scope", equalTo("APP"))
									.header("server", equalTo("Apache/2.4.18 (Ubuntu)"))
								.extract().response().asString();
		
	//	System.out.println(response);
		
		JsonPath js =  new JsonPath(response);
		String place_id = js.get("place_id");
		
		System.out.println(place_id);
		
		given()
			.queryParam("key", "qaclick123")
			.queryParam("place_id",place_id)
		.when()
			.get("maps/api/place/get/json")
		.then()
			.assertThat()
				.statusCode(200)
				.body("name", equalTo("Rahul Shetty Academy"))
				.header("server", equalTo("Apache/2.4.18 (Ubuntu)"))
			.log().body();
				
	}

}
