package com.ssd.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ssd.hibernate.demo.entity.Employee;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query employees (from hibernate 5.2 onwards replace list() with
			// getResultList() method)
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();

			// display the students
			displayStudents(theEmployees);

			// query employees: lastName='Duck'
			theEmployees = session.createQuery("from Employee e where e.lastName='Duck'").getResultList();

			// display the employees
			System.out.println("\n\nEmployees who have last name of Duck");
			displayStudents(theEmployees);

			// query employees: lastName='Duck' OR firstName='Suraj'
			theEmployees = session.createQuery("from Employee e where e.lastName='Duck' OR firstName='Abhi'")
					.getResultList();

			// display the employees
			System.out.println("\n\nEmployees who have last name of Duck OR first name of Abhi");
			displayStudents(theEmployees);

			// query employees: where company LIKE '%Power'
			theEmployees = session.createQuery("from Employee e where e.company LIKE '%Power'").getResultList();

			// display the employees
			System.out.println("\n\nEmployees who's company ends with 'Power'");
			displayStudents(theEmployees);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Employee> theEmployees) {
		for (Employee tempEmployee : theEmployees) {
			System.out.println(tempEmployee);
		}
	}

}
