package com.quiz.QuizifyServer.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.QuizifyServer.entity.Attempt;
import com.quiz.QuizifyServer.persistance.IAttemptRepository;
import com.quiz.QuizifyServer.service.IAttemptService;

@Service
public class AttemptServiceImpl implements IAttemptService {

	@Autowired
	private IAttemptRepository attemptRepo;
	
	@Override
	public List<Attempt> getAttempts() {
		return attemptRepo.findAll();
	}

	@Override
	public Attempt getAttemptById(Integer id) {
		return attemptRepo.findById(id).get();
	}

	@Override
	public List<Attempt> getAttemptByUserId(Integer userId) {
		return attemptRepo.findByUserId(userId);
	}

	@Override
	public Attempt insertAttempt(Attempt attempt) {
		return attemptRepo.save(attempt);
	}

	@Override
	public Attempt updateAttempt(Attempt attempt) {
		return attemptRepo.save(attempt);
	}

	@Override
	public void deleteAttempt(Integer id) {
		attemptRepo.deleteById(id);
	}

}
