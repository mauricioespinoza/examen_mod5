package cl.desafiolatam.examen.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.desafiolatam.examen.model.Role;
import cl.desafiolatam.examen.service.RoleService;

/*Este controlador surge por el siguiente Requerimiento Opcional:
 * Crear una API REST (puede ser otra clase con anotación @RestController o puede ser
como proyecto aparte)
 * */
@RestController
@RequestMapping("/api/v1/roles")
public class RoleControllerREST {
	@Autowired
	private RoleService roleService;
	
	//Aca se recibe el json inyectado via POST
	@PostMapping
	public void create(@RequestBody Role role) {
		roleService.save(role);
	}

	//Aca despliega los roles existentes y persistentes en BD
	@GetMapping
	public List<Role> findAll() {
		return roleService.findAll();
	}

}
