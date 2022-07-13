package com.student.requests;

import java.util.List;

import com.student.pojo.StudentPOJO;
import com.student.tests.TestBase;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class RequestFactory extends TestBase {
	RestClient restClient=new RestClient();
	
	@Step("Getting all the student info")
	public Response getAllStudents() {
		Response response=restClient.doGetRequest("/list");
		return response;
	}
	
	@Step("Create a new Student: firstname: {1}, lastName: {2}, email: {3}, programme: {4},courses: {5}")
	public Response createNewStuent(String url, String firstName, String lastName, String email, String programme, List<String> courses) {
		StudentPOJO body=new StudentPOJO();
		body.setFirstName(firstName);
		body.setLastName(lastName);
		body.setEmail(email);
		body.setProgramme(programme);
		body.setCourses(courses);
		
		Response response=restClient.doPostRequest(url,body);
		return response;
	}
	
	@Step("Updating a Student with studentId: {0}, firstname: {1}, lastName: {2}, email: {3}, programme: {4},courses: {5}")
	public Response updateStuent(int studentId, String firstName, String lastName, String email, String programme, List<String> courses) {
		StudentPOJO body=new StudentPOJO();
		body.setFirstName(firstName);
		body.setLastName(lastName);
		body.setEmail(email);
		body.setProgramme(programme);
		body.setCourses(courses);
		
		return restClient.doPutRequest("/"+studentId,body);
	}
	
	@Step("Delete Student with Id: {0}")
	public Response deleteStudent(int StudentId) {
		return restClient.doDeleteRequest("/"+StudentId);
	}
	
	@Step("Get Student with Id: {0}")
	public Response getStudentById(int StudentId) {
		return restClient.doGetRequest("/"+StudentId);
	}
}
