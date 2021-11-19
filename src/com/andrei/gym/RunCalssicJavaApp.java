package com.andrei.gym;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.andrei.gym.coach.BaseballCoach;
import com.andrei.gym.coach.Coach;
import com.andrei.gym.coach.TrackCoach;
import com.andrei.gym.fortune.FortuneService;
import com.andrei.gym.fortune.HappyFortuneService;

//Classic java app. No Spring. No bean. No configuration

public class RunCalssicJavaApp {
	
	
	
	public static void main(String[] args) {
		
		FortuneService fortuneService= new HappyFortuneService();
		Coach theCoach = new BaseballCoach(fortuneService);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
	}

}
