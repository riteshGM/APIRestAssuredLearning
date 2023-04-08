package org.restassured.requestbodylearning;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
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
	public void getUsers() {
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
}
