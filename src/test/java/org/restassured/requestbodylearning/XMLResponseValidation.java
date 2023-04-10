package org.restassured.requestbodylearning;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

/**
 * 
 * @author Ritesh Mansukhani
 <TravelerinformationResponse xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
<page>1</page>
<per_page>10</per_page>
<totalrecord>13258</totalrecord>
<total_pages>1326</total_pages>
<travelers>
<Travelerinformation>
<id>11133</id>
<name>Developer</name>
<email>Developer12@gmail.com</email>
<adderes>USA</adderes>
<createdat>0001-01-01T00:00:00</createdat>
</Travelerinformation>
<Travelerinformation>
<id>11134</id>
<name>AS</name>
<email>qweqw@mail.ru</email>
<adderes>USA</adderes>
<createdat>0001-01-01T00:00:00</createdat>
</Travelerinformation>
</travelers>
</TravelerinformationResponse>
 */

public class XMLResponseValidation {
	/**
	 * Validating JSON Response
	 * Approach#1 Directly Using methods in then() section
	 * 
	 */
	@Test
	public void xmlValidation() {
		given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?pages=1")
		.then()
		.statusCode(200)
		.header("content-type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page",equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
	}

	/**
	 * Validating JSON Response
	 * Approach#2 Storing Response in Response Object and Using methods of Response class
	 * 
	 */
	@Test
	public void xmlValidation_UsingResponseObj() {
		Response res = 
				given()
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler?pages=1")
				.then().extract().response();
		Assert.assertEquals(res.statusCode(),200);
		Assert.assertEquals(res.header("content-type"), "application/xml; charset=utf-8");
		Assert.assertEquals(res.xmlPath().get("TravelerinformationResponse.page").toString(),"1");
		Assert.assertEquals(res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name"), "Developer");

	}
}