package org.restassured.scripts;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class SampleGetRequest {
	/**
	 * Sample First GET Request Program
	 */
	@Test
	public void getUsers() {
		System.out.println("First RestAssured Program");
		
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat().statusCode(200) //Checks if Status Code is 200
		.log().all() // Prints Entire Response on Console
		;
		
	}
	

}
