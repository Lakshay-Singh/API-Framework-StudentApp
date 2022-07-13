package com.student.requests;

import com.student.tests.TestBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RequestFactory extends TestBase {
	
	public Response getAllStudents() {
		Response response=RestAssured.given()
		   	         					.when()
		   	       .get("/list");
		return response;
	}
}
