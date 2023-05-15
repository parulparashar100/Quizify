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

import com.quiz.QuizifyServer.entity.Quiz;
import com.quiz.QuizifyServer.service.IQuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private IQuizService quizService;

	@GetMapping("quizlist")
	public ResponseEntity<?> displayQuiz() {
		return ResponseEntity.ok(quizService.getQuizzes());
	}

	@GetMapping("quizlist/{QuizId}")
	public ResponseEntity<?> getQuiz(@PathVariable("QuizId") int id) {
		Quiz quiz = quizService.getQuizById(id);
		if (quiz == null) {
			return new ResponseEntity<String>("Quiz not found with the given id", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(quiz);
	}

	@PostMapping("quizlist")
	public ResponseEntity<Quiz> insertionQuiz(@RequestBody Quiz q) {
		return ResponseEntity.ok(quizService.insertQuiz(q));
	}

	@PutMapping("quizlist")
	public ResponseEntity<Quiz> updationQuiz(@RequestBody Quiz q) {
		return ResponseEntity.ok(quizService.updateQuiz(q));
	}

	@DeleteMapping("quizlist/{QuizId}")
	public void deleteQuiz(@PathVariable("QuizId") int id) {
		Quiz q = quizService.getQuizById(id);
		if (q == null) {
			throw new RuntimeException("Quiz id does not exist");
		}
		quizService.deleteQuiz(id);
//		return "Deleted quiz id is: " + id;
	}

}
