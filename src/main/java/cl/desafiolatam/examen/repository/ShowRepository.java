package cl.desafiolatam.examen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.examen.model.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Integer>{
	List<Show> findAll();
}
