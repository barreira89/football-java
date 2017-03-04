package com.stevebarreira.football.controller;

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

import com.stevebarreira.football.model.Leagues;
import com.stevebarreira.football.repository.LeaguesRepository;
import com.stevebarreira.football.service.impl.LeagueServiceImpl;

//import hello.QGames;
@RequestMapping("/api")
@RestController
public class LeagueController {
		
	//Refactor: Move All League Repo Dependencies to Service
	
	@Autowired 
	private LeaguesRepository leaguesRepository;
	
	@Autowired
	private LeagueServiceImpl leagueService;
		
	@RequestMapping(method = RequestMethod.GET, value = "/leagues",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Leagues> getAllLeagues(@RequestParam MultiValueMap<String, String> queryParameters) {		
		return leagueService.findAllLeaguesByParams(queryParameters);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/leagues", params = {"username"})
	public List<Leagues> getLeaguesByUserName(@RequestParam String username){
		return leagueService.findLeaguesByUserName(username);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/leagues/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Leagues getLeagueById(@PathVariable("id") String id) {	
		return leagueService.getLeagueById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/leagues")
	public ResponseEntity<String> createLeague(@RequestBody Leagues league) {
		String createdId = leagueService.createLeague(league).id;
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(locationBuilder(createdId));
		
		return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/leagues/{id}")
	public ResponseEntity<String> updateLeague(@PathVariable String id, @RequestBody Leagues league) {
		
		Leagues resultingLeague = leagueService.addOrUpdateLeague(league, id);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(RequestUtils.locationBuilder(resultingLeague.getId(), "leagues"));
		
		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/leagues/{id}")
	public ResponseEntity<String> deleteLeague(@PathVariable String id, @RequestBody Leagues league) {
		Leagues currentLeague = leaguesRepository.findById(id);
		leaguesRepository.delete(currentLeague);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);

	}
	
	//Refactor to Rest Controller Utils
	private URI locationBuilder(String id) {
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.pathSegment("leagues/{id}")
				.buildAndExpand(id).toUri();
		return location;
	}
	
}
