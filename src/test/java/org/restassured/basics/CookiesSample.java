package org.restassured.basics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesSample {

	@Test
	public void cookieSampleTest() {		
		Response res =
				given()

				.when()
				//Request Type
				.get("https://www.google.com") 
				
				.then()
				//Validations
				.extract().response();

		
		System.out.println("Cookie Value is "+res.getCookie("AEC"));
		// To Extract All Keys at once
		
		Map<String, String> cookies = res.getCookies();
		System.out.println("Total Cookies Found "+cookies.size());
		for(String eachKey : cookies.keySet()) {
			System.out.println("Printing Cookie Value for Key : "+eachKey);
			System.out.println(cookies.get(eachKey));
		}
		
		System.out.println(res.asPrettyString());
	}

}
