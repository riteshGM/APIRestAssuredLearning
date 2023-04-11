package org.restassured.requestbodylearning;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
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

public class XMLResponseValidation_UsingXmlPathObj {
	/**
	 * Validating XML Response
	 * Approach#3 Using XmlPath class and it's method to retrieve XML attribute values.
	 * 
	 */
	@Test
	public void xmlValidation_UsingXmlPathObj() {
		Response res = 
				given()
				.when()
				.get("http://restapi.adequateshop.com/api/Traveler?pages=1")
				.then().extract().response();
		
		XmlPath xmlObj = new XmlPath(res.asString());
		//Suppose we want to Verify Total Number of Travellers in a Particualr Page
		int totalTravellers = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation").size();
		System.out.println("Total Travellers found "+totalTravellers);
		Assert.assertEquals(totalTravellers, 10);
		//Suppose we want to verify if traveler named "Developer" is present in a particular page or not
		Assert.assertEquals(xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name").contains("Developer"),true);

	}
}