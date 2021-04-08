package test;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	public static JsonPath jsonpath(String response) {
		return new JsonPath(response);
	}

}
