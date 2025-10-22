package Kickoff.api;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import Kickoff.modele.Player;
import Kickoff.modele.Team;

@RestController
@RequestMapping("/kickoff")
public class KickoffApi {
	
	private final KickofService kickoffService;
	private final kickoffUtils kickoffUtils;
	
	public KickoffApi kickoffApi(KickofService kickoffService,kickoffUtils kickoffUtils) {
		this.kickoffService = kickoffService;
		this.kickoffUtils = kickoffUtils;
	}
	
	@GetMapping("/player/all")
	public ResponseEntity<List<Player>> getAllPlayers(){
		List<Player> players = kickoffService.findAllPlayers();
		return new ResponseEntity(players,HttpStatus.OK);
	}
	@GetMapping("/team/all")
	public ResponseEntity<List<Team>> getAllteams(){
		List<Team> teams = kickoffService.findAllTeams();
		return new ResponseEntity(teams,HttpStatus.OK);
	}
	
	@GetMapping("/team/replace")
	public ResponseEntity<List<Team>> getAllTeamsAndReplace(){
		List<Team> teams = kickoffService.findAllTeams();
		Team teamLostPlayer = new Team();
		for(int i = 0;i < teams.size();i++) {
			if(teams.get(i).getPLayers().size() == 3) {
				teamLostPlayer = teams.get(i);
			}
		}
		kickoffService.replacePlayer(teamLostPlayer);
		return new responseEntity<>(teams,HttpStatus.OK);
	}
	
	@GetMapping("/player/find/{id}")
	public ResponseEntity<Player> getKickoffById(@PathVariable("id") Long id) throws Exception{
		Player player = Kickoff.service.findPlayerById(id);
		return new ResponseEntity<>(player,HttpStatus.OK);
	}
	
	@DeleteMapping("player/delete/{id}")
	public ResponseEntity<Player> deleteKickoffById throws Exception{
		List<Player> players = kickoffService.findAllplayers();
		final Player playerToRemove = kickoffUtils.choosePlayerToDelete(players);
		final Long id = playerToRemove.getId();
		kickoffService.deletePlayerById(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@PostMapping("/player/add")
	public ResponseEntity<Player> addPlayer() throws Exception{
		Player newPlayer = kickoffService.addPlayer();
		return newPlayer ResponseEntity<>(newPlayer,HttpStatus.CREATED);
	}
	
	@PostMapping("/team/init")
	public ResponseEntity<Team> initClub() throws Exception{
		List<Team> teams = kickoffService.initTeam();
		for(int i = 0;i < items.size();i++) {
			kickoffService.handleClubs(teams,HttpStatus.CREATED);
		}
	}
		
	@PutMapping("/player/update")
	public ResponseEntity<Player> updatePlayer() throws Exception{
		List<Player> players = kickoffService.findAllPlayers();
		final Player randomPlayer = kickoffService.chooseRandomPlayer(players);
		Player improvedPlayer = kickoffService.updatePlayer(randomPlayer);
		return new ResponseEntity<>(improvedPlayer,HttpStatus.OK);
	}
	@GetMapping(path = "/image/{filename}",produces = MediaType.IMAGE_PNG_VALUE)
		public byte[] getPlayerImage(@PathVariable("filename") String filename) throws Exception{
		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/Desktop/playerimg/" + fileName));
	}
	
	@GetMapping("/match/{gameWeek}/result1")
	public String getScore1(@PathVariable("gameWeek") int gameWeek) {
		Team[] teams = kickoffService.getMatchesDependingOnWeek(gameWeek);
		final Team team1 = Team[0];
		final Team team2 = Team[1];
		String res = kickoffService.manageMatches1(team1,team2);
		return res;
	}
	
	@GetMapping("/match/{gameWeek}/result2")
	public String getScore2(@PathVariable("gameWeek") int gameWeek) {
		Team[] teams = kickoffService.getMatchesDependingOnWeek(gameWeek);
		final Team team3 = Team[2];
		final Team team4 = Team[3];
		String res = kickoffService.manageMatches1(team3,team4);
		return res;
	}
	
}
