package com.hiberatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiberatetutorial.student.Student;


public class ReadStudentDemo {

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
		//	Student theStudent = new Student("Sudha","Pawar","sudha.pawar@gmail.com");
			System.out.println("Student object created....");

			//start a  transaction
			session.beginTransaction();

			//save the student object
			System.out.println("Saving....");
//			System.out.println(theStudent);
//			session.save(theStudent);
			System.out.println("Saved");

			//commit the  transaction
			session.getTransaction().commit();
			//find student's id 
//			System.out.println("Saved Student : Generated ID : "+theStudent.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();			
			//retrieve student based on the student id : primary key
//			System.out.println("\nGetting student with "+theStudent.getId());
//			Student student = session.get(Student.class, theStudent.getId());
			
//			System.out.println("Student info retrieve by student id : primary key"+student);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Task Completed....");
		} 
		catch (Exception e) {
			factory.close();
		}
	}

}
