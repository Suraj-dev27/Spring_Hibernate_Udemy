package com.ssd.springdemo;

import org.springframework.stereotype.Component;

@Component // taken default Bean id/ Component name
public class KabadiCoach implements Coach {

	public KabadiCoach() {

	}

	@Override
	public String getDailyWorkout() {

		return "Practice for right corner";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
