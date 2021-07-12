package com.ssd.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class ArcheryCoach implements Coach {

	private FortuneService fortuneService;

	// referencing/ injecting sport.properties file's values from spring config
	@Value("${foo.email}")
	private String email;

	@Value("${foo.team}")
	private String team;

	public ArcheryCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice today with wind";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

}
