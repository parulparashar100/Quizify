package com.quiz.QuizifyServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizifyServer.entity.User;
import com.quiz.QuizifyServer.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@GetMapping("userlist")
	public List<User> displayUser()
	{
		return userService.getUsers();
	}
	
	@GetMapping("userlist/{UserId}")  
	public User getUser(@PathVariable("UserId") int id)
	{
		User user=userService.getUserById(id);
		if(user==null)
		{
			throw new RuntimeException("user not found with the given id");
		}
	return user;
	}
	
	@PostMapping("userlist") 
	public void insertionUser(@RequestBody User u)
	{
		u.setId(0);
		try {
			userService.insertUser(u);
		} catch(Exception e) {
			throw new RuntimeException("User Already exists");
		}
	}
	
	
	@PutMapping("userlist") 
	public void updationUser(@RequestBody User u)
	{
		userService.updateUser(u);
	}
	
	@DeleteMapping("userlist/{UserId}")
	public String deleteUser(@PathVariable("UserId") int id)
	{
		User u=userService.getUserById(id);
		if(u==null) 
		{
			throw new RuntimeException("Quiz id does not exist");
		}
	    userService.deleteUser(id);
	return "Deleted User id is: " + id;
	}
	
}
