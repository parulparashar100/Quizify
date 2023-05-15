package com.quiz.QuizifyServer.service;

import java.util.List;
import java.util.Set;

import com.quiz.QuizifyServer.entity.Question;

public interface IQuestionService {

	public List<Question> getQuestion();

	public Question getQuestionById(Integer id);
	
	public Set<Question> getQuestionsByQuizId(Integer quiz_id);

	public Question insertQuestion(Question question);

	public Question updateQuestion(Question question);

	public void deleteQuestion(Integer id);

}
