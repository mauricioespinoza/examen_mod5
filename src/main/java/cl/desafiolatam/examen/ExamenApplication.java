package cl.desafiolatam.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ExamenApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ExamenApplication.class, args);
		System.out.println("Antes de empezar!!\n"
				+ "* Una vez ha ejecutada la aplicación, antes de cualquier cosa, debe ejecutar 2 POST hacia: http://localhost:8080/api/v1/roles con las siguientes cadenas respectivamente\n"
				+ "\n"
				+ "-{\"name\":\"ROLE_USER\"}\n"
				+ "-{\"name\":\"ROLE_ADMIN\"}\n"
				+ " \n"
				+ " *También puede ejecutar el archivo adjunto: Post Examen Mod 5.postman_collection.json");
		}

}
