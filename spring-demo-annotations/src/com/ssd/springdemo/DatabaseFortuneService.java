package com.ssd.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	// create an array of strings
	private String[] data = { "Beware of the wolf in sheep'sclothing", "Diligence is the mother of good luck",
			"The journey is the reward", "Today is lucky day" };

	// create a random number generator
	private Random randint = new Random();

	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = randint.nextInt(data.length);

		String theFortune = data[index];
		return theFortune;
	}

}
