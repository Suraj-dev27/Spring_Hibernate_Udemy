package com.ssd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ssd.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int studentId = 1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: (i.e.primary key)
			System.out.println("\nGetting student with id: " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby"); // here we only updated values in memory after commit it will be updated
												// in db, no need to explicitly say save

			// commit the transaction
			session.getTransaction().commit();

			// NEW code

			session = factory.getCurrentSession();
			session.beginTransaction();

			// update email for all students
			System.out.println("Update email for all students");

			session.createQuery("update Student set email='foo@yahoo.com'").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
