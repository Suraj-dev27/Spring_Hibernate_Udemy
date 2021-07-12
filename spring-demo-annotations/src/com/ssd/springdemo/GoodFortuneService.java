package com.ssd.springdemo;

public class GoodFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your Good Day";
	}

}
