package com.quiz.QuizifyServer.service.Impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.QuizifyServer.entity.Question;
import com.quiz.QuizifyServer.persistance.IQuestionRepository;
import com.quiz.QuizifyServer.service.IQuestionService;

@Service
public class QuestionServiceImpl implements IQuestionService {

	@Autowired
	private IQuestionRepository questionRepo;
	
	@Override
	public List<Question> getQuestion() {
		return questionRepo.findAll();
	}

	@Override
	public Question getQuestionById(Integer id) {
		return questionRepo.findById(id).get();
	}

	@Override
	public Question insertQuestion(Question question) {
		return questionRepo.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return questionRepo.save(question);
	}

	@Override
	public void deleteQuestion(Integer id) {
		questionRepo.deleteById(id);
	}

	@Override
	public Set<Question> getQuestionsByQuizId(Integer quiz_id) {
		return questionRepo.findByQuizId(quiz_id);
	}

}
