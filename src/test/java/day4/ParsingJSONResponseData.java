package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJSONResponseData {

	@Test
	void testJsonresponse() {
		Response res = given()
			.contentType("ContentType.JSON")
		.when()
			.get("https://localhost:3000/store");
//		.then()
//			.statusCode(200)
//			.header("Content-Type","application/json")
//			.body("book[3].tittle",equalTo("The Lord of the Rings"));
			
		
		JSONObject jo =new JSONObject(res);
		boolean status= false;
		for(int i=0;i<jo.getJSONArray("book").length();i++)
			{
			String bookTitle = 	jo.getJSONArray( "book").getJSONObject(i).get("title").toString();
			
			if(bookTitle.equals("the lord of the Rings")) {
				status = true;
				break;
			}
			}
		Assert.assertEquals(status, true);
		// validate total price of books
		double totalprice=0;
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
		String price = 	jo.getJSONArray( "book").getJSONObject(i).get("price").toString();
		totalprice= totalprice+Double.parseDouble(price);
		}
		System.out.println("total price of books is :"+totalprice);
		Assert.assertEquals(totalprice, 53.92);
	}
}
