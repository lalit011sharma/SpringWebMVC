package com.pp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pp.model.UserDto;
import com.pp.service.LoginService;
import com.pp.service.RegistrationService;

@Controller
public class RegistrationController {
    
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping("/registration")
	public String showLogin(Map<String, Object> map) {
		System.out.println("Inside show registration method");
		UserDto usr = new UserDto();
		map.put("Registration", usr);
		return "registration";
	}
	
	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String signInAction1(@ModelAttribute("Registration") UserDto registration) {
		System.out.println("Inside userRegistrationAction1 method");

		System.out.println("Email >>" + registration.getEmailId());
		System.out.println("Password >>" + registration.getPassword());

		registrationService.userRegistration(registration);
		return "Registration";
	}
}
