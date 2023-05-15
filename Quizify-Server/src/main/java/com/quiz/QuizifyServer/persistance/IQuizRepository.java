package com.quiz.QuizifyServer.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.QuizifyServer.entity.Quiz;

public interface IQuizRepository extends JpaRepository<Quiz, Integer> {

}
