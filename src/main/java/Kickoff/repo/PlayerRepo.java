package Kickoff.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Kickoff.modele.Player;

public interface PlayerRepo extends JpaRepository<Player, Long>{
	
	Optional<Player> findPlayerById(Long id);

}
