package cl.desafiolatam.examen.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shows")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "show_id", nullable = false, unique = true)
	private Integer id;
	@Size(min = 1, message = "Title must be present")
	private String showTitle;
	@Size(min = 1, message = "Network must be present")
	private String showNetwork;

	public Show() {
	}

// RELACIONES
// N:1 USER
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users creatorShow;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "shows_ratings", joinColumns = @JoinColumn(name = "show_id"), inverseJoinColumns = @JoinColumn(name = "rating_id"))
	private List<Rating> ratings;

	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public Users getCreatorShow() {
		return creatorShow;
	}
	public void setCreatorShow(Users creatorShow) {
		this.creatorShow = creatorShow;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShowTitle() {
		return showTitle;
	}
	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}
	public String getShowNetwork() {
		return showNetwork;
	}
	public void setShowNetwork(String showNetwork) {
		this.showNetwork = showNetwork;
	}
}
