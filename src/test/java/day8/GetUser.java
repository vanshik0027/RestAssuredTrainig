package day8;

import org.testng.annotations.Test;
import org.testng.ITestContext;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import javax.naming.Context;

public class GetUser  {
	
	@Test
	void Getuser(ITestContext context) {
		//int id=(Integer)context.getAttribute("user_id");
		int id = (Integer) context.getSuite().getAttribute("user_id");
		String bearerToken ="301e39457427b826f521b59308d6dbd03799660b91158df40360f81aaa999783";

		
		given()
		  .header("Authorization", "Bearer "+ bearerToken)
		  .pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
		
		
		
	}

}
