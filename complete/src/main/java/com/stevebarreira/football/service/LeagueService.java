package com.stevebarreira.football.service;
import java.util.List;

import org.springframework.util.MultiValueMap;

import com.stevebarreira.football.model.Leagues;

public interface LeagueService {

	public List<Leagues> findAllLeagues();
	
	public List<Leagues> findAllLeaguesByParams(MultiValueMap<String, String> queryParameters);
	
	public Leagues getLeagueById (String id);
	
	public Leagues addOrUpdateLeague (Leagues leagueToUpdate, String id);
	
	public Leagues createLeague (Leagues league);
}
