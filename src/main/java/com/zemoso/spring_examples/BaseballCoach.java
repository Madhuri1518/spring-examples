package com.zemoso.spring_examples;

public class BaseballCoach implements Coach {

	FortuneService fortuneService;
	BaseballCoach(FortuneService fortuneService){
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}








