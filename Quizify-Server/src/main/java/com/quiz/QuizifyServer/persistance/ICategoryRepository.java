package com.quiz.QuizifyServer.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.QuizifyServer.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
