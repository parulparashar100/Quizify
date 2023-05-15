package com.quiz.QuizifyServer.service;

import java.util.List;

import com.quiz.QuizifyServer.entity.Attempt;

public interface IAttemptService {

	public List<Attempt> getAttempts();

	public Attempt getAttemptById(Integer id);
	
	public List<Attempt> getAttemptByUserId(Integer userId);

	public Attempt insertAttempt(Attempt attempt);

	public Attempt updateAttempt(Attempt attempt);

	public void deleteAttempt(Integer id);

}
