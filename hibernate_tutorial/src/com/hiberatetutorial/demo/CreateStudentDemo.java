package com.hiberatetutorial.demo;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiberatetutorial.dateutils.DateUtils;
import com.hiberatetutorial.student.Student;


public class CreateStudentDemo {

	public static void main(String[] args) {

		//create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		//create session object
		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating a new Student object....");
			//create a student object
			String dob = "01/12/1996";
			LocalDate dateOfBirth = DateUtils.parsed(dob);
			Student theStudent = new Student("Ravindra Singh","Pawar","ravindra.pawar@gmail.com",dateOfBirth);
			System.out.println("Student object created....");

			//start a  transaction
			session.beginTransaction();

			//save the student object
			System.out.println("Saving....");
			session.save(theStudent);
			System.out.println("Saved");

			//commit the  transaction
			session.getTransaction().commit();
			System.out.println("Task Completed....");
		} 
		catch (Exception e) {
			factory.close();
		}
	}

}
