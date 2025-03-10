package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoriesController {
	public CategoriesController() {
		System.out.println("making for database categories in cntr of "+ getClass());
	}
	
	@GetMapping("/list")
	public ModelAndView listAllCatgories() {
		System.out.println("in list all categories");
		return new ModelAndView("/categories/list","category_list",null);
		//avn = /webinf/views/categories/list.jsp
	}

}
