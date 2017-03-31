package com.stevebarreira.football.controller;

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

import com.stevebarreira.football.model.Picks;
import com.stevebarreira.football.model.PicksDTO;
import com.stevebarreira.football.model.UserWeekSummaryDTO;
import com.stevebarreira.football.service.PicksService;

//import hello.QGames;

@RestController
@RequestMapping("/api")
public class PickController {
	
	@Autowired
	private PicksService pickService;
		
	@RequestMapping(method = RequestMethod.GET, value = "/picks",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Picks> getAllPicksByCriteria(@RequestParam MultiValueMap<String, String> queryParameters) {		
		return pickService.findAllPicksByParams(queryParameters);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/picks/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Picks getPickById(@PathVariable("id") String id) {	
		return pickService.getPicksById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/picks/summary",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserWeekSummaryDTO> getUserSummary(@RequestParam(value = "username", required = false) String username, 
												   @RequestParam(required=false) Integer season) {	
		return pickService.getUserSummary(username, season);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/picks/with",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PicksDTO> getPicksWithGames(@RequestParam String username) {	// @RequestParam String expand
		return pickService.findAllPicksWithGames(username);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/picks")
	public ResponseEntity<String> createPick(@RequestBody Picks pick) {
		String createdId = pickService.addOrUpdatePick(pick, null).getId();
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(RequestUtils.locationBuilder(createdId, "picks"));
		
		return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/picks/{id}")
	public ResponseEntity<String> updatePick(@PathVariable String id, @RequestBody Picks pick) {
		
		Picks resultingPick = pickService.addOrUpdatePick(pick, id);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(RequestUtils.locationBuilder(resultingPick.getId(), "picks"));
		
		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);

	}
//	
	@RequestMapping(method = RequestMethod.PUT, value = "/picks", params = {"username","week"})
	public ResponseEntity<String> updateListOfPicks(@RequestBody List<Picks> picks) {
		
		pickService.updateListOfPicks(picks);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		
		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);

	}
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

	
}
