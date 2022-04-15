package cl.desafiolatam.examen.service;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cl.desafiolatam.examen.model.Users;
import cl.desafiolatam.examen.repository.RoleRepository;
import cl.desafiolatam.examen.repository.UserRepository;

@Service
@Lazy
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// Create
	public void saveWithUserRole(Users users) {
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		users.setRoles(roleRepository.findByName("ROLE_USER"));
		userRepository.save(users);
	}

	public void saveUserWithAdminRole(Users users) {
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		users.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		userRepository.save(users);
	}

	// READ ONE
	public Users findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public Users findUserById(Integer id) {
		Optional<Users> optionalUser = userRepository.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		} else {
			return null;
		}
	}

	public Users findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

	// READ ALL
	public List<Users> findAllUsers() {
		return userRepository.findAll();
	}

	// create
	public void createUser(Users users) {
		users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
		userRepository.save(users);
	}
	// update
	public void updateUser(Users users) {
		userRepository.save(users);
	}
	// delete
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	public boolean authenticateUser(String email, String password) {
		// first find the user by email
		System.out.println("Entra al servicio");		
		Users user = userRepository.findUserByEmail(email);
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
	}

}
