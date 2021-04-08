package XRAY;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class XrayMain {
	
	
	public static String data;
	public final String path = "C:/Applications/jenkins/agent/workspace/AutomatedRegressionTests/test/UTILITIES/BusinessProcessReport/businessprocess.html";		//Jenkins server path";
	public static String output = "";
	public static String header;
	public final String footer = "  </tbody>\r\n" + 
			"</table>\r\n" + 
			"<p class=\"auto-cursor-target\">\r\n" + 
			"  <br/>\r\n" + 
			"</p>";

	
	public ArrayList<String> fetchXRAYids(String XrayID) {
		
		header = "<h2>Test Cases for "+XrayID+"</h2>\r\n" + 
				"<table class=\"relative-table\" style=\"width: 100.0%;\">\r\n" + 
				"  <colgroup> <col style=\"width: 2.74424%;\"/> <col style=\"width: 6.86059%;\"/> <col style=\"width: 85.3458%;\"/> </colgroup>\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <th>Sno.</th>\r\n" + 
				"      <th>XRAY TC ID</th>\r\n" + 
				"      <th>Steps</th>\r\n" + 
				"    </tr>";	
		
		ArrayList<String> tcIds = given().header("Content-Type", "application/json")
				.header("Authorization", "Basic YXV0b21hdGVkYnVpbGQ6SHVyc3RNM3Iz").when()
				.get("https://helpdesk.bravurasolutions.com/rest/api/2/issue/"+XrayID).then().statusCode(200)
				.extract().path("fields.customfield_18352");

		System.out.println(tcIds);
		System.out.println("--------------------------------------------------");

		
		return tcIds;
		
	}
	
	public void fetchTestSteps( ArrayList<String> tcIDs){
		
		for (int j = 0; j < tcIDs.size(); j++) {
			

			ArrayList<String> tc = given().header("Content-Type", "application/json")
					.header("Authorization", "Basic YXV0b21hdGVkYnVpbGQ6SHVyc3RNM3Iz").when()
					.get("https://helpdesk.bravurasolutions.com/rest/api/2/issue/" + tcIDs.get(j)
							+ "/?fields=customfield_18344")
					.then().statusCode(200).extract().path("fields.customfield_18344.steps.fields.Action");

			System.out.println("-------------" + tcIDs.get(j) + "--------------");
			
			output+=" <tr></tr><tr>\r\n" + 
					"      <td rowspan=\""+ (tc.size()+1)+"\">"+(j+1)+"</td>\r\n" + 
					"      <td rowspan=\""+ (tc.size()+1)+"\">" + tcIDs.get(j) + "</td>"
							+ " </tr>";
			//output+=  "<td>"+(j+1)+"</td>"+ "<td>" + tcIDs.get(j) + "</td>";

			for (int i = 0; i < tc.size(); i++) {
//				System.out.println(tc.get(i));
//				System.out.println("-------------");
				
				String str = tc.get(i);
				
				if(str.contains("&")) {
					System.out.println(" & found");
					
					str = str.replace("&", "&amp;");
				}
				
				output+= "<tr>"
						+ "<td>"+str+"</td>\r\n" + 
						"</tr>";
			}
		}
		
	}
	
	
	public void createHTML() {
		data = header + output + footer;
		
		File file = new File(path);
		FileWriter fr = null;
		try {
			fr = new FileWriter(file);
			fr.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close resources
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
