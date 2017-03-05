package com.stevebarreira.football.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stevebarreira.football.model.Accounts;
import com.stevebarreira.football.service.AccountsService;


@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private AccountsService accountService;
		
	@RequestMapping(method = RequestMethod.GET, value = "/users",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Accounts> getAllAccountsByCriteria(@RequestParam MultiValueMap<String, String> queryParameters) {		
		return accountService.findAllAccountsByParams(queryParameters);
	}
//	
	@RequestMapping(method = RequestMethod.POST, value = "/users/signup",produces=MediaType.APPLICATION_JSON_VALUE)
	public String createUser(@RequestBody Accounts account) {	
		 accountService.saveAccount(account);
		 return "index";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Accounts getAccountById(@PathVariable("id") String userId) {		
		return accountService.findAccountById(userId);
	}
//	
//	//TODO: Fix resource end points to use expand
//	
//	@RequestMapping(method = RequestMethod.GET, value = "/picks/with",produces=MediaType.APPLICATION_JSON_VALUE)
//	public List<PicksDTO> getPicksWithGames(@RequestParam String username) {	// @RequestParam String expand
//		return accountService.findAllPicksWithGames(username);
//	}
//	
//	
//	
//	@RequestMapping(method = RequestMethod.POST, value = "/picks")
//	public ResponseEntity<String> createPick(@RequestBody Picks pick) {
//		String createdId = accountService.addOrUpdatePick(pick, null).getId();
//		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.setLocation(locationBuilder(createdId));
//		
//		return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
//
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT, value = "/picks/{id}")
//	public ResponseEntity<String> updatePick(@PathVariable String id, @RequestBody Picks pick) {
//		
//		Picks resultingPick = accountService.addOrUpdatePick(pick, id);
//		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.setLocation(locationBuilder(resultingPick.getId()));
//		
//		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);
//
//	}
////	
//	@RequestMapping(method = RequestMethod.PUT, value = "/picks", params = {"username","week"})
//	public ResponseEntity<String> updateListOfPicks(@RequestBody List<Picks> picks) {
//		
//		accountService.updateListOfPicks(picks);
//		
//		HttpHeaders responseHeaders = new HttpHeaders();
//		
//		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);
//
//	}
////	
////	@RequestMapping(method = RequestMethod.DELETE, value = "/leagues/{id}")
////	public ResponseEntity<String> deleteLeague(@PathVariable String id, @RequestBody Leagues league) {
////		Leagues currentLeague = picksRepository.findById(id);
////		picksRepository.delete(currentLeague);
////		
////		HttpHeaders responseHeaders = new HttpHeaders();
////		
////		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);
////
////	}
	
}
