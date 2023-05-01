package day6;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.internal.http.Status;

public class JSONSchemaValidation {

	@Test
	void jsonSchemaAValidation() {
		
		given()
		
		.when()
		.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200);
		//	.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeJsonSchema.json"));
		
		
		
	}
}
