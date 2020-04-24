package com.hiberatetutorial.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hiberatetutorial.student.Student;


public class DeleteStudentDemo {

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
//			int id = 14;
//			Student st = session.get(Student.class, id);
//			session.delete(st);
//			session.getTransaction().commit();
			
			session.createQuery("delete from Student where id = 13").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Deleted....");
		} 
		catch (Exception e) {
			factory.close();
		}
	}

}
