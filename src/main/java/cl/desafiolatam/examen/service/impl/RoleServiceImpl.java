package cl.desafiolatam.examen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.examen.model.Role;
import cl.desafiolatam.examen.repository.RoleRepository;
import cl.desafiolatam.examen.service.RoleService;
/* Se implemta por Requerimiento opcional de API REST y se hace funcional, 
 * ya que se generan los servicios que permitiran el POST que insertara en BD los roles
 */

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public List<Role> findAll() {
		return (List<Role>) roleRepository.findAll();
	}

}
