package com.quiz.QuizifyServer.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizifyServer.entity.Question;
import com.quiz.QuizifyServer.entity.Quiz;
import com.quiz.QuizifyServer.service.IQuestionService;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins ="http://localhost:4200")
public class QuestionController {

	@Autowired
	private IQuestionService questionService;

	@GetMapping("questionlist")
	public List<Question> displayQuestions() {
		return questionService.getQuestion();
	}

	@GetMapping("questionlist/{QuestionId}")
	public ResponseEntity<?> getQuestions(@PathVariable("QuestionId") int id) {
		Question que = questionService.getQuestionById(id);
		if (que == null) {
			return new ResponseEntity<String>("user not found with the given id", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(que);
	}
	
	@GetMapping("questionlist/quizid/{quizId}")
	public ResponseEntity<?> getQuestionsByQuizId(@PathVariable("quizId") int quiz_id) {
		Set<Question> questions = questionService.getQuestionsByQuizId(quiz_id);
		if (questions == null) {
			return new ResponseEntity<String>("questions not found for the given quiz", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(questions);
	}

	@PostMapping("questionlist")
	public ResponseEntity<Question> insertionQuestion(@RequestBody Question q) {
		return ResponseEntity.ok(questionService.insertQuestion(q));
	}

	@PutMapping("questionlist")
	public ResponseEntity<Question> updationQuestions(@RequestBody Question q) {
		return ResponseEntity.ok(questionService.updateQuestion(q));
	}

	@DeleteMapping("questionlist/{QuestionId}")
	public void deleteQuestiono(@PathVariable("QuestionId") int id) {
//		Quiz quiz = new Quiz();
		Question q = questionService.getQuestionById(id);
		if (q == null) {
			throw new RuntimeException("Quiz id does not exist");
		}
		questionService.deleteQuestion(id);
//		return "Deleted question id is: " + id;
	}

}
