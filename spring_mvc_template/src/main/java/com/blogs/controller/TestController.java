package com.blogs.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mandatory class level controller to tell sc , 
//following is req handling spring bean
//singleton and eager
public class TestController {
	public TestController() {
		System.out.println("in constructor of " + getClass());
		
	}
	//add init method
	@PostConstruct
	public void myInit() {
		System.out.println("in init of "+ getClass());
	}
	//add request handling mthod to frd the clnt to view layer to  display  the welcome msg
	@RequestMapping("/test1")
	public String testMe() {
		System.out.println("in test me");
		return "/display";//=> llogical  view name (lvn) , handler returns to dispatcher servlet  ->
		//dispatcher servlet => view resolver bean => puts in avn(prefix+lvn+suffix)  actual view name
	    //avn - /web-Inf/view/welcome.jsp
	}

}
