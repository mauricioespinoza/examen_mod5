package cl.desafiolatam.examen.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ratings")
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "rating_id", nullable = false, unique = true)
	private Integer id;
	@Max(5)
	@Min(1)
	private int rating;

	public Rating() {
	}

// RELACIONES
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(mappedBy = "ratings")
	private List<Show> shows;

	//getter and setters
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public List<Show> getShows() {
		return shows;
	}
	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	
	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + ", user=" + user + ", shows=" + shows + ", getUsers()="
				+ getUser() + ", getId()=" + getId() + ", getRating()=" + getRating() + ", getShows()=" + getShows()
				+ "]";
	}
}
