package com.quiz.QuizifyServer.service.Impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

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
	@Transactional
	public List<Question> getQuestion() {
		return questionRepo.findAll();
	}

	@Override
	@Transactional
	public Question getQuestionById(Integer id) {
		return questionRepo.findById(id).get();
	}

	@Override
	@Transactional
	public Question insertQuestion(Question question) {
		return questionRepo.save(question);
	}

	@Override
	@Transactional
	public Question updateQuestion(Question question) {
		return questionRepo.save(question);
	}

	@Override
	@Transactional
	public void deleteQuestion(Integer id) {
		questionRepo.deleteById(id);
	}

	@Override
	@Transactional
	public Set<Question> getQuestionsByQuizId(Integer quiz_id) {
		return questionRepo.findByQuizId(quiz_id);
	}

}
