package org.restassured.allrequesttypescripts;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

/**
 * Sample Put Request 
 *
 * @author Ritesh Mansukhani
 * {
    "name": "ritesh",
    "job": "trainer",
    "id": "102",
    "createdAt": "2023-03-14T04:32:40.670Z"
	}
 *
 */
public class SamplePutRequest {
	
	@Test
	public void updateUser() {
		HashMap<String, String> data = new HashMap <String,String>();
		data.put("name","ritesh");
		data.put("job","UpdatedJob");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.put("https://reqres.in/api/users/102")
		
		.then()
		.assertThat().statusCode(200)
		.log().all(); //To Print entire Response on Console
		
	}

}
