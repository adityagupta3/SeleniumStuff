package resources;

import java.util.ArrayList;
import java.util.Arrays;

import pojo.AddLocation;
import pojo.location;

public class TestData {
	
	public static AddLocation AddPlace_Payload(String name,String language ,String address) {
		AddLocation body = new AddLocation();
		body.setAccuracy(50);
		body.setName(name);
		body.setPhone_number("(+91) 983 893 3937");
		body.setWebsite("http://google.com");
		body.setLanguage(language);
		body.setAddress(address);

		ArrayList<String> types = new ArrayList<String>(Arrays.asList("shoe park", "shop"));

		body.setTypes(types);

		location loc = new location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);

		body.setLocation(loc);
		return body;
	}
	
	public static String DeletePlace_Payload(String place_id) {
		return "{\r\n    \"place_id\":\""+place_id+"\"\r\n}" ;
	}
}
