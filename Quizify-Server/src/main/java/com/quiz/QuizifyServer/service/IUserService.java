package com.quiz.QuizifyServer.service;

import java.util.List;

import com.quiz.QuizifyServer.entity.User;

public interface IUserService {
	
	public List<User> getUsers();
	
	public User getUserById(Integer id);
	
	public User insertUser(User user) throws Exception;
	
	public User updateUser(User user);
	
	public void deleteUser(Integer id);	

}
