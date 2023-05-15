package com.quiz.QuizifyServer.persistance;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.QuizifyServer.entity.Question;

public interface IQuestionRepository extends JpaRepository<Question, Integer> {

	public Set<Question> findByQuizId(Integer quiz_id);
	
}
