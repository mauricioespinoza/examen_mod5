package cl.desafiolatam.examen.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.examen.model.Show;
import cl.desafiolatam.examen.repository.ShowRepository;
import cl.desafiolatam.examen.service.ShowService;
/* Se implementa requerimiento opcional:
	 * Crear una interfaz personalizada en donde las clases que hereden de ella
	implementen sus métodos (por ejemplo que los servicios hereden de la misma
	interfaz e implementen los mismos métodos cambiando el argumento y retorno de
	estos).
	 */
@Service
public class ShowServiceImpl implements ShowService{
	@Autowired
	private ShowRepository showRepository;

	//Encuentra show por ID para la edición
	@Override
	public Show findById(Integer id) {
		Optional<Show> optionalShow = showRepository.findById(id);
		if (optionalShow.isPresent()) {
			return optionalShow.get();
		} else {
			return null;
		}
	}

	// Busca todos los show
	@Override
	public List<Show> findAllShows() {
		return showRepository.findAll();
	}

	// Crear show
	@Override
	public void saveShow(Show show) {
		showRepository.save(show);
	}

	// Actualizar show-Editar: Solo usuario creador puede editarlo
	@Override
	public void updateShow(Show show) {
		showRepository.save(show);
	}

	// Borrar show -solo usuario creador puede eliminarlo
	@Override
	public void deleteShow(Integer id) {
		showRepository.deleteById(id);
	}

}
