package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

/* Spring will automatically register this bean */
@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Prcatice your backhand volley";
	}

}
