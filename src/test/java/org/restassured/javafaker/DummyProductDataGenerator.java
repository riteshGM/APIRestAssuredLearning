package org.restassured.javafaker;

import org.restassured.requestbodylearning.Products_Pojo;

import com.github.javafaker.Faker;

/**
 * 
 * @author Ritesh Mansukhani
 * In this Program we Generate Products_Pojo Instance utilizing Java Faker to Set
 * Variable values of Products_Pojo
 *
 */

public class DummyProductDataGenerator {

	public static Products_Pojo generateData() {
		Faker dummy = new Faker();
		Products_Pojo data = new Products_Pojo();
		
		data.setTitle(dummy.book().title());
		data.setPrice(dummy.number().randomDigit());
		data.setBrand(dummy.book().author());
		data.setCategory(dummy.book().genre());
		data.setStock(dummy.number().randomDigit());
		return data;
	}

}
