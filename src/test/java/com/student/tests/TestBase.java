package com.student.tests;

import org.junit.BeforeClass;

import com.student.util.PropertyReader;

import io.restassured.RestAssured;

public class TestBase {
	public static PropertyReader prop;
	
	@BeforeClass
	public static void init() {
		prop=PropertyReader.getInstance();
		
		RestAssured.baseURI=prop.getProperty("baseUrl");
		RestAssured.port=Integer.valueOf(prop.getProperty("port"));
		RestAssured.basePath=prop.getProperty("basePath");
	}
}
