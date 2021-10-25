package com.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.UserDto;
import com.pp.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;
	
    public void userSignIn(UserDto login) {
    	 
    	 System.out.println("Inside userSignIn method >>> loginService ");
 		
 		System.out.println("Email Service>>"+ login.getEmailId());
 		System.out.println("Password  Service>>"+ login.getPassword());
 		
 		loginRepository.userSaveOperation(login);
     }
}
