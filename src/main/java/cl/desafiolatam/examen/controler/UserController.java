package cl.desafiolatam.examen.controler;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.desafiolatam.examen.model.Users;
import cl.desafiolatam.examen.service.UserService;
import cl.desafiolatam.examen.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false)
	String logout, Model model, @Valid @ModelAttribute("users") Users users, BindingResult result) {
		System.out.println("Llega asi el modelo: "+model.toString()); 
		System.out.println("email de usuario: "+users.getEmail()+" . Clave del usuario: "+users.getPassword());
		if (error != null) {
			model.addAttribute("errorMessage", "Credenciales invalidas, intente nuevamente");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Login exitoso!");
		}
		return "login";
	}
	

	@GetMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") Users users) {
		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") Users users, BindingResult result) {
		userValidator.validate(users, result);
		if (result.hasErrors()) {
			return "registration";
		} else {
			userService.saveWithUserRole(users);
			// userService.saveUserWithAdminRole(users);
			return "redirect:/login";
		}
	}

	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal) {
		return "redirect:/shows";
	}

}
