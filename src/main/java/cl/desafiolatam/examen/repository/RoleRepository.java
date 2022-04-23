package cl.desafiolatam.examen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.examen.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
	List<Role> findAll();
	List<Role> findByName(String name);
	/*NOTA: 
	 * Este repositorio también es usado para generar la API REST de requerimiento opcional
	 */
}
