package hello;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import model.Picks;
import model.PicksExpand;
import service.impl.PicksServiceImpl;

//import hello.QGames;

@RestController
public class PickController {
	
	@Autowired
	private PicksServiceImpl pickService;
		
	@RequestMapping(method = RequestMethod.GET, value = "/picks",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Picks> getAllLeagues(@RequestParam MultiValueMap<String, String> queryParameters) {		
		return pickService.findAllPicksByParams(queryParameters);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/picks/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Picks getLeagueById(@PathVariable("id") String id) {	
		return pickService.getPicksById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/picks/with",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PicksExpand> getPicksWithGames() {	
		return pickService.findAllPicksWithGames();
	}
	
//	@RequestMapping(method = RequestMethod.POST, value = "/leagues")
//	public ResponseEntity<String> createLeague(@RequestBody Leagues league) {
//		String createdId = leagueService.createLeague(league).id;
//		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.setLocation(locationBuilder(createdId));
//		
//		return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
//
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT, value = "/leagues/{id}")
//	public ResponseEntity<String> updateLeague(@PathVariable String id, @RequestBody Leagues league) {
//		
//		Leagues resultingLeague = leagueService.addOrUpdateLeague(league, id);
//		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.setLocation(locationBuilder(resultingLeague.id));
//		
//		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);
//
//	}
//	
//	@RequestMapping(method = RequestMethod.DELETE, value = "/leagues/{id}")
//	public ResponseEntity<String> deleteLeague(@PathVariable String id, @RequestBody Leagues league) {
//		Leagues currentLeague = picksRepository.findById(id);
//		picksRepository.delete(currentLeague);
//		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		
//		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);
//
//	}
	
	//Refactor to Rest Controller Utils
	private URI locationBuilder(String id) {
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.pathSegment("leagues/{id}")
				.buildAndExpand(id).toUri();
		return location;
	}
	
}
