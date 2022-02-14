package com.brianfair.interviewalgos.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.brianfair.interviewalgos.models.User;
import com.brianfair.interviewalgos.repositories.UserRepository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class UserValidation {
	
	@Autowired
	private UserRepository userRepository;
	
	private final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
	
	public boolean suports(Class<?> clazz)
	{
		return User.class.getClass().equals(clazz);
	}
	
	private boolean isValidEmail(final String email)
	{
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public void validate(Object target, Errors errors)
	{
		User user = (User) target;
		if(!user.getPassword().equals(user.getPasswordConfirmation()))
		{
			errors.rejectValue("password", "Match", "PASSWORDS MUST MATCH!!!!");
		}
		if(userRepository.existsByEmail(user.getEmail()))
		{
			errors.rejectValue("email", "Unique", "Email has already been taken!");
		}
		if(!isValidEmail(user.getEmail()))
		{
			errors.rejectValue("email", "Valid", "Not a valid email address!");
		}
			
	}
	
	
	

}
