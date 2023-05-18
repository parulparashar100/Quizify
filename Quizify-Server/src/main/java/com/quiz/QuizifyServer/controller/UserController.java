package com.quiz.QuizifyServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins ="http://localhost:4200")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("userlist")
	public List<User> getAllUser()
	{
		return userService.getUsers();
	}
	
	@GetMapping("userlist/{UserId}")  
	public User getUserById(@PathVariable("UserId") int id)
	{
		User user=userService.getUserById(id);
		if(user==null)
		{
			throw new RuntimeException("user not found with the given id");
		}
	return user;
	}
	
	@GetMapping("userlist/email/{email}")  
	public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email)
	{
		User user=userService.getUserByEmail(email);
		if(user==null)
		{
			return new ResponseEntity<String>("Invalid Credentials!!", HttpStatus.NOT_FOUND);
//			throw new RuntimeException("user not found with the given email");
		}
		user.setPassword("");
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("userlist") 
	public User insertionUser(@RequestBody User u)
	{
		u.setId(0);
		try {
			u.setPassword(passwordEncoder.encode(u.getPassword()));
			return userService.insertUser(u);
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
