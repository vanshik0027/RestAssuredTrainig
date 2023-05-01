package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class cookiesDemo {

	//@Test(priority = 1)
	void testCookies() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
			//.cookie("AEC","AUEFqZeX9Z0cwrSe5iT8e8jDucjnXXr2WeO0BMH9McNOXMdYNazGbOATCw")
			.log().all();
	}
	@Test(priority = 2)
	void getCookiesinfo() {
		
		Response res =given()
		
		.when()
			.get("https://www.google.com/");
		//get single cookie info
//		String Cookie_value = res.getCookie("AEC");
//		System.out.println("value of cookie is==="+Cookie_value);
		
		Map<String,String> cookies_value = res.getCookies();
		
		for(String k:cookies_value.keySet()) {
			
			String cookie_value= res.getCookie(k);
			System.out.println(k+ "=  " +cookie_value);
			
		}
		
	}
}
