package com.quiz.QuizifyServer.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.QuizifyServer.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	
//	public User findByEmailAndPassword(String email, String password);
	
}
