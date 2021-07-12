package com.ssd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ssd.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create a employee object
			System.out.println("Createing employee object...");
			Employee tempEmployee = new Employee("Rekha", "Patil", "Mhalewadi Path-Sanstha");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the employee...");
			session.save(tempEmployee);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}
}
