package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

/*
 Different way to Create POST Request Body
 1.post request body using HASHMap
 2.post request body creation using Org.Json
 3.post request body creation using POJO Class
 4. post request using external json file Data 
 */

public class DiffWaysToCreatePostRequestBody {
	int id;
//1. create post request body using HASHMap
	//@Test(priority = 1)
	void postUsingHASHMAP() {
		HashMap data = new HashMap();

		data.put("name", "scott");
		data.put("locaion", "France");

		String courseArr[] = { "c", "c++" };
		data.put("courses", courseArr);

	     given().contentType("application/json")
		.body(data)
		
		.when()
		.post("https://localhost:3000/students/4")

		.then()
			.statusCode(201)
			.body("name",equalTo("scott"))
			.body("location", equalTo("France"))
			.body("courses[0]", equalTo("c"))
			.body("courses[1]",equalTo("c++"))
			.header("content-Type","application/json; charset=utf-8")
			.log().all();

		

	}
//2.create post request body creation using Org.Json	
	
	//@Test(priority = 2)
	void postUsingJsonLiberary() {
		
		JSONObject data = new JSONObject();

		data.put("name", "scott");
		data.put("locaion", "France");

		String courseArr[] = { "c", "c++" };
		data.put("courses", courseArr);

	     given().contentType("application/json")
		.body(data.toString())
		
		.when()
		.post("https://localhost:3000/students/4")

		.then()
			.statusCode(201)
			.body("name",equalTo("scott"))
			.body("location", equalTo("France"))
			.body("courses[0]", equalTo("c"))
			.body("courses[1]",equalTo("c++"))
			.header("content-Type","application/json; charset=utf-8")
			.log().all();
             }
	
//3.create post request body creation using POJO Class	
	@Test(priority = 3)
		void postUsingPOJOff() {
			
		POJO_PostRequest data= new POJO_PostRequest();
		data.setName("scott");
		data.setLocation("france");
		String coursesArr[] = { "c", "c++" };
		
        data.setCourses(coursesArr);

        given().contentType("application/json")
			.body(data)
			
			.when()
			.post("https://localhost:3000/students/4")

			.then()
				.statusCode(201)
				.body("name",equalTo("scott"))
				.body("location", equalTo("France"))
				.body("courses[0]", equalTo("c"))
				.body("courses[1]",equalTo("c++"))
				.header("content-Type","application/json; charset=utf-8")
				.log().all();
	             }
	
//4.create post request body creation using extrenal jsonFile	
		@Test(priority = 4)
			void postUsingExtrenalJSONFile() throws FileNotFoundException {
				
			File f= new File(".\\body.json");
			FileReader fr= new FileReader(f);
			JSONTokener jt= new JSONTokener(fr);
			JSONObject data = new JSONObject(jt);
			

	        given().contentType("application/json")
				.body(data.toString())
				
				.when()
				.post("https://localhost:3000/students/4")

				.then()
					.statusCode(201)
					.body("name",equalTo("scott"))
					.body("location", equalTo("France"))
					.body("courses[0]", equalTo("c"))
					.body("courses[1]",equalTo("c++"))
					.header("content-Type","application/json; charset=utf-8")
					.log().all();
		             }
		


//Deleting student record
	@Test(priority = 2)
	void testDelete() {
		
		given()
		.when()
			.delete("https://localhost:3000/students")
		.then()
		
			.statusCode(200);
		
	}

}
