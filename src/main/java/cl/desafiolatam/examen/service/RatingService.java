package cl.desafiolatam.examen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import cl.desafiolatam.examen.model.Rating;
import cl.desafiolatam.examen.repository.RatingRepository;

@Service
public class RatingService {
	@Autowired
	private RatingRepository ratingRepository;

	public List<Rating> findAllRatings() {
		return ratingRepository.findAll();
	}

	public Rating findRatingById(Integer id) {
		return ratingRepository.findRatingById(id);
	}

	public void addRating(Rating rating) {
		ratingRepository.save(rating);
	}

}
