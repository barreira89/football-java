package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import model.Leagues;
import repository.LeaguesRepository;
import service.LeagueService;

@Service
public class LeagueServiceImpl implements LeagueService{
	
	private static final String LEAGUES = "LEAGUES";
	
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
		return (List<Leagues>) leaguesRepository.findAll(queryService.createQuery(queryParameters, LEAGUES));
	}

	@Override
	public Leagues getLeagueById(String id) {
		return leaguesRepository.findById(id);
	}

}
