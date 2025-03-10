package com.blogs.service;

import java.util.List;

import com.blogs.entities.Category;



public interface CategoryService  {
	List<Category> getAllCategories();
	Category addNewCategory(Category newCategory);
    String deleteCategoryDetails(Long catid);
    Category getCategoryDetails(Long cati);
    Category updateCategoryDetails(Category category);
}