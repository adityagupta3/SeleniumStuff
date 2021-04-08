package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
	public static RequestSpecification req;
	public static ResponseSpecification resp;
	


	public static RequestSpecification requestSpecification() throws IOException {
		
		PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
		
		if(req == null) {
			req = new RequestSpecBuilder()
					.setBaseUri(getGlobalValue("baseURI"))
					.setContentType(ContentType.JSON)
					.addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream))
					.build();
			
						return req;
						
					} else {

						return req;
		}
	}
	
	public static ResponseSpecification responseSpecification() {
		 resp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 return resp;
	}
	
	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		System.out.println(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\global.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		
		return prop.getProperty(key);
	}
	
	public static String getJsonPath(String key,Response response) {
//		System.out.println(key);
//		System.out.println(response.asString());
		JsonPath js = new JsonPath(response.asString());
//		System.out.println(js.get(key));
		return js.get(key).toString();
	}

}
