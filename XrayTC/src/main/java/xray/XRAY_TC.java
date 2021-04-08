package xray;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class XRAY_TC {

	@Test
	public static void fetchTCID() {

		given().get("https://helpdesk.bravurasolutions.com//rest/api/2/issue/XRAY-3412").then().statusCode(200);

	}
}
