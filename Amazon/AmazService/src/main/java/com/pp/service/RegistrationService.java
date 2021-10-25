package com.pp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.UserDto;
import com.pp.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;

	public void userRegistration(UserDto registration) {
		
		System.out.println("Inside RegistrationService method");
		
		System.out.println("firstname :"+registration.getFirstname());
		System.out.println("lastname :"+registration.getLastname());
		System.out.println("mobile :"+registration.getMobile());
		System.out.println("email :"+registration.getEmailId());
		System.out.println("password :"+registration.getPassword());
		
		registrationRepository.userRegistration(registration);
	}
}
