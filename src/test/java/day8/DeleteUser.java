package day8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {

	@Test
	void test_deleteUser(ITestContext context) {
		int id = (Integer) context.getSuite().getAttribute("user_id");
		String bearerToken ="301e39457427b826f521b59308d6dbd03799660b91158df40360f81aaa999783";

		
		given()
		  .header("Authorization", "Bearer "+ bearerToken)
		  .pathParam("id", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
		.statusCode(204)
		.log().all();
		
		
		
	}
}
