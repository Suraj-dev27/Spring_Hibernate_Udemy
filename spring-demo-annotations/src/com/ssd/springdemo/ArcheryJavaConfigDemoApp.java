package com.ssd.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ArcheryJavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				MyPracticeSportConfig.class);

		// get the bean from spring container
		ArcheryCoach theCoach = context.getBean("archeryCoach", ArcheryCoach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());

		// call our new archery coach methods ... has the props values injected
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());

		// close the context
		context.close();
	}
}
