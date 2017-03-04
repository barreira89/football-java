package com.stevebarreira.football.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.stevebarreira.football.model.Games;
import com.stevebarreira.football.model.Models;
import com.stevebarreira.football.repository.GamesRepository;
import com.stevebarreira.football.service.GamesService;
import com.stevebarreira.football.service.QueryBuilderService;

@Service
public class GamesServiceImpl implements GamesService {

	@Autowired
	GamesRepository gamesRepository;
	
	@Autowired
	QueryBuilderService queryService;
	
	@Override
	public List<Games> findAllGames() {
		return gamesRepository.findAll();
	}

	@Override
	public List<Games> findAllGamesByParams(MultiValueMap<String, String> queryParameters) {
		return (List<Games>) gamesRepository.findAll(queryService.createQuery(queryParameters, Models.GAMES));
	}

	@Override
	public Games createGame(Games game) {
		return gamesRepository.save(game);
	}

	@Override
	public Games findById(String id) {
		return gamesRepository.findOne(id);
	}

	@Override
	public Games addOrUpdateGame(Games game) {
		return gamesRepository.save(game);
	}

}
