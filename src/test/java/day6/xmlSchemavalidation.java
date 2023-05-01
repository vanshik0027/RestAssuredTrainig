package day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

public class xmlSchemavalidation {
	
	
	
	@Test
	void xmlSchemavalidation() {
		given()
		
		.when()
			.get("http://restapi.adequatshop.com/api/traveler")
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveler.xsd"));
		
	}
	

}
