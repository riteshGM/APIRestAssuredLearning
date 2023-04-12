package org.restassured.schemavalidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {

	/**
	 * Validating JSON Response
	 * Approach#1 Using Methods in then() Section
	 * This Approach is useful when your Response Body Size is Relatively
	 * small or manageable
	 */
	@Test
	public void schemaValidation() {
		given()
		.when().get("https://reqres.in/api/users?page=2")
		.then()
		.log().body()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("UsersJsonSchema.json"));

	}
}
