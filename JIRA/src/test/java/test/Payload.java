package test;

public class Payload {
	
	public static String authBody() {
		return "{ \"username\": \"adiitya\", \"password\": \"aaddii\" }";
	}
	
	public static String createIssue(String key,String summary) {
		return "{\r\n" + 
				"  \"fields\": {\r\n" + 
				"    \"project\": {\r\n" + 
				"      \"key\": \""+key+"\"\r\n" + 
				"    },\r\n" + 
				"    \"summary\": \"REST API TEST ISSUE 3\",\r\n" + 
				"    \"description\": \""+summary+"\",\r\n" + 
				"    \"issuetype\": {\r\n" + 
				"      \"name\": \"Bug\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
	}
	
	public static String commentIssue(String comment) {
		return "{\r\n" + 
				"  \"visibility\": {\r\n" + 
				"    \"type\": \"role\",\r\n" + 
				"    \"value\": \"Administrators\"\r\n" + 
				"  },\r\n" + 
				"  \"body\": \""+comment+"\"\r\n" + 
				"}";
	}

}
