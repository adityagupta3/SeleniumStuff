package test;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.restassured.*;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class tests1221 {

	@Test(priority = 1)
	public void test1() {
		System.out.println("Hello Priority 1");
	}

	@Test
	public void test2() {
		System.out.println("Hello Priority 2");
	}

	@Test
	public void api() {

		RestAssured.baseURI = "https://reqres.in/api/users";

		String response = given().queryParam("page", "2").when().get().then().extract().response().asString();

		JsonPath js = new JsonPath(response);

		for (int i = 0; i < js.getInt("data.email.size()"); i++) {
			System.out.println(js.get("data[" + i + "].email"));
		}
		js.get("data.first_name");
	}

	@Test
	public void test11() {

		long number = 9999955555L;

		long no = number % 100000;
		long[] temp = new long[5];
		boolean flag = false;
		int count = 0;
		// same digits
		for (int i = 1; i <= 5; i++) {

			temp[i - 1] = no % 10;
			no = no / 10;
			// System.out.println(temp[i-1]);
		}

		for (int i = 0; i < 4; i++) {
			// Last 5 digits
			if (temp[i] == temp[i + 1]) {
				count++;
				if(i==4) {
				if (count == 4) {
					flag=true;
					break;
				} else if(count == 3) {
					flag=true;
					break;
				}else if(count == 2) {
					flag=true;
					break;
					
				} else { count =0;}
			
			}
			// Ascending
			else if (flag==false && temp[i] == (temp[i + 1] - 1)) {
				count++;
				if (count == 4) {
					flag=true;
					break;
				} else if(count == 3) {
					flag=true;
					break;
				}else if(count == 2) {
					flag=true;
					break;
				} else { count =0;
			}
			}

			// Descending
			else if (flag==false &&temp[i] == (temp[i + 1] + 1)) {
				count++;
				if (count == 4) {
					flag=true;
					break;
				} else if(count == 3) {
					flag=true;
					break;
				}else if(count == 2) {
					flag=true;
					break;
				} else { count =0;}
			}
		}
		System.out.println(count);
		if (count == 4) {
			System.out.println("VeryVeryEasy");
		} else if (count == 3) {
			System.out.println("VeryEasy");
		} else if (count == 2) {
			System.out.println("Easy");
		} else {
			System.out.println("NotEasy");
		}

	}}
	
	@Test
	public void palindrome() {
		String a = "abcbaa";
		//String rev = new String(a.length());
		char[] ca = a.toCharArray();
		//char[] rev = new char[a.length()];
		int count=0;
		for(int i=0;i<ca.length-1;i++) {
			if(ca[ca.length-i-1] == ca[i]) {
				count++;
			}
			
		}
		System.out.println(ca.length-1 + "    "+count);
		if (count == ca.length-1){
			System.out.println("Palindrome");
		} else {
			System.out.println("No");
		}
		
	}
	
	@Test
	public void charCount() {
		String a = "aasda";
		HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
		char[] ac = a.toCharArray();
		int count=0;
		for(int i=0;i<a.length();i++) {
			for(int j=0;j<a.length();j++) {
				if( ac[i] == a.charAt(j) ) {
					count++;
				}
			}
			if(!hm.containsKey(ac[i])) {
				hm.put(ac[i], count);
			}
			count=0;
		}
		System.out.println(hm);
	}
	
	@Test
	public void charCount1() {
		String a = "aasda";
		HashMap<Character,Integer> hm = new HashMap<Character, Integer>();
		char[] ac = a.toCharArray();
		//int count=0;
		for(int i =0;i<ac.length;i++) {
			if(hm.containsKey(ac[i])) {
				hm.put(ac[i],hm.get(ac[i])+1 );
			}
			
			if(!hm.containsKey(ac[i])) {
				hm.put(ac[i],1 );
			}
		}
		System.out.println(hm);
	}
	
	@Test
	public void regex() {
		Pattern pattern = Pattern.compile("Aditya",Pattern.CASE_INSENSITIVE);
		Matcher match = pattern.matcher("AdityaGuptaaditya aaddiiadityaaditya");
		int count =0;
		//match.
		while(match.find()) {
			count++ ;
		}
		System.out.println(count);
	}

	@Test
	public void regex1() {
		String reg = ".*aditya.*";
		//int count =0;
		System.out.println(Pattern.matches(reg, "AdityaGuptaadityaaaddiiadityaaditya"));
		String text = "http://jenkov.com";

		Pattern pattern = Pattern.compile(".com$");
		Matcher matcher = pattern.matcher(text);

		while(matcher.find()){
		    System.out.println("Found match at: "  + matcher.start() + " to " + matcher.end());
		}
	}
	
	@Test
	public void regex2Boundary() {
		String text = "Mary had a little lamb";

		Pattern pattern = Pattern.compile("\\b");
		Matcher matcher = pattern.matcher(text);

		while(matcher.find()){
		    System.out.println("Found match at: "  + matcher.start() + " to " + matcher.end());
		}
	}
	
	
	@Test
	public void fibnacci() {
		int a=0,b=1;
		int c=0;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int i=0;i<n;i++) {
			c=a+b;
			if(i==0) {
				System.out.print(a+" ");
			}
			else if(i==1) {
				System.out.print(b+" ");
			}
			else {
				System.out.print(c+" ");
				a=b;
				b=c;
			}
			
			
		}
	}
	
	
}
