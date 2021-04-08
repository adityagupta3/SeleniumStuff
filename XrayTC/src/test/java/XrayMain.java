
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class XrayMain {

	@Test
	public static void fetchTCID() {
		
		 given().
		    get("https://helpdesk.bravurasolutions.com//rest/api/2/issue/XRAY-3412").
		    then().statusCode(200);
	}
}
