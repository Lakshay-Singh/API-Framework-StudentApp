package com.student.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	private static volatile PropertyReader propInstance;
	
	private PropertyReader() {}
	
	public static synchronized PropertyReader getInstance() {
		if(propInstance==null) {
			propInstance=new PropertyReader();
		}	
		return propInstance;
	}
	
	public String getProperty(String propertyName){
		Properties prop=new Properties();
		try {
			InputStream inputstream=getClass().getClassLoader().getResourceAsStream("application.properties");
			prop.load(inputstream);
			if(prop.getProperty(propertyName)!=null) {
				return prop.getProperty(propertyName);
			}
		} catch (IOException e) {
			System.out.println("Property not found");
		}
		return null;
	}
}
