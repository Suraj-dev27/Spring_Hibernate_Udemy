package com.ssd.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component("thatSillyCoach") // explicitly defined Bean id / Component name

@Component // Default Bean id / Component name (same as class name and lower case the 1st
			// letter i.e. 'tennisCoach')
//@Scope("prototype")
public class TennisCoach implements Coach {

	// Field injection (@Autowired directly applied on field i.e. variable)
	@Autowired
	@Qualifier("databaseFortuneService") // we are using this to call appropriate bean from multiple implementation
											// beans
											// of FortuneService
	private FortuneService fortuneService;

	// define a default constructor
	public TennisCoach() {
		// just to check whether it is called or not(just for own debugging)
		System.out.println(">> TennisCoach: inside default constructor");
	}

	// define my init method
	@PostConstruct // bcoz of java 9 and higher version i need to download jar file
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach: inside of doMyStrtupStuff()");
	}

	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");
	}

	/*
	 * // define a setter method for setter injection
	 * 
	 * @Autowired public void setFortuneService(FortuneService theFortuneService) {
	 * System.out.println(">> TennisCoach: inside setFortuneService() method");
	 * fortuneService = theFortuneService; }
	 */

	/*
	 * // define any method for method injection
	 * 
	 * @Autowired public void doSomeCrazyStuff(FortuneService theFortuneService) {
	 * System.out.println(">> TennisCoach: inside doSomeCrazyStuff() method");
	 * fortuneService = theFortuneService; }
	 */

	/*
	 * // Configure dependency injection with @Autowired annotation
	 * 
	 * @Autowired public TennisCoach(FortuneService theFortuneService) { //
	 * Constructor Injection fortuneService = theFortuneService; }
	 */

	@Override
	public String getDailyWorkout() {

		return "practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
