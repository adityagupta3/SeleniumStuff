package Book;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

public class bookfunc {

	@Test(dataProvider = "AddBooks")
	public void addBook(String isbn,int aisle) {
		RestAssured.baseURI = "https://rahulshettyacademy.com/Library/Addbook.php";
		
		String response = given()
				.header("Content-Type", "application/json")
				.body(Payload.addBookBody(isbn, aisle))
		.when()
				.post()
		.then()
				.assertThat()
					.statusCode(200)
				.body("Msg", equalTo("successfully added"))
				.extract().response().asString();
		
		JsonPath js = ResuableMethods.rawToJson(response);
		assertEquals(js.getString("Msg"), "successfully added");
		String id = js.getString("ID");
		System.out.println("ID = "+id);
	}
	
	@DataProvider(name = "AddBooks")
	public Object[][] getData(){
		return new Object[][] {{"aaa",1231231232},{"ascafvsc",13235346}};
	}

	@Test
	public static void intProd() {
		int a, last = Integer.MIN_VALUE, product;

		int arr[] = { -8, -2, 3, -10, 6 };

		for (int i = 0; i < arr.length; i++) {

			for (int k = 0; k < arr.length; k++) {

				for (int j = 0; j < arr.length; j++) {
					if (i != j && i!=k && j!=k) {
						product = arr[i] * arr[j]*arr[k];
						if (product > last) {
							last = product;
						}
					}

				}

			}

		}
		System.out.println(last);
		
        String str = "apple";
        String npt = "bannana";
        String str1 = "apple";
        String str2 = new String("apple");
       
        System.out.println(str == str1);    //True
        System.out.println(str == str2);//True
        System.out.println(str.equals(str2));//True
        System.out.println(str == npt);//False
        
       str =  str.trim();
		
	//	str.toChar
	}

}
