package com.hiberatetutorial.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiberatetutorial.student.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		

		//create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		//create session object
		Session session = factory.getCurrentSession();

		try {

			System.out.println("Creating 3 new Student object....");
			//create 2 new student object
//			Student theStudent1 = new Student("Pragati","Chouhan Pawar","raspawar@gmail.com");
//			Student theStudent2 = new Student("Loken SIngh","Pawar","pspawar@gmail.com");
//			Student theStudent3 = new Student("Sudha","Pawar","sudha.pawar@gmail.com");
			System.out.println("Student objects created....");

			//start a  transaction
			session.beginTransaction();

			//save the student object
			System.out.println("Saving....");
//			session.save(theStudent1);
//			session.save(theStudent2);
//			session.save(theStudent3);
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
