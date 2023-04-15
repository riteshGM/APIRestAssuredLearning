package org.restassured.auths;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Authentications_Sample {
	@Test (priority = 1)
	public void test_BasicAuth() {
		given()
		.auth().basic("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
	
	@Test (priority =2)
	public void test_DigestAuth() {
		given()
		.auth().digest("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();		
	}
	
	@Test (priority=3)
	public void test_PreemptiveAuth() {
		given()
		.auth().preemptive().basic("postman","password")
		.when()
		.get("https://postman-echo.com/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated",equalTo(true))
		.log().all();
	}
}
