package com.amazon.home;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Set;
import io.restassured.RestAssured;
import io.restassured.response.Response;

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
	public static void main(String[]args) throws IOException {
		String str="madipallipoornaiahmadipoorna";
		Set<Character>set=new HashSet<>();
		for(char c:str.toCharArray()) {
			if(!set.add(c)) {				
				System.out.println(c);
			}
		}
		ApiTesting.apiTesting("Body");
		
	}
	public void validateJSON() {
		Response resp=given().when().get("");
		resp.jsonPath().getString("AccountID");
		
		given()
		.basePath(filePath)
		.pathParam("", "")
		.queryParam("", "")
		.body("")
		.when().post("")
		.then()
		.statusCode(DEFAULT_PORT)
		.body("account.id", equalTo(""))
		.body("account.balance",greaterThan(0))
		.body("account.transactions.size", equalTo(2))
		.body("account.transactions[0].status",equalTo("SUCCESS"))
		.body("account.transactions.find{it.txnId=='T2'}.status",equalTo("Faild"))
		.body("account.transactions.status", hasItems("",""))
		.body("account.transactions", allOf(greaterThan(30),lessThan(20)));
		File fl=new File("");

	}
	
}
class ApiTesting extends RuntimeException{
	public ApiTesting(String message) {
		super(message);
	}
	public static void apiTesting(String body){
		if(body==null||body.isEmpty()) {
			throw new ApiTesting("JSON Body is empty");
		}else {
			System.out.println("Do your validation ");
		}
		if(body==null||body.isEmpty()) {
			throw new ApiTesting("JSON Body is empty");
		}else {
			System.out.println("Do your validation ");
		}
		try {
		int[] numbers = {1, 2, 3};
        System.out.println(numbers[10]); // This will throw ArrayIndexOutOfBoundsException
        int result = 10 / 0; 
		}catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
			
		}
		
	}
	
}
