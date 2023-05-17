package com.quiz.QuizifyServer.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
	public List<Attempt> getAttempts() {
		return attemptRepo.findAll();
	}

	@Override
	@Transactional
	public Attempt getAttemptById(Integer id) {
		return attemptRepo.findById(id).get();
	}

	@Override
	@Transactional
	public List<Attempt> getAttemptByUserId(Integer userId) {
		return attemptRepo.findByUserId(userId);
	}

	@Override
	@Transactional
	public Attempt insertAttempt(Attempt attempt) {
		return attemptRepo.save(attempt);
	}

	@Override
	@Transactional
	public Attempt updateAttempt(Attempt attempt) {
		return attemptRepo.save(attempt);
	}

	@Override
	@Transactional
	public void deleteAttempt(Integer id) {
		attemptRepo.deleteById(id);
	}

}
