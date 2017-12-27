package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext ctx =
			new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		SwimCoach theCoach = ctx.getBean("swimCoach", SwimCoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call a method with dependency injection
		System.out.println(theCoach.getDailyFortune());
		
		// call new getter methods ... has props values injected
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		// close the context
		ctx.close();
		
	}

}
