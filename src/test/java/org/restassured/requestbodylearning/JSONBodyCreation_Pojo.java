package org.restassured.requestbodylearning;

import static org.testng.Assert.assertEquals;
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

public class JSONBodyCreation_Pojo {
	
	/**
	 * In this Example We are using POJO Class to Create Request Body
	 */
	
	@Test
	public void requestBodyUsingPojo() {
		Products_Pojo data = new Products_Pojo() ;
		data.setTitle("Redmi Note 12 Pro");
		data.setDescription("Redmi Note 12 Pro Latest Phone");
		data.setPrice(16581);
		data.setDiscountPercentage(15.23);
		data.setRating(4);
		data.setStock(1000);
		data.setBrand("Xiaomi");
		data.setCategory("Smartphones");
		data.setThumbnail("https://i.dummyjson.com/data/products/1/thumbnail.jpg");
		
		String imagesArr[] = {"https://i.dummyjson.com/data/products/1/1.jpg",
				"https://i.dummyjson.com/data/products/1/2.jpg",
			    "https://i.dummyjson.com/data/products/1/3.jpg",
			    "https://i.dummyjson.com/data/products/1/4.jpg",
			    "https://i.dummyjson.com/data/products/1/thumbnail.jpg"};
		
		data.setImagesArr(imagesArr);
		
		Response res =
		given()
		.contentType("application/json")
		.body(data)
		.when()
		.post("https://dummyjson.com/products/add")
		.then()
		.extract().response();
		
		assertEquals(res.jsonPath().get("title"), "Redmi Note 12 Pro");
		System.out.println("****Response Body Printed ***********");
		System.out.println(res.asPrettyString());
	}

}
