package cl.desafiolatam.examen.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cl.desafiolatam.examen.model.Users;
import cl.desafiolatam.examen.service.UserService;

@Component
public class UserValidator implements Validator {
	private UserService userService;
	
	public UserValidator(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Users.class.equals(clazz);
	}
	
	@Override
	public void validate(Object object, Errors errors) {
		Users users = (Users) object;
		if (!users.getPasswordConfirmation().equals(users.getPassword()))
		{
			errors.rejectValue("passwordConfirmation", "Match");
		}
		Users userCheck = userService.findUserByEmail(users.getEmail());
		if (userCheck != null) {
			errors.rejectValue("email", "Found");
		}
		String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(users.getEmail());
		if (!matcher.matches()) {
			errors.rejectValue("email", "Match");
		}
	}
}