package com.quiz.QuizifyServer.service;

import java.util.List;

import com.quiz.QuizifyServer.entity.Category;

public interface ICategoryService {
	
	public List<Category> getCategories();
	
	public Category getCategoryById(Integer id);
	
	public Category insertCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public void deleteCategory(Integer id);	

}
