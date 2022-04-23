package cl.desafiolatam.examen.service;

import java.util.List;

import cl.desafiolatam.examen.model.Role;

/* Se implementa requerimiento opcional:
 * Crear una interfaz personalizada en donde las clases que hereden de ella
implementen sus métodos (por ejemplo que los servicios hereden de la misma
interfaz e implementen los mismos métodos cambiando el argumento y retorno de
estos).
 */
public interface RoleService {
	public void save(Role role);
	public List<Role> findAll();
	
}
