package hello;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import model.Leagues;
import repository.LeaguesRepository;
import service.impl.LeagueServiceImpl;
import service.impl.QueryBuilderServiceImpl;

//import hello.QGames;

@RestController
public class LeagueController {
		
	private static final String LEAGUES = "LEAGUES";
	
	//Refactor: Move All League Repo Dependencies to Service
	
	@Autowired 
	private LeaguesRepository leaguesRepository;
	
	@Autowired
	private LeagueServiceImpl leagueService;
	
	@Autowired
	private QueryBuilderServiceImpl queryService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/leagues",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Leagues> getAllLeagues(@RequestParam MultiValueMap<String, String> queryParameters) {	
		
		return (List<Leagues>) leaguesRepository.findAll(queryService.createQuery(queryParameters, LEAGUES));
		//return  gameRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/leagues/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Leagues getLeagueById(@PathVariable("id") String id) {	
		
		return leagueService.getLeagueById(id);
		//return  gameRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/leagues")
	public ResponseEntity<String> createLeague(@RequestBody Leagues league) {
		String createdId = leaguesRepository.save(league).id;
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(locationBuilder(createdId));
		
		return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/leagues/{id}")
	public ResponseEntity<String> updateLeague(@PathVariable String id, @RequestBody Leagues league) {
		Leagues currentLeague = leaguesRepository.findById(id);
		if (currentLeague == null){
			currentLeague = league;
		} else {
			currentLeague.setUserIds(league.userIds);
			currentLeague.setName(league.name);
			currentLeague.setUsers(league.users);		
		}
		
		String currentId = leaguesRepository.save(currentLeague).id;
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(locationBuilder(currentId));
		
		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/leagues/{id}")
	public ResponseEntity<String> deleteLeague(@PathVariable String id, @RequestBody Leagues league) {
		Leagues currentLeague = leaguesRepository.findById(id);
		leaguesRepository.delete(currentLeague);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);

	}
//	
	private URI locationBuilder(String id) {
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(id).toUri();
		return location;
	}
	
}
