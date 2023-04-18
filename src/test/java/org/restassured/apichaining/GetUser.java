package org.restassured.apichaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


/**
 * https://petstore.swagger.io/
 * Request URL for Create User
 * https://petstore.swagger.io/v2/user
 * @author admin
 *
 */


public class GetUser {

	@Test
	public void test_GetUser(ITestContext context){


		given()
		.contentType("application/json")
		//Ideally We would user Context Attribute username to access the user created in other test method
		.pathParam("username", context.getSuite().getAttribute("username"))
		//We are using hard coded value here since this demo api only supports string as username for GET request
		//.pathParam("username","string")
		
		.when()
		.get("https://petstore.swagger.io/v2/user/{username}")
		.then()
		.statusCode(200)
		.log().all();

	}


}
