package cl.desafiolatam.examen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.examen.model.Rating;
import cl.desafiolatam.examen.repository.RatingRepository;
import cl.desafiolatam.examen.service.RatingService;
/* Se implementa requerimiento opcional:
 * Crear una interfaz personalizada en donde las clases que hereden de ella
implementen sus métodos (por ejemplo que los servicios hereden de la misma
interfaz e implementen los mismos métodos cambiando el argumento y retorno de
estos).
 */
@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepository ratingRepository;
	
	//Entrega todos los ranking por shows
	@Override
	public List<Rating> findAllRatings() {
		return ratingRepository.findAll();
	}

	//Entrega rakings por ID
	@Override
	public Rating findRatingById(Integer id) {
		return ratingRepository.findRatingById(id);
	}

	//agrega rankin al show
	@Override
	public void addRating(Rating rating) {
		ratingRepository.save(rating);
	}
}
