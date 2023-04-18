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


public class CreateUser {

	@Test
	public void test_CreateUser(ITestContext context){
		JSONObject data = new JSONObject();

		Faker faker = new Faker();
		//Using Hard Coded Value since this demo api only supports string as username
		data.put("username", "string");
		data.put("firstName", faker.name().firstName());
		data.put("lastName", faker.name().lastName());
		data.put("email", faker.internet().emailAddress());
		data.put("password", faker.internet().password());
		data.put("phone", faker.phoneNumber().toString());
		data.put("userStatus", 0);

		System.out.println(data.get("username"));

		given()
		.body(data.toString())
		.contentType("application/json")
		.when()
		.post("https://petstore.swagger.io/v2/user")
		.then()
		.statusCode(200)
		.log().all();

		//We set Suite Level Attribute which can be utilized by any Test during Execution
		context.getSuite().setAttribute("username", "string");
	}


}
