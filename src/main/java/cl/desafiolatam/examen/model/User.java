package cl.desafiolatam.examen.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;



@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, unique = true)
	private Integer id;
	@Size(min = 3, message = "Username must be present")
	private String username;
	@Size(min = 5, message = "Email must be greater present and in a valid format")
	private String email;
	@Size(min = 8 ,message="Password must be greater than 8characters")
	private String password;
	@Transient
	private String passwordConfirmation;
	
	//Constructor que permite la transaccionabilidad con los otros models and entity
	public User() {
	}
	



// RELACIONES
// 1:N SHOW
	@OneToMany(mappedBy = "creatorShow", fetch = FetchType.LAZY)
	List<Show> userShows;

// 1:N RATING
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Rating> ratings;


// ROLES
	@ManyToMany(fetch = FetchType.LAZY )
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	//Getters and Setters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public List<Show> getUserShows() {
		return userShows;
	}


	public void setUserShows(List<Show> userShows) {
		this.userShows = userShows;
	}


	public List<Rating> getRatings() {
		return ratings;
	}


	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	
}
