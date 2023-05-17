package com.quiz.QuizifyServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizifyServer.jwt.JwtRequest;
import com.quiz.QuizifyServer.jwt.JwtResponse;
import com.quiz.QuizifyServer.jwt.UserDetailsServiceImpl;
import com.quiz.QuizifyServer.jwt.config.JwtUtils;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
		} catch (Exception e) {
			throw new Exception("User not found");
		}

		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getEmail());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));

	}

	private void authenticate(String username, String password) throws Exception {
		try {

		} catch (DisabledException e) {
			throw new Exception("USer Disabled");
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials!!");
		}
	}

}
