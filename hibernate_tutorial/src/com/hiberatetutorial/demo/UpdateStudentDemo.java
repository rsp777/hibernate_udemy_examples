package com.hiberatetutorial.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiberatetutorial.student.Student;


public class UpdateStudentDemo {

	public static void main(String[] args) {

		//create Session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		//create session object
		Session session = factory.getCurrentSession();

		try {
			//start a  transaction
//			session.beginTransaction();
//			int studentId = 5;
//			Student student = session.get(Student.class, studentId);
//			
//			//update a name of existing student
//			student.setFirstName("Ravindra Singh ");
//			System.out.println("Record updated....");
//			//commit the  transaction
//			session.getTransaction().commit();
//			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email = 's.pawar@pawar.com'")
								.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Task Completed....");
		} 
		catch (Exception e) {
			factory.close();
		}
	}

}
