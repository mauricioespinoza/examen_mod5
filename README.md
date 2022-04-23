# Examen modulo 5 Mauricio Espinoza
La aplicación permite a los usuarios registrados crear programas de televisión y calificarlos.
* Implementa metodos Full CRUD (Create, Read, Update, Delete)

### Antes de empezar!!
* Ejecutar el script adjunto "scriptExamen.sql", para generar la instancia correcta de BD
* Una vez ha ejecutada la aplicación, antes de cualquier cosa, debe ejecutar 2 POST hacia: http://localhost:8080/api/v1/roles con las siguientes cadenas respectivamente

-{"name":"ROLE_USER"}
-{"name":"ROLE_ADMIN"}
 
 *También puede ejecutar el archivo adjunto: Post Examen Mod 5.postman_collection.json


### Caracteristicas
* Inicio de sesión y registro con validaciones (por ejemplo, evitar correos electrónicos duplicados, etc.)-Spring security y validate
* Solo los usuarios que crean un programa de televisión pueden editarlo/eliminarlo. Cuando se elimina un programa de televisión, también se eliminan las reseñas correspondientes a ese programa 
* Implementa metodo de API REST mediante RoleControllerAPI.java, mediante GET y puede generar POST al mismo
* Implementa manejo de DTO en controlador ShowController.java, pero llamando directamente a clases del Models, para no inferir en una mala praxis
* Implementa manejo de interfaces para los servicios y un package dedicado de implementación
* Implementa una query nativa en showrepository.java, para desplegar la vista de shows en el home ordenadas por nombre alfabeticamente