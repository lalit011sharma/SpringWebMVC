package com.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.UserDto;
import com.pp.repository.LoginRepository;
import com.pp.repository.RegistrationRepository;

@Service
public class RegistrationService {
	@Autowired
	private RegistrationRepository registrationRepository;
	
    public void userRegistration(UserDto registration) {
    	 
    	 System.out.println("Inside userRegistration method >>> RegistrationService ");
 		
 		System.out.println("Email Service>>"+ registration.getEmailId());
 		System.out.println("Password  Service>>"+ registration.getPassword());
 		System.out.println("FirstName Service>>"+ registration.getFirstName());
 		System.out.println("LastName  Service>>"+ registration.getLastName());
 		System.out.println("MobileNumber  Service>>"+ registration.getMobileNumber());
 		
 		registrationRepository.saveUserDeatils(registration);
     }
}
