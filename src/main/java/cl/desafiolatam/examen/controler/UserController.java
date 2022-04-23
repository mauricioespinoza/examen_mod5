package cl.desafiolatam.examen.controler;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.desafiolatam.examen.model.User;
import cl.desafiolatam.examen.service.UserServiceImpl;
import cl.desafiolatam.examen.validators.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private UserServiceImpl userServiceImpl;

	/*login, manejo de mensajes por error o login ok*/
	@GetMapping("/login")
	public String loginForm(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false)
	String logout, Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {
		//Con esto se "alimentan" las instancias de mensajes en login
		if (error != null) {
			model.addAttribute("errorMessage", "Credenciales invalidas, intente nuevamente");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Login exitoso!");	
		}
		return "login";
	}
	
	/*Despliega form de registro*/
	@GetMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "registration";
	}

	//Genera registro de usuario
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "registration";
		} else {
			userServiceImpl.saveWithUserRole(user);
			/*En el requerimiento se indica solo ingresar usuarios con rol: ROLE_USER, pero se deja comentado
			 * el metodo a invocar para generar usuarios con rol: role_admin:
			 *  userServiceImpl.saveUserWithAdminRole(user);
			 *  
			 *   NOTA: De todas formas en el websecurityconfig, está establecido que ambos roles pueden acceder a plataforma usuario,
			 *   la plataforma admin no se ha definido ya que no estaba en los alcances*/
			return "redirect:/login";
		}
	}

	//maneja la instancia de jsp home v/s jsp shows
	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal) {
		return "redirect:/shows";	
	}

}
