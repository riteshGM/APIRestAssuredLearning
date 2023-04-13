package org.restassured.schemavalidation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLSchemaValidation {

	/**
	 * Validating JSON Schema Using JSONSchemaValidator
	 * Mainly Used to validate Data Types of each attribute are correct or not and structure of JSON is matched
	 */
	@Test
	public void schemaValidation() {
		given()
		.when().get("http://restapi.adequateshop.com/api/Traveler?pages=1")
		.then()
		.log().body()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("TravellerXML.xsd"));
	}
}
