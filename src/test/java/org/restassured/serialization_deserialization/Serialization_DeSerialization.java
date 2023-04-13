package org.restassured.serialization_deserialization;

import org.restassured.requestbodylearning.Products_Pojo;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization_DeSerialization {
	
	/**
	 * Serialization
	 * @throws JsonProcessingException 
	 */
	
	@Test
	public void convertPojo_toJSON() throws JsonProcessingException {
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
		
		System.out.println(imagesArr[1]);
		data.setImages(imagesArr);
		System.out.println(data.getImages()[2]);
		
		// Convert Pojo to JSON
		ObjectMapper objMapper = new ObjectMapper();
		String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsonData);
	}
	
	/**
	 * De-Serialize Convert Json to Pojo
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 * 
	 */
	@Test
	public void convertJson_toPojo() throws JsonMappingException, JsonProcessingException {
		
		String json_data = "{\r\n"
				+ "  \"title\" : \"Redmi Note 12 Pro\",\r\n"
				+ "  \"description\" : \"Redmi Note 12 Pro Latest Phone\",\r\n"
				+ "  \"price\" : 16581,\r\n"
				+ "  \"discountPercentage\" : 15.23,\r\n"
				+ "  \"rating\" : 4,\r\n"
				+ "  \"stock\" : 1000,\r\n"
				+ "  \"brand\" : \"Xiaomi\",\r\n"
				+ "  \"category\" : \"Smartphones\",\r\n"
				+ "  \"thumbnail\" : \"https://i.dummyjson.com/data/products/1/thumbnail.jpg\",\r\n"
				+ "  \"images\" : [ \"https://i.dummyjson.com/data/products/1/1.jpg\", \"https://i.dummyjson.com/data/products/1/2.jpg\", \"https://i.dummyjson.com/data/products/1/3.jpg\", \"https://i.dummyjson.com/data/products/1/4.jpg\", \"https://i.dummyjson.com/data/products/1/thumbnail.jpg\" ]\r\n"
				+ "}";
		
		ObjectMapper objMapper = new ObjectMapper();
		Products_Pojo obj_pojo = objMapper.readValue(json_data, Products_Pojo.class);
		System.out.println("Title :"+obj_pojo.getTitle());
	}
}
