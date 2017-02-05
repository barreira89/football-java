package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import model.Leagues;
import model.Models;
import repository.LeaguesRepository;
import service.LeagueService;

@Service
public class LeagueServiceImpl implements LeagueService{
		
	@Autowired
	LeaguesRepository leaguesRepository;
	
	@Autowired
	QueryBuilderServiceImpl queryService;
	
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
}
//Leagues currentLeague = leaguesRepository.findById(id);
//if (currentLeague == null){
//	currentLeague = league;
//} else {
//	currentLeague.setUserIds(league.userIds);
//	currentLeague.setName(league.name);
//	currentLeague.setUsers(league.users);		
//}
//
//String currentId = leaguesRepository.save(currentLeague).id;