package com.hibernate_tutorial.jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker_schema?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudents";
		try {
			System.out.println("Connecting to database : "+jdbcUrl);
			System.out.println("Authenticating....");
			Connection myCon = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection established successfully....");
		} 
		catch (Exception e) {
			System.out.println("invalid username or password");
			e.printStackTrace();
			
		}
	}

}
