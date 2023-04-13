package org.restassured.allrequesttypescripts;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class SampleDeleteRequest {
	int id;
	@Test (priority = 3, dependsOnMethods = "deleteUser")
	public void getUser() {
		given()
		.when().get("https://reqres.in/api/users/"+id)
		.then()
		.assertThat().statusCode(404) //Checks if Status Code is 404 Not Found
		.log().all() // Prints Entire Response on Console
		;
		
		
	}
	
	@Test (priority = 1)
	public void createUser() {
		HashMap<String, String> data = new HashMap <String,String>();
		data.put("name","ritesh");
		data.put("job","trainer");
		
		Response res = given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.assertThat().statusCode(201)
		.extract()
		.response();
		
		id = res.jsonPath().getInt("id");
		System.out.println("User Created with ID:"+id);
		
	}
	
	@Test (priority = 2 , dependsOnMethods = "createUser")
	public void deleteUser() {
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
		.assertThat().statusCode(204);
		System.out.println("User Deleted with ID:"+id);
	}

}
