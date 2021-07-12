package com.ssd.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ssd.hibernate.demo.entity.Course;
import com.ssd.hibernate.demo.entity.Instructor;
import com.ssd.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// option 2: Hibernate query with HQL

			// get the instructor from db
			int theId = 1;

			Query<Instructor> query = session.createQuery(
					"select i from Instructor i " + "JOIN FETCH i.courses " + "where i.id=:theInstructorId",
					Instructor.class);

			// set parameter on query
			query.setParameter("theInstructorId", theId);

			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult(); // Load instructor and courses all at once

			System.out.println("ssd: Instructor: " + tempInstructor);

			// get courses for the instructor (this code is pasted below to check
			// exceptions)
			// System.out.println("ssd: Courses:" + tempInstructor.getCourses());

			// commit transaction
			session.getTransaction().commit();

			// close the session
			session.close();
			System.out.println("\nssd: The session is now closed!\n");

			// option 1: call getter method while session is open

			// get courses for the instructor
			System.out.println("ssd: Courses:" + tempInstructor.getCourses());

			System.out.println("ssd: Done!");

		} finally {
			// add clean up code
			session.close();

			factory.close();
		}

	}

}
