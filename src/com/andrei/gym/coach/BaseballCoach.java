package com.andrei.gym.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.andrei.gym.fortune.FortuneService;

@Component("baseballCoach")
public class BaseballCoach implements Coach{
	
	private FortuneService fortuneService;
	

	public BaseballCoach(@Qualifier("happyFortuneService")FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		return this.fortuneService.getFortune();
	}
}
