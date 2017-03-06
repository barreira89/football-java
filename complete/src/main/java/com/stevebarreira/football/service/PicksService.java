package com.stevebarreira.football.service;
import java.util.List;

import org.springframework.util.MultiValueMap;

import com.stevebarreira.football.model.Picks;
import com.stevebarreira.football.model.PicksDTO;
import com.stevebarreira.football.model.UserWeekSummaryDTO;

public interface PicksService {

	public List<Picks> findAllPicks();
	
	public List<Picks> findAllPicksByParams(MultiValueMap<String, String> queryParameters);
	
	public Picks getPicksById (String id);
	
	public Picks addOrUpdatePick (Picks pick, String id);
	
	public List<PicksDTO> findAllPicksWithGames(String username);
	
	public void updateListOfPicks(List<Picks> inputPicks);
	
	public List<UserWeekSummaryDTO> getUserSummary(String username);
	
}
