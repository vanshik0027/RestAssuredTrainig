package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {

	//@Test
	void singleFileupload()
	
	{
		File myfile =new File("Given File URL");
	given()
	  .multiPart("file",myfile)
	  .contentType("multipart/form-data")
	.when()
	.post("http://localhost:8080/uploadFile")
	
	.then()
		.statusCode(200)
		.body("filename",equalTo("filename.txt"))
		.log().all();
	
}
	@Test
	void MultipleFileupload()
	
	{
		File myfile1 =new File("Given File URL");
		File myfile2 =new File("Given File URL");
		
		File filearrr[] = {myfile1,myfile2};
		
	given()
	  .multiPart("file",filearrr)
	  .contentType("multipart/form-data")
	.when()
	.post("http://localhost:8080/uploadFile")
	
	.then()
		.statusCode(200)
		.body("[0].filename",equalTo("filename1.txt"))
		.body("[1].filename",equalTo("filename2.txt"))
		.log().all();
	
}
	
	@Test
	
	void fileDownload() {
		given()
		
		.when()
			.get("http://localhost:8080/uploadFile/Test1.txt")
		
		.then()
			.statusCode(200)
			.log().body();
		
		
	}
}
