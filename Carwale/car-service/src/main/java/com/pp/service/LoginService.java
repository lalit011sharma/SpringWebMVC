package com.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.User;
import com.pp.repo.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	public void userSignIn(User login) {
		
	System.out.println("Inside Service Controller");
	
	System.out.println("Email is:"+login.getEmail());
	System.out.println("Password is:"+login.getPassword());
	
	loginRepository.userSignIn(login);
	}
}
