package com.pp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.UserDto;

@Repository
public class LoginRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<UserDto> adminSignIn(UserDto login) {
		System.out.println("Repo Email >> "+login.getEmailId());
		System.out.println("Repo Password >> "+login.getPassword());

		@SuppressWarnings("unchecked")
		List<UserDto> user = (List<UserDto>) hibernateTemplate.find("from UserDto al where al.emailId = ? and al.password = ?", login.getEmailId(), login.getPassword());
		return user;
	}

	
}
