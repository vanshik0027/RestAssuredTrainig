package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import javax.naming.Context;

import org.json.JSONObject;

public class UpdateUser {
	
	@Test
	void test_updateUser(ITestContext context) {
		Faker faker=new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name",faker.name().fullName() );
		data.put("gender", "Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken ="301e39457427b826f521b59308d6dbd03799660b91158df40360f81aaa999783";
		int id = (Integer) context.getSuite().getAttribute("user_id");
		 given()
			.header("Authorization","Bearer "+ bearerToken)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
		.when()
		     .put("https://gorest.co.in/public/v2/users/{id}")
		    
		.then()
			.statusCode(200)
			.log().all();
		
		
		
		
		
	}

}
