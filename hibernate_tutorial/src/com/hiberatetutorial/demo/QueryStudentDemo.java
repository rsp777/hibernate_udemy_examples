package com.hiberatetutorial.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiberatetutorial.student.Student;


public class QueryStudentDemo {

	public static void main(String[] args) {

		//create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		//create session object
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
          List<Student> myStudent = session.createQuery("from Student s where "
          		+ "s.email LIKE '%.pawar@gmail.com' ").list();
			//start a  transaction
			

			for (Student student : myStudent) {
				System.out.println(student);
			}
			//commit the  transaction
			session.getTransaction().commit();
			System.out.println("Task Completed....");
		} 
		catch (Exception e) {
			factory.close();
		}
	}

}
