package org.restassured.requestbodylearning;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JSONResponseValidation {

	/**
	 * Validating JSON Response
	 * Approach#1 Using Methods in then() Section
	 * This Approach is useful when your Response Body Size is Relatively
	 * small or manageable
	 */
	@Test
	public void responseBodayValidation_1() {
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)//Checks if Status Code is 200
		.header("Content-Type", "application/json; charset=utf-8")
		.header("Connection", "keep-alive")
		.body("total_pages",equalTo(2))
		.body("page",equalTo(2))
		.body("data[1].id",equalTo(8))
		.body("data[1].email", equalTo("lindsay.ferguson@reqres.in"))
		.body("support.url", equalTo("https://reqres.in/#support-heading"))
		.log().body();

	}
	
	/**
	 * Approach#2 Using Response Captured and then validating Response each field separately
	 */
	@Test
	public void responseBodyValidation_UsingResponseInstance() {
		/**
		 * You May Write in Given When Then format otherwise get is a static method
		 * from RestAssurred Library which returns Response
		 */
		Response res = get("https://reqres.in/api/users?page=2");
		
		//Using Assertion of TestNG and ResponseOptions Methods
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(res.jsonPath().getString("data[1].id").toString(), "8");
		Assert.assertEquals(res.jsonPath().getString("data[1].email"), "lindsay.ferguson@reqres.in");
	}
}
