package com.quiz.QuizifyServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizifyServer.entity.Category;
import com.quiz.QuizifyServer.service.ICategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;

	@GetMapping("categorylist")
	public ResponseEntity<?> displayAll() {
		return ResponseEntity.ok(categoryService.getCategories());
	}

	@GetMapping("categorylist/{categoryId}")
	public ResponseEntity<?> displayCategory(@PathVariable("categoryId") int id) {
		Category cat = categoryService.getCategoryById(id);
		if (cat == null) {
			return new ResponseEntity<String>("Category not found with the given id", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(cat);
	}

	@PostMapping("categorylist")
	public ResponseEntity<Category> insertionCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.insertCategory(category));
	}

	@PutMapping("categorylist")
	public Category updationCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}

	@DeleteMapping("categorylist/{CategoryId}")
	public void deleteCategory(@PathVariable("CategoryId") int id) {
		Category c = categoryService.getCategoryById(id);
		if (c == null) {
			throw new RuntimeException("Category id does not exist");
		}
		categoryService.deleteCategory(id);
//		return "Deleted Category id is: " + id;
	}

}
