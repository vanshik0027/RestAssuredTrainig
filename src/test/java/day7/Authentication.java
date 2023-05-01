package day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


   public class Authentication {
	
	   //@Test(priority = 1)
	   void testBasicAuthentication() {
		   given()
		   		.auth().basic("postman", "password")
		   .when()
		   		.get("https://postman-echo.com/basic-auth")
		   .then()
		   		.statusCode(200)
		   		.body("authenticated",equalTo(true))
	   		    .log().all();
	
	
	   }
	   //@Test(priority = 2)
	   void testDigestAuthentication() {
		   given()
		   		.auth().digest("postman", "password")
		   .when()
		   		.get("https://postman-echo.com/basic-auth")
		   .then()
		   		.statusCode(200)
		   		.body("authenticated",equalTo(true))
		   		.log().all();
	   			}
	   //@Test(priority = 3)
	   void testPreemptiveAuthentication() {
		   given()
		   		.auth().preemptive().basic("postman", "password")
		   .when()
		   		.get("https://postman-echo.com/basic-auth")
		   .then()
		   		.statusCode(200)
		   		.body("authenticated",equalTo(true))
		   		.log().all();
	   			}
	  // @Test(priority = 4)
	   void testBearerTokenAuthentication() {
		   
		   String bearerToken="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";
		   
		   	given()
		   		.headers("Authorization","Bearer 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")
		   	.when()
		   		.get("https://api.github.com/user/repos")
		   	
		   	.then()
		   		.statusCode(200)
		   		.log().all();
		   	
		   	
	   }
	 //  @Test
	   void testOAuthentication() {
		   given()
		   //this is for oauth1.0 Authentication
		     .auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokenSecrate")
		   .when()
		   
		   .get("url")
		   
		   .then()
		   .statusCode(200)
		   .log().all();
	   }
	   
	 //  @Test
	   void testOAuth2Authentication() {
		   
		   given()
		   //this is for oauth1.0 Authentication
		     .auth().oauth2("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")
		   .when()
		   
		   .get("https://api.github.com/user/repos")
		   
		   .then()
		   .statusCode(200)
		   .log().all();
		   
	   }
	   @Test
	   void testAPIkeyAuthentication() {
//		   Method1
//		   given()
//		   		.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")//appid 
//		   .when()
//		   	.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
//		   
//		   .then()
//		   .statusCode(200)
//		   .log().all();
		   given()
		   	.queryParam("appid","fe9c5cddb7e01d747b4611c3fc9eaf2c")
		   	.pathParam("mypath", "data/2.5/forecast/daily")
		   	.queryParam("q", "Delhi")
		   	.queryParam("units", "metric")
		   	.queryParam("cnt", "7")
		   	
		   	.when()
		   		.get("https://api.openweathermap.org/{mypath}")
		   		.then()
				   .statusCode(200)
			   .log().all();
	   }
}
