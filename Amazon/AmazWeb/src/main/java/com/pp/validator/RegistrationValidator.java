package com.pp.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pp.model.UserDto;
import com.pp.repository.RegistrationRepository;

@Component
public class RegistrationValidator implements Validator{

	@Autowired
	RegistrationRepository registrationRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDto user = (UserDto) target;
		ValidationUtils.rejectIfEmpty(errors, "firstname", "error.firstname","please enter firstname");
		ValidationUtils.rejectIfEmpty(errors, "lastname", "error.lastname","please enter lastname");
		ValidationUtils.rejectIfEmpty(errors, "mobile", "error.mobile","please enter mobile number");
		ValidationUtils.rejectIfEmpty(errors, "emailId", "error.email","please enter email");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.password","please enter password");

		boolean status = false;
		if(user.getFirstname().length() > 50) {
			errors.rejectValue("firstname", "error.firstnameLength","name must be under 50 character");
			status = true;
		}
		if(user.getLastname().length() > 50) {
			errors.rejectValue("lastname", "error.lastnameLength","name must be under 50 character");
			status = true;
		}

		if(user.getEmailId() != null && user.getEmailId().trim().length() > 0) {
			if(user.getEmailId().contains("@gmail.com")!=true) {
				errors.rejectValue("emailId", "error.email.symbol","Enter valid email");
				status = true;
			}
		}

		if(user.getMobile().length()>0 && user.getMobile().length() != 10) {
			errors.rejectValue("mobile", "error.mobileLength","length must be 10");
			status = true;
		}else if(user.getMobile().length()>0 && !isNumbersOnly(user.getMobile())) {
			errors.rejectValue("mobile", "error.mobileNumbers","enter numeric values only");
			status = true;
		}

		if(user.getPassword().length() > 0 && !isValidPassword(user.getPassword())) {
			errors.rejectValue("password", "error.password","password must be 8 characters strong");
			status = true;
		}

		if(!status) {
			if(registrationRepository.getUserByEmail(user.getEmailId())) {
				errors.rejectValue("emailId", "error.email.unique" ,"email must be unique");
			} 
		}
	}
	
	// Function to validate the password.
		public  boolean isValidPassword(String password)
		{

			// Regex to check valid password.
			String regex = "^(?=.*[0-9])"
					+ "(?=.*[a-z])(?=.*[A-Z])"
					+ "(?=.*[@#$%^&+=])"
					+ "(?=\\S+$).{8,20}$";

			// Compile the ReGex
			Pattern p = Pattern.compile(regex);

			// If the password is empty
			// return false
			if (password == null) {
				return false;
			}

			// Pattern class contains matcher() method
			// to find matching between given password
			// and regular expression.
			Matcher m = p.matcher(password);

			// Return if the password
			// matched the ReGex
			return m.matches();
		}

		public boolean isNumbersOnly(String mobile) {
			String strPattern = "^[0-9]{10}$";
			return mobile.matches(strPattern);
		}

}
