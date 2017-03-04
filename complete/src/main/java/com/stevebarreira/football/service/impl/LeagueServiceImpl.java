package com.stevebarreira.football.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.stevebarreira.football.model.Leagues;
import com.stevebarreira.football.model.Models;
import com.stevebarreira.football.repository.LeaguesRepository;
import com.stevebarreira.football.service.LeaguesService;
import com.stevebarreira.football.service.QueryBuilderService;

@Service
public class LeagueServiceImpl implements LeaguesService {
		
	@Autowired
	LeaguesRepository leaguesRepository;
	
	@Autowired
	QueryBuilderService queryService;
	
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
}
