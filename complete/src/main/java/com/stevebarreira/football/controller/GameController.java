package com.stevebarreira.football.controller;

import java.util.ArrayList;
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

import com.stevebarreira.football.model.Games;
import com.stevebarreira.football.model.Models;
import com.stevebarreira.football.model.Picks;
import com.stevebarreira.football.repository.GamesRepository;
import com.stevebarreira.football.service.GamesService;
import com.stevebarreira.football.service.QueryBuilderService;
import com.stevebarreira.football.service.impl.QueryBuilderServiceImpl;

//import hello.QGames;

@RestController
@RequestMapping("/api")
public class GameController {
		
	@Autowired 
	private GamesService gamesService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/games",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Games> getAllGames(@RequestParam MultiValueMap<String, String> queryParameters) {	
		return gamesService.findAllGamesByParams(queryParameters);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/games")
	public Games createGame(@RequestBody Games game) {
		return gamesService.createGame(game);
	}
	
	@RequestMapping("/games/{id}")
	public Games games(@PathVariable String id){
		return gamesService.findById(id);
	}
	
	@RequestMapping("/games/weeklists")
	public List<Integer> getGameList(){
		return buildWeekList();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/games/{id}")
	public ResponseEntity<String> updatePick(@PathVariable String id, @RequestBody Games game) {
		
		Games resultingGame = gamesService.addOrUpdateGame(game);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(RequestUtils.locationBuilder(resultingGame.getId(), "games"));
		
		return new ResponseEntity<String>(responseHeaders, HttpStatus.OK);

	}
	
	private List<Integer> buildWeekList(){
		List<Integer> outputList = new ArrayList<Integer>();
		for(int i = 1; i < 17; i++){
			outputList.add(new Integer(i));
		}
		return outputList;
	}
	
	
}
