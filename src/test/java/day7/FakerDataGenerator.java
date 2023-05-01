package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	
	
	@Test
	void testGenerateDummyData() {
		
	   Faker faker= new Faker();
	   String fullname =faker.name().fullName();
	   String username = faker.name().username();
	   String password = faker.internet().password();
	   
	   String email=faker.internet().safeEmailAddress();
	   
	   System.out.println("Full Name: "+fullname);
	   System.out.println("username: "+username);
	   System.out.println("password: "+password);
	   System.out.println(" email: "+email);
	   
		
		
		
		
		
		
		
	}
	

}
