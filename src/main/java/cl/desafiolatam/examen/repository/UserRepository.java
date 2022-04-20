package cl.desafiolatam.examen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.examen.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findAll();
	User findByUsername(String username);
	User findUserByEmail(String email);
}
