package com.stevebarreira.football.service;
import java.util.List;

import org.springframework.util.MultiValueMap;

import com.stevebarreira.football.model.LeagueSummary;
import com.stevebarreira.football.model.Leagues;
import com.stevebarreira.football.model.UserSummaryDTO;

public interface LeaguesService {

	public List<Leagues> findAllLeagues();
	
	public List<Leagues> findAllLeaguesByParams(MultiValueMap<String, String> queryParameters);
	
	public Leagues getLeagueById (String id);
	
	public Leagues addOrUpdateLeague (Leagues leagueToUpdate, String id);
	
	public Leagues createLeague (Leagues league);
	
	public List<Leagues> findLeaguesByUserName (String username);
	
	public List<UserSummaryDTO> getLeagueSummary (String id);
	
	public List<LeagueSummary> getLeagueSummaryByWeek (String id);
}
