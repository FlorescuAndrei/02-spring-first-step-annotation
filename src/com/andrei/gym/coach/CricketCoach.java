package com.andrei.gym.coach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.andrei.gym.fortune.FortuneService;

@Component
public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("criket@email.com")					//inject literal value
	private String emailAddress;
	
	@Value("${foo.logo}")						//inject property value
	private String logo;
	

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	
	
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside method: setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}



	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside method: setter method - setEmailAdress");
		this.emailAddress = emailAddress;
	}

	
	public String getEmailAddress() {
		return emailAddress;
	}

	
	@Override
	public String getDailyWorkout() {
		
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		
		return  "Cricket fortune: " + fortuneService.getFortune();
	}
	
	

}
