package org.restassured.requestbodylearning;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
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

public class JSONBodyCreation_ORGJson {
	
	@Test
	public void requestBodyUsingORGJSON() {
		JSONObject data = new JSONObject() ;
		data.put("title","Redmi Note 12 Pro");
		data.put("description","Redmi Note 12 Pro Latest Phone");
		data.put("price",16581);
		data.put("discountPercentage",15.23);
		data.put("rating",4);
		data.put("stock",1000);
		data.put("brand","Xiaomi");
		data.put("category","Smartphones");
		data.put("thumbnail","https://i.dummyjson.com/data/products/1/thumbnail.jpg");
		
		String imagesArr[] = {"https://i.dummyjson.com/data/products/1/1.jpg",
				"https://i.dummyjson.com/data/products/1/2.jpg",
			    "https://i.dummyjson.com/data/products/1/3.jpg",
			    "https://i.dummyjson.com/data/products/1/4.jpg",
			    "https://i.dummyjson.com/data/products/1/thumbnail.jpg"};
		
		data.put("images",imagesArr);
		
		System.out.println(data.toString());
		
		Response res =
		given()
		.contentType("application/json")
		.body(data.toString())
		.when()
		.post("https://dummyjson.com/products/add")
		.then()
		.extract().response();
		
		assertEquals(res.jsonPath().get("title"), "Redmi Note 12 Pro");
		
		System.out.println(res.asPrettyString());
	}

}
