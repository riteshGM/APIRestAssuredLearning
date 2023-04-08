package org.restassured.basics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class LogMethodSample {

	@Test
	public void LogMethodUsageSampleTest() {		
				given()
				.when()
				//Request Type
				.get("https://www.google.com") 
				.then()
				//Validations
				.log().all() //Prints Entire Response
				.log().body() //Prints Response Body Only
				.log().cookies() //Prints Cookies Only
				.log().headers()
				.log().status();
	}

}
