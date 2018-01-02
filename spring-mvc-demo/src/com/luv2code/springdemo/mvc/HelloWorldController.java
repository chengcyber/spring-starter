package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("hello") /* parent mapping */
public class HelloWorldController {

	// need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// need a controller method to process the form data
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	// a version 2 controller to upper case student name
	@RequestMapping("/processFormVersionTwo")
	public String letsSHoutDude(HttpServletRequest request, Model model) {
		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		// convert data all upper case
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName; 
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	// a version 3 controller to upper case student name
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName,
			Model model) {
		// read the request parameter from the HTML form
		
		// convert data all upper case
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey My Friend From v3! " + theName; 
		
		// add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
}
