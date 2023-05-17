package com.quiz.QuizifyServer.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public List<Category> getCategories() {
		return categoryRepo.findAll();
	}
	
	@Override
	@Transactional
	public Category getCategoryById(Integer id) {
		return categoryRepo.findById(id).get();
	}
	
	@Override
	@Transactional
	public Category insertCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	@Transactional
	public Category updateCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	@Override
	@Transactional
	public void deleteCategory(Integer id) {
		categoryRepo.deleteById(id);
	}

}
