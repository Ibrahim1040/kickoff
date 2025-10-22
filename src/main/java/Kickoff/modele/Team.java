package Kickoff.modele;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Team implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false,updatable = false)
	private Long id;
	
	@Column(name = "name")
	private String name;
	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "team_id")
	private List<Player> players;
	@Column(name = "played")
	private int played;
	@Column(name = "points")
	private int points;
	@Column(name = "wins")
	private int wins;
	@Column(name = "draws")
	private int draws;
	@Column(name = "losses")
	private int losses;
}
