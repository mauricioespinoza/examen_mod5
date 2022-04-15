package cl.desafiolatam.examen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.examen.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {
	List<Users> findAll();
	Users findByUsername(String username);
	Users findUserByEmail(String email);
}
