package cl.desafiolatam.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.examen.model.User;
import cl.desafiolatam.examen.repository.RoleRepository;
import cl.desafiolatam.examen.repository.UserRepository;
/* NOTA: Se deja esta implementación en este package por definiciones de los requerimientos, 
 * lo idoneo seria ubicarlo en el package impl
 */
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// Crear Usuario- Rol: ROLE_USER
	@Override
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
	}

	//Crear Usuario- Rol: ROLE_ADMIN- No esta en uso este metodo en esta implementación, pero de deja declarado
	@Override
	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(user);
	}

	//Busca usuario por username
	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	//Busca usuario por id
	@Override
	public User findUserById(Integer id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}
	
	//busca usuario por email
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	//Trae a todos los usuarios-Se usa para desplegar detalle de ranking en shows.jsp
	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	//Crea usuario, pero en tabla, sin asignar el rol aun
	@Override
	public void createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	//Actualiza usuario-No usado en esta implementación
	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	//Elimina usuario-no usado en esta implemetación
	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

}
