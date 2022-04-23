package cl.desafiolatam.examen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.examen.model.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Integer>{
	/*Se implementa requerimiento opcional:
	 * Crear una query JPQL o una query nativa en la capa de persistencia. Esta puede
tener como objetivo filtrar mediante uno o más parámetros, retornar resultados
ascendentes o descendentes, buscar show por rating, etc.*/
	
	@Query(value="SELECT * FROM shows order by show_title", nativeQuery=true)
	List<Show> findAll();
}
