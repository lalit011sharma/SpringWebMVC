package com.pp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pp.model.UserDto;
import com.pp.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public String showLogin(Map<String, Object> map) {
		System.out.println("Inside show login method");
		UserDto usr = new UserDto();
		map.put("AdminLogin", usr);
		return "login";
	}

	@RequestMapping(value = "/userSignIn", method = RequestMethod.POST)
	public String signInAction1(@ModelAttribute("AdminLogin") UserDto login) {
		System.out.println("Inside signInAction1 method");

		System.out.println("Email >>" + login.getEmailId());
		System.out.println("Password >>" + login.getPassword());

		loginService.userSignIn(login);
		return "login";
	}

}
