package com.pp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pp.model.UserDto;
import com.pp.service.RegistrationService;
import com.pp.validator.RegistrationValidator;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private RegistrationValidator registrationValidator;

	@RequestMapping("/showRegistration")
	public String showRegistration(Map<String, Object> map) {
		System.out.println("Inside Show Registration method");
		map.put("RegistrationKey", new UserDto());
		return "registration";
	}

	@RequestMapping(value="/submitRegistration" , method = RequestMethod.POST)
	public String submitRegistration(@ModelAttribute("RegistrationKey") UserDto registration ,BindingResult result,ModelMap model,Map<String,Object> map) {
		System.out.println("Inside submitRegistration method");


		if(registration != null && !registration.equals("null")) {
			registrationValidator.validate(registration, result);
			if(result.hasErrors()) {
				return "registration";
			}else {
				registrationService.userRegistration(registration);
				map.put("UserDtoKey", new UserDto());
			}
		}
		return "login";
	}
}
