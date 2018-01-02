package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	// solve ambiguous mapping the same method name in HelloWorldController
	@RequestMapping("/showForm")
	public String displayTheForm() {
		return "silly";
	}

}
