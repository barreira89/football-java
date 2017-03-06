package com.stevebarreira.football.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.stevebarreira.football.model.Models;
import com.stevebarreira.football.model.Picks;
import com.stevebarreira.football.model.PicksDTO;
import com.stevebarreira.football.model.UserWeekSummaryDTO;
import com.stevebarreira.football.repository.PicksRepository;
import com.stevebarreira.football.service.PicksService;
import com.stevebarreira.football.service.QueryBuilderService;

@Service
public class PicksServiceImpl implements PicksService {

	@Autowired
	PicksRepository picksRepository;
	
	@Autowired
	QueryBuilderService queryService;
	
	@Override
	public List<Picks> findAllPicks() {
		return (List<Picks>) picksRepository.findAll();
	}

	@Override
	public List<Picks> findAllPicksByParams(MultiValueMap<String, String> queryParameters) {
		return (List<Picks>) picksRepository.findAll(queryService.createQuery(queryParameters, Models.PICKS));
	}

	@Override
	public Picks getPicksById(String id) {
		return picksRepository.findOne(id);
	}

	@Override
	public Picks addOrUpdatePick(Picks pickToSave, String id) {
		return picksRepository.save(pickToSave);
	}

	@Override
	public List<PicksDTO> findAllPicksWithGames(String username) {
		return picksRepository.findPicksByUsernameWithGameDetails(username);
	}

	@Override
	public void updateListOfPicks(List<Picks> inputPicks) {
		inputPicks.forEach(
				p -> {
					picksRepository.save(p);
				});
	}

	@Override
	public List<UserWeekSummaryDTO> getUserSummary(String username) {
		return picksRepository.getUserSummary(username);
	}

}
