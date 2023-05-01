package day5;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import java.util.List;

public class ParsingXMLResponse {
	
	@Test
	void testXMLRespose() {
		//Approach1
		
//		given()
//		
//		.when()
//			.get("http://restapi.adequateshop.com/api/traveler?page=1")
//		
//		.then()
//		 .statusCode(200)
//		 .header("content-Type","application/xml; charset=utf-8" )
//		 .body("TravelerinformationResponse.page",equalTo("1"))
//		 .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
		
		
//		Approach2
		Response res =
				given()
				.when()
				.get("http://restapi.adequateshop.com/api/traveler?page=1");
		
//		Assert.assertEquals(res.getStatusCode(),200);
//		Assert.assertEquals(res.header("content-Type"), "application/xml; charset=utf-8");
//		String pageNO = res.xmlPath().get("TravelerinformationResponse.page").toString();
//		Assert.assertEquals(pageNO, "1");
//		
//	    String	travelName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
//		Assert.assertEquals(travelName, "Developer");
		
		XmlPath xmlobj =new  XmlPath(res.asString());
		//verify  total numbers of travellers
		List<String> travellers = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);
		
		//verify travellers name is present in response
		List<String> travellersName = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
        boolean status = false; 
		for(String traveller_name :travellersName) {
        	 if(traveller_name.equals("Developer")) {
        		 status = true;
        		 break;
        	 }
        	 
         }
		Assert.assertEquals(status, true);
		
	}

}
