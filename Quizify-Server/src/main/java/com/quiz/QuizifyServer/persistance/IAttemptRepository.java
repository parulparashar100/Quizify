package com.quiz.QuizifyServer.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.QuizifyServer.entity.Attempt;

public interface IAttemptRepository extends JpaRepository<Attempt, Integer> {

	public List<Attempt> findByUserId(Integer userId);
	
}
