package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JIRA_ISSUE_SMOKE {

	public static SessionFilter login_cookie = new SessionFilter();
	public static String key;
	public static String summary;
	public static int id;
	public static int commentID;
	
	
	
	@Test(groups = "a")
	public void generateLoginCookie() {
	
		RestAssured.baseURI = "http://localhost:8080/rest/auth/1/session";	
		given()
			.header("Content-Type","application/json")
			.body(Payload.authBody())
			.filter(login_cookie)
		.when()
			.post()
		.then()
			.assertThat().statusCode(200)
			.extract();
		
		//System.out.println(session);
		
//		JsonPath js = ReusableMethods.jsonpath(session);
		
//		String sessName = js.get("session.name");
//		String sessID = js.get("session.value");
	//	System.out.println(sessName+"="+sessID);
		
		//login_cookie = sessName+"="+sessID;
		System.out.println(login_cookie);
	}
	
	@Test(groups = "b" , dependsOnGroups = "a")
	public void createIssue() {
		System.out.println(login_cookie);
		RestAssured.baseURI = "http://localhost:8080";	
		key = "RES";
		summary = "Issue created from REST ASSURED";
		
		String response = given()
			.header("Content-Type","application/json")
			.body(Payload.createIssue(key, summary))
			.filter(login_cookie)
		.when()
			.post("/rest/api/2/issue")
		.then()
			.assertThat().statusCode(201)
			.extract().response().asString();
		
		JsonPath js = ReusableMethods.jsonpath(response);
		id = js.getInt("id");
		System.out.println("Issue ID = "+id);
			
			
			
	}
	
	@Test(groups = "c" ,dependsOnGroups = "b", dataProvider = "getCommentData")
	public void addComment(String comment) {
		RestAssured.baseURI = "http://localhost:8080";	
		String response = 
		given()
		.pathParam("key", id)
			.header("Content-Type","application/json")
			.body(Payload.commentIssue(comment))
			.filter(login_cookie)
		.when()
			.post("/rest/api/2/issue/{key}/comment")
		.then()
			.assertThat().statusCode(201)
			.extract().response().asString();
		
		JsonPath js = ReusableMethods.jsonpath(response);
		commentID = js.getInt("id");
		System.out.println("Comment ID = "+commentID);
	}
	
	@Test(groups = "c" ,dependsOnGroups = "b")
	public void addAttachment() {
		RestAssured.baseURI = "http://localhost:8080";
		given()
		.pathParam("key", id)
			.header("X-Atlassian-Token","no-check")
			.header("Content-Type","multipart/form-data")
			.filter(login_cookie)
			.multiPart( "file" , new File("C:\\Users\\a7gupta\\Documents\\debug.log"))
			
		.when()
			.post("rest/api/2/issue/{key}/attachments")
		.then()
			.assertThat().statusCode(200);
			
	}
	
	@Test(dependsOnGroups = "c")
	public void verifyComment() {
		RestAssured.baseURI = "http://localhost:8080";
		
		String response = given()
			.filter(login_cookie)
			.pathParam("key", id)
			.queryParam("fields", "comment")
		.when()
			.get("rest/api/2/issue/{key}")
		.then()
			.assertThat().statusCode(200)
			.extract().response().asString();
		
		JsonPath js = ReusableMethods.jsonpath(response);
//		System.out.println("Total Comments = "+js.getInt("fields.comment.comments.size()"));
//		System.out.println("Comments = "+ js.get("fields.comment.comments"));
//		System.out.println("Comment ID searching for = "+commentID);
		for(int i=0;i<js.getInt("fields.comment.comments.size()");i++){
			if(commentID == js.getInt("fields.comment.comments["+i+"].id")) {
				System.out.println("Comment ID ="+commentID+", body = "+js.getString("fields.comment.comments["+i+"].body"));
			}
		}
		
	}
	
	@DataProvider(name = "getCommentData")
	public Object[][] getCommentData() {
		return new Object[][]  { {"New Comment Data Provd 1"}, {"New Comment Data Provd 2"}};
		
	}
	


}
