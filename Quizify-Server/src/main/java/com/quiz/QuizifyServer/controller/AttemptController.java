package com.quiz.QuizifyServer.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizifyServer.dto.Score;
import com.quiz.QuizifyServer.entity.Attempt;
import com.quiz.QuizifyServer.entity.Quiz;
import com.quiz.QuizifyServer.service.IAttemptService;
import com.quiz.QuizifyServer.service.IQuizService;

@RestController
@RequestMapping("/attempt")
@CrossOrigin(origins ="http://localhost:4200")
public class AttemptController {

	@Autowired
	private IAttemptService attemptService;

	@Autowired
	private IQuizService quizService;

	@GetMapping("attemptlist")
	public List<Attempt> displayAttempt() {
		return attemptService.getAttempts();
	}

	@GetMapping("attemptlist/{AttemptId}")
	public Attempt getAttempt(@PathVariable("AttemptId") int id) {
		Attempt attempt = attemptService.getAttemptById(id);
		if (attempt == null) {
			throw new RuntimeException("No attempt found");
		}
		return attempt;
	}

	@GetMapping("attemptlist/userid/{userId}")
	public List<Score> getAttemptByUserId(@PathVariable("userId") int userId) {
		List<Attempt> attemptList = attemptService.getAttemptByUserId(userId);
		List<Score> scoreList = new ArrayList<>();
		
		for (Attempt attempt : attemptList) {
			Quiz quiz = quizService.getQuizById(attempt.getQuizId());
			scoreList.add(new Score(attempt.getId(), attempt.getUserId(), attempt.getId(), attempt.getScore(),
					attempt.getAttemptDate(), quiz.getTitle(), quiz.getDescription(), quiz.getMaxMarks()));
		}
		if (attemptList == null) {
			throw new RuntimeException("No attempt found");
		}
		return scoreList;
	}

	@PostMapping("attemptlist")
	public Attempt insertionAttempt(@RequestBody Attempt a) {
		return attemptService.insertAttempt(a);
	}

	@PutMapping("attemptlist")
	public Attempt updationAttempt(@RequestBody Attempt a) {
		return attemptService.updateAttempt(a);
	}

	@DeleteMapping("attemptlist/{AttemptId}")
	public String deleteAttempt(@PathVariable("AttemptId") int id) {
		Attempt a = attemptService.getAttemptById(id);
		if (a == null) {
			throw new RuntimeException("Quiz id does not exist");
		}
		attemptService.deleteAttempt(id);
		return "Deleted User id is: " + id;
	}

}
