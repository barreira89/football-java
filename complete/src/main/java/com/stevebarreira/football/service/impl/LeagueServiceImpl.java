package com.stevebarreira.football.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.stevebarreira.football.model.LeagueSummary;
import com.stevebarreira.football.model.Leagues;
import com.stevebarreira.football.model.Models;
import com.stevebarreira.football.model.UserSummaryDTO;
import com.stevebarreira.football.model.UserWeekSummaryDTO;
import com.stevebarreira.football.repository.LeaguesRepository;
import com.stevebarreira.football.service.LeaguesService;
import com.stevebarreira.football.service.PicksService;
import com.stevebarreira.football.service.QueryBuilderService;

@Service
public class LeagueServiceImpl implements LeaguesService {
		
	@Autowired
	LeaguesRepository leaguesRepository;
	
	@Autowired
	QueryBuilderService queryService;
	
	@Autowired
	PicksService pickService;
	
	@Override
	public List<Leagues> findAllLeagues() {
		return (List<Leagues>) leaguesRepository.findAll();
	}

	@Override
	public List<Leagues> findAllLeaguesByParams(MultiValueMap<String, String> queryParameters) {
		return (List<Leagues>) leaguesRepository.findAll(queryService.createQuery(queryParameters, Models.LEAGUES));
	}

	@Override
	public Leagues getLeagueById(String id) {
		return leaguesRepository.findById(id);
	}

	@Override
	public Leagues addOrUpdateLeague (Leagues incomingLeague, String incomingId) {
		Leagues leagueToSave;
		Leagues exsitingLeague = leaguesRepository.findOne(incomingId);
		
		if(exsitingLeague == null){
			leagueToSave = incomingLeague;
		} else {
			leagueToSave = exsitingLeague;
			leagueToSave.setName(incomingLeague.name);
			leagueToSave.setUserIds(incomingLeague.userIds);
			leagueToSave.setUsers(incomingLeague.users);
		}
		return leaguesRepository.save(leagueToSave);
	}

	public Leagues createLeague (Leagues leagueToCreate){
		return leaguesRepository.save(leagueToCreate);
	}

	@Override
	public List<Leagues> findLeaguesByUserName(String username) {
		return leaguesRepository.findLeaguesByUserName(username);
	}
	
	public List<UserSummaryDTO> getLeagueSummary (String id) {
		List<UserSummaryDTO> userSummaryDTO = new ArrayList<UserSummaryDTO>();
		List<String> users = getUsersByLeagueId(id);
		users.forEach(user -> {
			List<UserWeekSummaryDTO> userSummary = pickService.getUserSummary(user, null);
			userSummaryDTO.add(new UserSummaryDTO(user, userSummary));
		});
		return userSummaryDTO;
	}

	@Override
	public List<LeagueSummary> getLeagueSummaryByWeek(String id) {
		List<UserSummaryDTO> userSummaryDTO = getLeagueSummary(id);
		List<LeagueSummary> leagueSummary = new ArrayList<LeagueSummary>();
		List<UserWeekSummaryDTO> userWeekSummaries = new ArrayList<UserWeekSummaryDTO>();
		
		userSummaryDTO.forEach(usd -> {
			userWeekSummaries.addAll((usd.getUserWeekSummary()));
		});
		
		Map<Integer, Map<Integer, List<UserWeekSummaryDTO>>> userSummaryByWeekAndSeason = 
				userWeekSummaries.stream().collect(Collectors.groupingBy(UserWeekSummaryDTO::getSeason, 
						Collectors.groupingBy(UserWeekSummaryDTO::getWeekNumber)));
		
		userSummaryByWeekAndSeason.forEach((season,summaryByWeeks)->{
			summaryByWeeks.forEach((week, summary)->{
				leagueSummary.add(new LeagueSummary(week, season, summary));
			});
		});
		
		return leagueSummary;
	}
	
	private List<String> getUsersByLeagueId (String id) {
		
		return leaguesRepository.findById(id).getUsers();
	}
	
}
