package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext ctx =
			new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		TennisCoach theCoach = ctx.getBean("tennisCoach", TennisCoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call a method with dependency injection
		System.out.println(theCoach.getDailyFortune());
		
		// call getter methods with literal value injection
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		
		
		// close the context
		ctx.close();
		
	}

}
