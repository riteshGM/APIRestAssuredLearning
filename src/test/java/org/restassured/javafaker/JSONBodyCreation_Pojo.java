package org.restassured.javafaker;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.restassured.requestbodylearning.Products_Pojo;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class JSONBodyCreation_Pojo {
	
	/**
	 * @author Ritesh Mansukhani
	 * In this Example We are using POJO Class to Create Request Body
	 * Data is Set Using Java Faker Library in DummyProductDataGenerator Class
	 */
	
	@Test
	public void requestBodyUsingPojo() {
		Products_Pojo data = DummyProductDataGenerator.generateData();
		Response res =
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://dummyjson.com/products/add")
		.then()
		.extract().response();
		assertEquals(res.jsonPath().get("title"), data.getTitle());
	}
	
}