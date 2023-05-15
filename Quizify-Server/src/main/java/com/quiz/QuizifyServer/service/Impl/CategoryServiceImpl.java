package com.quiz.QuizifyServer.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.QuizifyServer.entity.Category;
import com.quiz.QuizifyServer.persistance.ICategoryRepository;
import com.quiz.QuizifyServer.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ICategoryRepository categoryRepo;
	
	@Override
	public List<Category> getCategories() {
		return categoryRepo.findAll();
	}
	
	@Override
	public Category getCategoryById(Integer id) {
		return categoryRepo.findById(id).get();
	}
	
	@Override
	public Category insertCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	@Override
	public void deleteCategory(Integer id) {
		categoryRepo.deleteById(id);
	}

}
