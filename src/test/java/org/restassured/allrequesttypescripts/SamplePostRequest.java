package org.restassured.allrequesttypescripts;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

/**
 * Sample Post Request 
 *
 * @author Ritesh Mansukhani
 *
 */
public class SamplePostRequest {
	
	@Test
	public void createUser() {
		HashMap<String, String> data = new HashMap <String,String>();
		data.put("name","ritesh");
		data.put("job","trainer");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then()
		.assertThat().statusCode(201)
		.log().all(); //To Print entire Response on Console
		
	}

}
