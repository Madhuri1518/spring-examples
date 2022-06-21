package com.zemoso.spring_examples;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Expect heavy traffic this morning!";
	}

}
