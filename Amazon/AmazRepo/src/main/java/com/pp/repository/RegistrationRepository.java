package com.pp.repository;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.UserDto;

@Repository
public class RegistrationRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void userRegistration(UserDto registration) {
		System.out.println("Inside Repo userRegistration method");
			hibernateTemplate.save(registration);

	}

	@SuppressWarnings("unchecked")
	public boolean getUserByEmail(String emailId) {

		
		List<UserDto> list = hibernateTemplate.find("from UserDto user where user.emailId =?",emailId);
		for(UserDto user:list) {
			System.out.println(user.getEmailId()+" is already exist!");
			if(user.getEmailId()!=null) {
				return true;
			}

		}return false;
	}
}
