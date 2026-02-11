package com.amazon.home;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.sql.Time;
import java.util.Set;
import io.restassured.RestAssured;
import java.util.*;
public abstract class BaseAPI {
	public static String URL = "";
	public static String filePath;

	public void getMethod() {
		RestAssured res=(RestAssured) RestAssured.get(URL);
	}

	public void PostMethod() {
		given().auth().basic("", "")
		.queryParam("", "")
		.pathParam("", "")
		.contentType("Application/JSON")
		.body("")		
		.when().post("")		
		.then().statusCode(200)
		.body("Massage", equalTo(""));
	}
	public static void main(String[]args) {
		String str="madipallipoornaiahmadipoorna";
		Set<Character>set=new HashSet<>();
		for(char c:str.toCharArray()) {
			if(!set.add(c)) {
				
				System.out.println(c);
			}
		}
		//System.out.println(set);
	}
}
