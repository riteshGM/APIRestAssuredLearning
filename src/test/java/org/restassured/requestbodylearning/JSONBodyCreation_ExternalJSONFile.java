package org.restassured.requestbodylearning;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

/**
 * Sample URL https://dummyjson.com/
 * @author Ritesh Mansukhani
 * Sample Request Body
 * {
  "id": 1,
  "title": "iPhone 9",
  "description": "An apple mobile which is nothing like apple",
  "price": 549,
  "discountPercentage": 12.96,
  "rating": 4.69,
  "stock": 94,
  "brand": "Apple",
  "category": "smartphones",
  "thumbnail": "https://i.dummyjson.com/data/products/1/thumbnail.jpg",
  "images": [
    "https://i.dummyjson.com/data/products/1/1.jpg",
    "https://i.dummyjson.com/data/products/1/2.jpg",
    "https://i.dummyjson.com/data/products/1/3.jpg",
    "https://i.dummyjson.com/data/products/1/4.jpg",
    "https://i.dummyjson.com/data/products/1/thumbnail.jpg"
  ]
}
 *
 */

public class JSONBodyCreation_ExternalJSONFile {
	/**
	 * Program to create JSON Body from External JSON File
	 * @throws FileNotFoundException
	 */
	@Test
	public void requestBodyUsingExternalJSONFile() throws FileNotFoundException {
		File f = new File (".\\src\\test\\resources\\external.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);
		System.out.println(data.toString());
		Response res =
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://dummyjson.com/products/add")
		.then()
		.extract().response();
		
		assertEquals(res.jsonPath().get("title"), "iPhone 9");
		
		System.out.println(res.asPrettyString());
	}

}
