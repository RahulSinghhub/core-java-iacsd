package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.entities.Category;
import com.blogs.service.CategoryService;



//=> @ controller at class level + @Response body implicitly added on return types
//of req handling mthds @ requestMapping  @ getMapping 
//@PostMapping
@RestController
@RequestMapping("/categories")
public class CategoryController {
	@Autowired//byType
	private CategoryService categoryService;
	public CategoryController() {
		System.out.println("in ctr of " + getClass());
		
	}
	
	@GetMapping
	public List<Category> listAllCategories(){
		System.out.println("in ctr of " + getClass());
		return categoryService.getAllCategories();
	}
	
	@PostMapping
	public Category addNewCategory(@RequestBody Category category) {
		System.out.println("in add new category"+ category);
		return categoryService.addNewCategory(category);
		
	}
	//@pathvariable - method argument level annnotation to bind incoming path var to the method arg 
	@DeleteMapping("/{categoryId}")
	public ApiResponse deleteCategoryDetails(@PathVariable Long categoryId) {
		System.out.println("in del category"+ categoryId);
		return  new ApiResponse(categoryService.deleteCategoryDetails(categoryId));
	}
	
	
	@GetMapping("/{catId}")
	public Category getCategoryDetails(@PathVariable Long catId) {
		System.out.println("in get category"+getClass());
		return categoryService.getCategoryDetails(catId);
	}
	
	@PutMapping
	public Category updateCategoryDetails(@RequestBody Category category) {
		System.out.println("in update"+category);
		return categoryService.updateCategoryDetails(category);
		
	}
	
	

}
