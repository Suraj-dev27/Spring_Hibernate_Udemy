package com.ssd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ssd.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create a employee object
			System.out.println("Createing employee object...");
			Employee tempEmployee = new Employee("Daffy", "Duck", "Disney");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the employee...");
			System.out.println(tempEmployee);
			session.save(tempEmployee);

			// commit transaction
			session.getTransaction().commit();

			// my new code to read object

			// find out the employee's id: primary key
			System.out.println("Saved Employee. Generated id: " + tempEmployee.getId());

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student based on the id: (i.e. primary key)
			System.out.println("\nGetting employee with id: " + tempEmployee.getId());

			Employee myEmployee = session.get(Employee.class, tempEmployee.getId());

			System.out.println("Get complete: " + myEmployee);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}
}
