package Kickoff.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Kickoff.modele.Team;

public interface TeamRepo extends JpaRepository<Team, Long>{
	
	Optional<Team> findTeamById(Long id);

}
