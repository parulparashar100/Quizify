package com.quiz.QuizifyServer.service;

import java.util.List;

import com.quiz.QuizifyServer.entity.Quiz;

public interface IQuizService {
	
	public List<Quiz> getQuizzes();
	
	public Quiz getQuizById(Integer id);
	
	public Quiz insertQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public void deleteQuiz(Integer id);	

}
