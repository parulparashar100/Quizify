package com.quiz.QuizifyServer.controller;

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

import com.quiz.QuizifyServer.entity.Attempt;
import com.quiz.QuizifyServer.service.IAttemptService;

@RestController
@RequestMapping("/attempt")
public class AttemptController {

	@Autowired
	private IAttemptService attemptService;

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
