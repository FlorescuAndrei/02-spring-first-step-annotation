package com.andrei.gym.fortune;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	String[] fortunes = {"Beware of the wolf in sheep clothing", "Diligence is the mother of good luck", 
						"The journey is the reward", "Realy... there is no fortune"};
	Random random = new Random();

	@Override
	public String getFortune() {
		int i= random.nextInt(fortunes.length);
		System.out.println(i);
		return fortunes[i];
	}

}
