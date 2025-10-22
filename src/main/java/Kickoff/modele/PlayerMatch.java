package Kickoff.modele;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
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
public class PlayerMatch implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	@Transient
	private String team1Name;
	@Transient
	private String team2Name;
	@Transient
	private int gameWeek;
	@Transient
	private String result;
	
}

