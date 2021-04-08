package REST_ASSURED;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class testing {

	public static JsonPath js = new JsonPath(Payload.courseResponse);

	public static void main(String[] args) {

		System.out.println(js.getInt("courses.size()"));

		System.out.println(js.getInt("dashboard.purchaseAmount"));

		System.out.println(js.get("courses[0].title"));

	}

	@Test
	public static void printValidate() {
		int sum = 0;
		for (int i = 0; i < js.getInt("courses.size()"); i++) {
			System.out.println(
					(js.getString("courses[" + i + "].title")) 
					+ "		" 
							+ js.getInt("courses[" + i + "].price"));
			
			sum += (js.getInt("courses[" + i + "].price") * js.getInt("courses[" + i + "].copies"));
		}
		System.out.println(sum);
		Assert.assertEquals(js.getInt("dashboard.purchaseAmount"), sum);

	}

	@Test
	public static void getRPACopies() {
		for (int i = 0; i < js.getInt("courses.size()"); i++) {

			if (js.getString("courses[" + i + "].title").equalsIgnoreCase("RPA")) {

				System.out.println(js.getInt("courses[" + i + "].copies"));
				break;

			}
		}

	}

}
