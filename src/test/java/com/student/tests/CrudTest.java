package com.student.tests;

import org.junit.Test;

import com.student.requests.RequestFactory;

import io.qameta.allure.Story;
import io.restassured.RestAssured;

@Story("CRUD Testing Story")
public class CrudTest extends TestBase{
	
	RequestFactory request=new RequestFactory();
	
	@ Test
	public void getAllStudents() {
		
		request.getAllStudents().then().statusCode(200);
	}
}
