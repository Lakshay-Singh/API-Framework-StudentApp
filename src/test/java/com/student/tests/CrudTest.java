package com.student.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;

import io.qameta.allure.Story;
import io.restassured.RestAssured;

@Story("CRUD Testing Story")
public class CrudTest extends TestBase{
	
	RequestFactory requests=new RequestFactory();
	
	@Test
	public void getAllStudents() {
		
		requests.getAllStudents().then().statusCode(200);
	}
	
	@Test
	public void createNewStudent() {
		Faker fake=new Faker();
		String firstName=fake.name().firstName();
		String lastName=fake.name().lastName();
		String email=fake.internet().emailAddress();
		String programme="Analyst";
		List<String> courses=new ArrayList<String>();
		courses.add("Data Mining");
		courses.add("Excel");
		
		requests.createNewStuent("", firstName, lastName, email, programme, courses).then().statusCode(201);
	}
	
	@Test
	public void updateStudent() {
		Faker fake=new Faker();
		String firstName=fake.name().firstName();
		String lastName=fake.name().lastName();
		String email=fake.internet().emailAddress();
		String programme="Financial Analysis";
		List<String> courses=new ArrayList<String>();
		courses.add("Data Mining");
		courses.add("Excel");
		
		requests.updateStuent(2, firstName, lastName, email, programme, courses).then().statusCode(201);
	}
	
	@Test
	public void deleteStudent() {
		requests.deleteStudent(5).then().statusCode(200);
	}
}
