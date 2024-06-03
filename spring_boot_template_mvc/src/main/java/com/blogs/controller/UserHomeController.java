package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserHomeController {
	public UserHomeController() {
		
		System.out.println("in construct of "+getClass());
		
	}
	//add the method to render the login page
	@GetMapping("/")
	public String showLoginForm() {
		System.out.println("show login form");
		return "/users/login";//handler is returning lvn to dispatcher
		//
		
	}

}
