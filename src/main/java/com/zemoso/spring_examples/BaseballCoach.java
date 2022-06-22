package com.zemoso.spring_examples;

import org.springframework.beans.factory.annotation.Value;

public class BaseballCoach implements Coach {

	@Value("${coach.email}")
	private String email;

	@Value("${coach.team}")
	private String team;
	FortuneService fortuneService;
	public BaseballCoach(FortuneService fortuneService){
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

	public String getEmail(){
		return email;
	}

	public String getTeam(){
		return team;
	}
}








