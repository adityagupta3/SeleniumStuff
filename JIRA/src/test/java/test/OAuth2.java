package test;

import org.testng.annotations.Test;
import io.restassured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.Scanner;

public class OAuth2 {
	
	@Test
	public void oauth() {
		
		//.queryParam("scope", "https://www.googleapis.com/auth/userinfo.email")
		
		
		String response = given()			
			.queryParam("code", "")
			.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
			.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
			.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
			.queryParam("grant_type", "authorization_code")
		.when()
			.post("https://www.googleapis.com/oauth2/v4/token").asString();
			
		JsonPath js = ReusableMethods.jsonpath(response);
		String accessToken = js.getString("access_token");
		
		String resp = given()
			.queryParam("access_token", accessToken)
		.when()
			.get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(resp);

		
	}

}
