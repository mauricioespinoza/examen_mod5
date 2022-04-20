package cl.desafiolatam.examen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.examen.model.User;
import cl.desafiolatam.examen.repository.RoleRepository;
import cl.desafiolatam.examen.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// Create
	public void saveWithUserRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(user);
	}

	public void saveUserWithAdminRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(user);
	}

	// READ ONE
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findUserById(Integer id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	// READ ALL
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	// create
	public void createUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	// update
	public void updateUser(User user) {
		userRepository.save(user);
	}
	// delete
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	/*public boolean authenticateUser(String email, String password) {
		// first find the user by email
		System.out.println("Entra al servicio");		
		User user = userRepository.findUserByEmail(email);
		// if we can't find it be email, return false
		if(user == null) {
			return false;
		} else {
			// if the passwords match, return true, else, return false;
			if(BCrypt.checkpw(password,  user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}*/

}
