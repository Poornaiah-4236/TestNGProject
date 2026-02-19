package com.amazon.api;

import io.restassured.specification.RequestSpecification;

import com.aventstack.extentreports.gherkin.model.Given;
import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class baseAPITest {
	@Test
	public void getMethod() {
		RequestSpecification req = (RequestSpecification) new RequestSpecBuilder().setBaseUri("https://gorest.co.in/")
				.setBasePath("public/v2/users/").setContentType(ContentType.JSON).build();
		given().spec(req).pathParam("userId", 8369993)
				// .multiPart("")
				.when().get("{userId}").then().statusCode(200).log().all().statusLine("HTTP/1.1 200 OK")
				.body("name", equalTo("Bhargava Varman"), "gender", equalTo("female"), "email",
						equalTo("bhargava_varman@wilkinson.test"), "status", equalTo("active"))
				.time(lessThan(20000L));
	}

	@Test
	public void CreateAndWrite() {
		JsonObject jsonObject = new JsonObject();
		jsonObject.put("Name", "Vibha");
		jsonObject.put("Salary", 4500.00);
		JsonArray list = new JsonArray();
		list.add("Monday");
		list.add("Tuesday");
		list.add("Wednesday");
		jsonObject.put("Working Days", list);
		JsonObject address = new JsonObject();
		address.put("City", "Hyderabad");
		address.put("Pin", 501301);
		address.put("Active", true);
		jsonObject.put("Address", address);
		System.out.println(Jsoner.serialize(jsonObject));
		try (FileWriter fileWriter = new FileWriter("src/test/resources/JSONData/Employee.json")) {
			Jsoner.serialize(jsonObject, fileWriter);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Test
	public void getAndValidate() throws JsonException {
		try {
			String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/JSONData/Remote.json")));
			JsonObject jsonObject = (JsonObject) Jsoner.deserialize(jsonString);
			System.out.println(jsonObject.get("properties"));
			JsonObject store = (JsonObject) jsonObject.get("store");
			JsonArray bookArr = (JsonArray) store.get("book");
			for(Object object:bookArr) {
				JsonObject json=(JsonObject)object;
				String category = (String) json.get("category");
			      String author = (String) json.get("author");
			      String title = (String) json.get("title");
			     // BigDecimal price = (BigDecimal) book.get("price");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void createUser() {
		String usrl="https://gorest.co.in/public/v2/graphql";
		String query="'{\"query\":\"mutation{createUser(input: {name: \\\"Tenali Ramakrishna\\\" gender: \\\"male\\\" email: \\\"tenali.ramakrishna@15ce.com\\\" status: \\\"active\\\"}) {user{id name gender email status}}}\"}'";
		given()
				.header("ContentType","application/json")
				.header("Authorization","Bearer ")
				.body(query)
				.when()
				.post(usrl)
				.then()
				.log().all();
		
		Response resp=RestAssured.given()
				.auth().oauth2("AccessToken")
				.header("ContentType", "application/json")
				.body(query)
				.when()
				.post(usrl)
				.then()
				.extract()
				.response();
		JsonObject obj=(JsonObject)resp;
		JsonPath path=resp.jsonPath((JsonPathConfig) obj.get("name"));
				
				
		
	}

	@DataProvider(name = "userData")
	public Object[][] userData() {
		Object[][] obj = new Object[][] { { "name", "Bhargava Varman" }, { "gender", "female" },
				{ "email", "bhargava_varman@wilkinson.test" }, { "status", "active" } };
		return obj;
	}

}
