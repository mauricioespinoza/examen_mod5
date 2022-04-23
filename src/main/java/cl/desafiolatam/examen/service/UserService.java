package cl.desafiolatam.examen.service;

import java.util.List;

import cl.desafiolatam.examen.model.User;
/* Se implementa requerimiento opcional:
 * Crear una interfaz personalizada en donde las clases que hereden de ella
implementen sus métodos (por ejemplo que los servicios hereden de la misma
interfaz e implementen los mismos métodos cambiando el argumento y retorno de
estos).
 */
public interface UserService {
	public void saveWithUserRole(User user);
	public void saveUserWithAdminRole(User user);
	public User findByUsername(String username);
	public User findUserById(Integer id);
	public User findUserByEmail(String email);
	public List<User> findAllUsers();
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser(Integer id);

}
