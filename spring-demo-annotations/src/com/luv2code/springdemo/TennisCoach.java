package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

/* default bean id is class name in camel case */
@Component
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Prcatice your backhand volley";
	}

}
