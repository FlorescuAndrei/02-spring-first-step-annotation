package com.andrei.gym.coach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.andrei.gym.fortune.FortuneService;

@Component
@Scope("prototype")     //default scope singleton
public class TrackCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	
	public TrackCoach() {
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just Do It " + fortuneService.getFortune();
	}
	
	//bean life cycle. Preferable void method. Method can not accept any argument
	//for java 9 and after must add javax.annotation-api-1.3.2.jar to lib and buildPath
	//for prototype scope, Spring does not call the @PreDestroy method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside doMyStartupStuff");
	}
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside doMyCleanupStuff");
	}

}
