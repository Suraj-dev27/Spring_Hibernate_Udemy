package com.ssd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ssd.hibernate.demo.entity.Employee;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create 3 student objects
			System.out.println("Creating 3 employee objects...");
			Employee tempEmployee1 = new Employee("Abhi", "Patil", "Canara Bank");
			Employee tempEmployee2 = new Employee("Jitendra", "Mangle", "Tata Power");
			Employee tempEmployee3 = new Employee("Shubhankar", "kale", "MRF");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the employees...");
			session.save(tempEmployee1);
			session.save(tempEmployee2);
			session.save(tempEmployee3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

}
