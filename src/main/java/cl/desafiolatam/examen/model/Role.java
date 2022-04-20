package cl.desafiolatam.examen.model;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "role_name")
	private String name;
// RELACIONES
	@ManyToMany(mappedBy = "roles")
	private List<User> user;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUsers() {
		return user;
	}
	public void setUsers(List<User> user) {
		this.user = user;
	}
	
	
}
