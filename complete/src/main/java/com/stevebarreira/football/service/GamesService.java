package com.stevebarreira.football.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.stevebarreira.football.model.Games;

public interface GamesService {
	
	List<Games> findAllGames();
	
	List<Games> findAllGamesByParams (MultiValueMap<String, String> queryParameters);

	Games createGame(Games game);
	
	Games findById(String id);
}
