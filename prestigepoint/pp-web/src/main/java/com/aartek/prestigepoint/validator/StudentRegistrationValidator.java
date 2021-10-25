package com.aartek.prestigepoint.validator;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.aartek.prestigepoint.model.Registration;
import java.text.ParseException;

@Component
public class StudentRegistrationValidator implements Validator {
	
	@Autowired
	private RegistrationRepository reg;

	public boolean supports(Class<?> clazz) {
		return Registration.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Registration registration = (Registration) target;
		
		//First Rule 
		ValidationUtils.rejectIfEmpty(errors, "firstName", "error.name.empty");
		ValidationUtils.rejectIfEmpty(errors, "contact", "error.contact.empty");
		ValidationUtils.rejectIfEmpty(errors, "qualification", "error.qualification.empty");
		ValidationUtils.rejectIfEmpty(errors, "dateOfBirth", "error.dateOfBirth.empty");
		ValidationUtils.rejectIfEmpty(errors, "city", "error.city.empty");
		ValidationUtils.rejectIfEmpty(errors, "state", "error.state.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.password.empty");
		
		// Second Rule 
		if (registration.getEmailId() != null && registration.getEmailId().trim().length() > 0) {
			
			if (registration.getEmailId().contains("@") != true ) {
				errors.rejectValue("emailId", "error.email.first.rule","Please enter Email.");
			} else if (registration.getEmailId().contains("gmail.com") != true) {
				errors.rejectValue("emailId", "error.email.first.rule","Please Must contain gmail.com.");
			} else if (!b) {
				errors.rejectValue("emailId", "error.email.required");
			}
		}
		
		// Third Rule 
		
		List<User> user =   reg.findByEmail(registration.getEmailId());
		
		if(user !=null)
			errors.rejectValue("emailId", "error.email.first.rule","Email Already Exist, Please try new one.");
		
		}
		}
		if(registration.getYear()!=null){
		if (registration.getYear().getYearId() == 0) {
			errors.rejectValue("year.yearId", "error.year.rule");
		}
		}
		if (registration.getContact() != null && registration.getContact() != "") {
			if (registration.getContact().length() < 10) {
				errors.rejectValue("contact", "error.contactNo.length");
			}
		}
		if (registration.getDateOfBirth() != null && registration.getDateOfBirth() != "") {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String dateOfBirth = registration.getDateOfBirth();
			String currentDate = sdf.format(date).toString();
			try {
				Calendar cal1 = new GregorianCalendar();
				Calendar cal2 = new GregorianCalendar();
				int age = 0;
				int factor = 0;
				Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(dateOfBirth);
				Date date2 = new SimpleDateFormat("dd-MM-yyyy").parse(currentDate);
				cal1.setTime(date1);
				cal2.setTime(date2);
				if (cal2.get(Calendar.DAY_OF_YEAR) < cal1.get(Calendar.DAY_OF_YEAR)) {
					factor = -1;
				}
				age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR) + factor;
				if (age <= 13) {
					errors.rejectValue("dateOfBirth", "error.age.empty");
				}
			} catch (ParseException e) {
				System.out.println(e);
			}
		}
	}
}
