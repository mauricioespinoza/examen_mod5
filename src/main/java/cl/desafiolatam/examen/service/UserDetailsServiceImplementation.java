package cl.desafiolatam.examen.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.desafiolatam.examen.model.Role;
import cl.desafiolatam.examen.model.Users;
import cl.desafiolatam.examen.repository.UserRepository;

@Service
@Lazy
public class UserDetailsServiceImplementation implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 * Nota: dejo esta linea por si debo modificar el software en el futuro y
		 * agregar administradores Users user = userRepository.findByUsername(username);
		 */
		Users users = userRepository.findUserByEmail(username);
		if (users == null) {
			throw new UsernameNotFoundException("Users not found");
		}
		return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(),
				getAuthorities(users));
	}

	private List<GrantedAuthority> getAuthorities(Users user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		for (Role role : user.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
			authorities.add(grantedAuthority);
		}
		return authorities;
	}

}
