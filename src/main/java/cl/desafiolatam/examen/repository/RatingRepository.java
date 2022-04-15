package cl.desafiolatam.examen.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.desafiolatam.examen.model.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer>{
	List<Rating> findAll();
	Rating findRatingById(Integer id);
}
