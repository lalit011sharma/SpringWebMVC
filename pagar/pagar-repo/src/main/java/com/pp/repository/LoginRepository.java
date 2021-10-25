package com.pp.repository;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.UserDto;

@Repository
public class LoginRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void userSaveOperation(UserDto login) {

		System.out.println("Inside userSaveOperation method >>> loginRepo ");

		System.out.println("Email Repo>>" + login.getEmailId());
		System.out.println("Password  Repo>>" + login.getPassword());

		ArrayList<UserDto> login1 = (ArrayList<UserDto>) hibernateTemplate.find(
				"from UserDto al where al.emailId = ? and al.password = ?", login.getEmailId(), login.getPassword());
		for (int counter = 0; counter < login1.size(); counter++) {
			System.out.println(login1.get(counter));
		}

	}

}
