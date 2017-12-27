package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/* default bean id is class name in camel case */
@Component
@Scope("prototype")
public class TennisCoach implements Coach {

	/* Field Injection here */
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	/* Literal Value Injection */
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService= theFortuneService;
//	}
	
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Prcatice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
