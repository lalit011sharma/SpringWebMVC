package com.pp.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.User;

@Repository
public class LoginRepository {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	public void userSignIn(User login) {
		
		System.out.println("Inside Repository Controller");
		
		System.out.println("Email is:"+login.getEmail());
		System.out.println("Password is:"+login.getPassword());
		
		
		if(login.getEmail() != null && login.getPassword() != null) {
			
			System.out.println("Success");
			
		}
	}

}
