package com.andrei.gym;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.andrei.gym.coach.Coach;
import com.andrei.gym.coach.CricketCoach;

//Spring with Annotation. Inversion of control . Dependency Injection.

public class RunSpringApp {

	public static void main(String[] args) {
		
		//load Spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		Coach theCoach = context.getBean("baseballCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);
		System.out.println(cricketCoach.getDailyWorkout());
		
		System.out.println(cricketCoach.getDailyFortune());
	
		System.out.println(cricketCoach.getEmailAddress());
		
		System.out.println(cricketCoach.getLogo());
		
		
		Coach trackCoach=context.getBean("trackCoach", Coach.class);
		
		Coach alphaCoach=context.getBean("trackCoach", Coach.class);
		
		
//		//Bean scope. Check if they are the same (singleton vs prototype scope)
		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPointing to the same object " + result);
		System.out.println("\nMemory location for theCoach " + theCoach);
		System.out.println("\nMemory location for theCoach " + theCoach);
		
		
		//Bean life cycle : for prototype scope the destroy method(@PreDestroy) is not call
		//for destroy method to be call must close the context
		
		context.close();

	}

}
