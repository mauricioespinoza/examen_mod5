package cl.desafiolatam.examen.service;

import java.util.List;

import cl.desafiolatam.examen.model.Show;
/* Se implementa requerimiento opcional:
 * Crear una interfaz personalizada en donde las clases que hereden de ella
implementen sus métodos (por ejemplo que los servicios hereden de la misma
interfaz e implementen los mismos métodos cambiando el argumento y retorno de
estos).
 */
public interface ShowService {
	public Show findById(Integer id);
	public List<Show> findAllShows();
	public void saveShow(Show show);
	public void updateShow(Show show);
	public void deleteShow(Integer id);
}
