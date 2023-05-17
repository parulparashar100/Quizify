package com.quiz.QuizifyServer.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.QuizifyServer.entity.Quiz;
import com.quiz.QuizifyServer.persistance.IQuizRepository;
import com.quiz.QuizifyServer.service.IQuizService;

@Service
public class QuizServiceImpl implements IQuizService {

	@Autowired
	private IQuizRepository quizRepo;

	@Override
	@Transactional
	public List<Quiz> getQuizzes() {
		return quizRepo.findAll();
	}

	@Override
	@Transactional
	public Quiz getQuizById(Integer id) {
		return quizRepo.findById(id).get();
	}

	@Override
	@Transactional
	public Quiz insertQuiz(Quiz quiz) {
		return quizRepo.save(quiz);
	}

	@Override
	@Transactional
	public Quiz updateQuiz(Quiz quiz) {
		return quizRepo.save(quiz);
	}

	@Override
	@Transactional
	public void deleteQuiz(Integer id) {
		quizRepo.deleteById(id);
	}

}
