package cl.desafiolatam.examen.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cl.desafiolatam.examen.model.User;
import cl.desafiolatam.examen.service.UserServiceImpl;

@Component
public class UserValidator implements Validator {
	private UserServiceImpl userServiceImpl;
	
	//aca implemento la clase solicitada en el requerimiento 5 y extiendo individualmente algunas funciones
	public UserValidator(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	//Valido el error, para poder desplegarlo en caso que exista el mismo
	@Override
	public void validate(Object object, Errors errors) {
		User user = (User) object;
		if (!user.getPasswordConfirmation().equals(user.getPassword()))
		{
			errors.rejectValue("passwordConfirmation", "Match");
		}
		User userCheck = userServiceImpl.findUserByEmail(user.getEmail());
		if (userCheck != null) {
			errors.rejectValue("email", "Found");
		}
		String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (!matcher.matches()) {
			errors.rejectValue("email", "Match");
		}
	}
}