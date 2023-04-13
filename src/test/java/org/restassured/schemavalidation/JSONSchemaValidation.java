package org.restassured.schemavalidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {

	/**
	 * Validating JSON Schema Using JSONSchemaValidator
	 * Mainly Used to validate Data Types of each attribute are correct or not and structure of JSON is matched
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
