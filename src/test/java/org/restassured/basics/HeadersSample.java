package org.restassured.basics;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersSample {

	@Test
	public void headerSampleTest() {		
		Response res =
				given()

				.when()
				//Request Type
				.get("https://www.google.com") 
				
				.then()
				.header("Server","gws") // We can use header method to perform validation on header
				//Validations
				.extract().response();

		
		System.out.println("Header Value is "+res.getHeader("Content-Type"));
		// To Extract All Keys at once
		
		Headers headers = res.getHeaders();
		headers.size();
		System.out.println("Total Headers found "+headers.size());
		for(Header eachHeader : headers) {
			System.out.println("Printing Header Name : "+eachHeader.getName());
			System.out.println("Printing Header Value : "+eachHeader.getValue());
		}
	}

}
