package com.pp.repository;

import java.util.ArrayList;

import javax.servlet.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.UserDto;

@Repository
public class RegistrationRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public UserDto saveUserDeatils(UserDto registration) {
		if (registration != null) {
			hibernateTemplate.saveOrUpdate(registration);
			
			System.out.println("Inside saveUserOperation method >>> registrationRepo ");

			System.out.println("Email Repo>>" + registration.getEmailId());
			System.out.println("Password  Repo>>" + registration.getPassword());
			System.out.println("FirstName Repo>>"+ registration.getFirstName());
	 		System.out.println("LastName  Repo>>"+ registration.getLastName());
	 		System.out.println("MobileName  Repo>>"+ registration.getMobileNumber());
		
			return registration;
		} else {
			return null;
		}
	}

//	public void userSaveOperation(UserDto registration) {  
//
//		System.out.println("Inside userSaveOperation method >>> loginRepo ");
//
//		System.out.println("Email Repo>>" + registration.getEmailId());
//		System.out.println("Password  Repo>>" + registration.getPassword());
//		System.out.println("Email Service>>"+ registration.getFirstName());
// 		System.out.println("Password  Service>>"+ registration.getLastName());
// 		System.out.println("Password  Service>>"+ registration.getMobileNumber());
//		
//		ArrayList<UserDto> login1 = (ArrayList<UserDto>) hibernateTemplate
//				.find("from UserDto al where al.emailId = ? and al.password = ?", login.getEmailId(), login.getPassword());
//		 for (int counter = 0; counter <= login1.size(); counter++) { 		      
//	          System.out.println(login1.get(counter)); 		
//	      }   	
//		//System.out.println(login1.get(0));
//		 
//		// System.out.println(((UserDto) login1).getPassword());
//		
//	}
}
