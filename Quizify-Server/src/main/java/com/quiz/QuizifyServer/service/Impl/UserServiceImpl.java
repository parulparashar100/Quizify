package com.quiz.QuizifyServer.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.QuizifyServer.entity.User;
import com.quiz.QuizifyServer.persistance.IUserRepository;
import com.quiz.QuizifyServer.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepo;

	@Override
	@Transactional
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	@Transactional
	public User getUserById(Integer id) {
		return userRepo.findById(id).get();
	}
	
	@Override
	@Transactional
	public User getUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	@Override
	@Transactional
	public User insertUser(User user) throws Exception {
		User local = this.userRepo.findByEmail(user.getEmail());
		if(local != null) {
			System.out.println("User already exists!!");
			throw new Exception("User already exists!!");
		} else {
			local = this.userRepo.save(user);
		}
		
		return local;
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		return userRepo.save(user);
	}

	@Override
	@Transactional
	public void deleteUser(Integer id) {
		userRepo.deleteById(id);
	}

}
