package day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//pojo ---serilization---->json Object----de-serialization---> POJO
public class serialiazationDeserialization {
	
	//@Test
	void covertPojo2Json() throws JsonProcessingException {
		
		//created java object using pjo class
		student  stupojo=new student();
		stupojo.setName("scott");
		stupojo.setLocation("france");
		String coursesArr[] = { "c", "c++" };
		
		stupojo.setCourses(coursesArr);
//		covert java object ----> json Object(serilization)
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsondata =objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		
		System.out.println(jsondata);
	}
	
	//json --->Pojo
	@Test
	void covertJson2POJO() throws JsonProcessingException {
		String jsondata ="{\r\n"
				+ "  \"name\" : \"scott\",\r\n"
				+ "  \"location\" : \"france\",\r\n"
				+ "  \"courses\" : [ \"c\", \"c++\" ]\r\n"
				+ "}";
		//covert json data --> Pojo Object
		
		ObjectMapper objMapper = new ObjectMapper();
		
		student stupojo = objMapper.readValue(jsondata, student.class);
		
		System.out.println("name :"+stupojo.getName());
		System.out.println("Location :"+ stupojo.getLocation());
		System.out.println("Courses : "+stupojo.getCourses()[0]);
		System.out.println("Courses : "+stupojo.getCourses()[1]);
		
		
		
	}
	

}
