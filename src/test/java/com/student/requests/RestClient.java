package com.student.requests;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient {
	
	public Response doGetRequest(String requestPath) {
		return given().when().get(requestPath);
	} 
	
	public Response doPostRequest(String endPath, Object body) {
		return given().contentType(ContentType.JSON)
			   .when().body(body).post(endPath);
	} 
	
	public Response doPutRequest(String endPath, Object body) {
		return given().contentType(ContentType.JSON)
			   .when().body(body).put(endPath);
	}
	
	public Response doDeleteRequest(String endPath) {
		return given()
			   .when().delete(endPath);
	}
	
	public Response doPatchRequest(String endPath, Object body) {
		return given()
			   .when().body(body).patch(endPath);
	} 
}
