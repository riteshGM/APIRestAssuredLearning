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
 * Sample JSON Response
 {
    "page": 2,
    "per_page": 6,
    "total": 12,
    "total_pages": 2,
    "data": [
        {
            "id": 7,
            "email": "michael.lawson@reqres.in",
            "first_name": "Michael",
            "last_name": "Lawson",
            "avatar": "https://reqres.in/img/faces/7-image.jpg"
        },
        {
            "id": 8,
            "email": "lindsay.ferguson@reqres.in",
            "first_name": "Lindsay",
            "last_name": "Ferguson",
            "avatar": "https://reqres.in/img/faces/8-image.jpg"
        },
        {
            "id": 9,
            "email": "tobias.funke@reqres.in",
            "first_name": "Tobias",
            "last_name": "Funke",
            "avatar": "https://reqres.in/img/faces/9-image.jpg"
        },
        {
            "id": 10,
            "email": "byron.fields@reqres.in",
            "first_name": "Byron",
            "last_name": "Fields",
            "avatar": "https://reqres.in/img/faces/10-image.jpg"
        },
        {
            "id": 11,
            "email": "george.edwards@reqres.in",
            "first_name": "George",
            "last_name": "Edwards",
            "avatar": "https://reqres.in/img/faces/11-image.jpg"
        },
        {
            "id": 12,
            "email": "rachel.howell@reqres.in",
            "first_name": "Rachel",
            "last_name": "Howell",
            "avatar": "https://reqres.in/img/faces/12-image.jpg"
        }
    ],
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
 */

public class JSONResponseValidation_UsingJSONObj {

	/**
	 * Validating JSON Response
	 * Approach#3 Using JSONObject Class
	 * 
	 */
	@Test
	public void jsonValidation_UsingJSONObj() {
		Response res = given()
				.contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then().log().body().extract().response();
		
		JSONObject jo = new JSONObject(res.asString());
		boolean found = false;
		for (int i = 0 ; i<jo.getJSONArray("data").length(); i++) {
			String id = jo.getJSONArray("data").getJSONObject(i).get("id").toString();
			if(id.equals("10")) {
				found = true;
				break;
			}
		}
		Assert.assertEquals(found, true);
	}
	
	@Test
	public void jsonValidation_VerifySupport() {
		Response res = given()
				.contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then().log().body().extract().response();
		
		JSONObject jo = new JSONObject(res.asString());
		String url = jo.getJSONObject("support").get("url").toString();
		System.out.println("URL Found as "+url );
		Assert.assertEquals(url,"https://reqres.in/#support-heading");
		
	}
}
