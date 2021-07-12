package com.ssd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ssd.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			int empId = 1;

			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve employee based on the id: (i.e. primary key)
			System.out.println("\nGetting employee with id: " + empId);

			Employee myEmployee = session.get(Employee.class, empId);

			// delete the employee
			// System.out.println("Deleting employee: " + myEmployee);
			// session.delete(myEmployee);

			// delete employee id=2 (another way of deleting object or row)
			System.out.println("Deleting employee id=2");
			session.createQuery("delete from Employee where id=2").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}
}
