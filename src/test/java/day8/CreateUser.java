package day8;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {

	
	@Test
	
	void test_createUser(ITestContext context){
		
		Faker faker=new Faker();
		JSONObject data = new JSONObject();
		
		data.put("name",faker.name().fullName() );
		data.put("gender", "Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken ="301e39457427b826f521b59308d6dbd03799660b91158df40360f81aaa999783";
		
		int id =given()
			.header("Authorization","Bearer "+ bearerToken)
			.contentType("application/json")
			.body(data.toString())
		.when()
		     .post("https://gorest.co.in/public/v2/users")
		     .jsonPath().getInt("id");
		
		System.out.println("generated id :"+id);
		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
		
	}
	
}
