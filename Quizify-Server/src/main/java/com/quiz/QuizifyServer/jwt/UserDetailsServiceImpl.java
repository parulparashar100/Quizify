package com.quiz.QuizifyServer.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.quiz.QuizifyServer.entity.User;
import com.quiz.QuizifyServer.persistance.IUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepository.findByEmail(username);
		if(user == null) {
			System.out.println("User not found!!");
			throw new UsernameNotFoundException("Invalid Credentials!!");
		}
		
		return user;
	}

}
