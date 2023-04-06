package org.restassured.pathandqueryparameters;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PathAndQueryParameters {

	@Test
	public void testPathAndQueryParameters() {		

		//URL is https://reqres.in/api/users?page=2
		Response res =
				given()
				//Pre-Requiqsites
				.pathParam("mypath","users")
				.queryParam("page", "2")

				.when()
				//Request Type
				.get("https://reqres.in/api/{mypath}") // Please note Query Parameters are embedded automatically as specified in given
				
				.then()
				//Validations
				.extract().response();

		assertEquals(res.jsonPath().get("page"), 2);
		System.out.println(res.asPrettyString());
	}

}
