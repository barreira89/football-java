package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import model.Games;
import model.Models;
import model.Picks;
import model.PicksExpand;
import repository.GamesRepository;
import repository.PicksRepository;
import service.PicksService;

@Service
public class PicksServiceImpl implements PicksService {

	@Autowired
	PicksRepository picksRepository;
	
	@Autowired
	GamesRepository gamesRepository;
	
	@Autowired
	QueryBuilderServiceImpl queryService;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Picks addOrUpdatePick(Picks leagueToUpdate, String id) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Picks createLeague(Picks league) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	//TODO: Refactor to be more efficient.
	@Override
	public List<PicksExpand> findAllPicksWithGames() {
		// TODO Auto-generated method stub
		List<Picks> foundPicks = picksRepository.findAll();
		List<PicksExpand> g = new ArrayList<PicksExpand>();
		
		foundPicks.stream().forEach(p -> g.add(
					new PicksExpand(p.getId(), p.getUsername(), p.getWeek(), gamesRepository.findOne(p.getGame()), p.getSeason(), p.getWinner())));
		
		System.out.println(g.size());
		return g;
	}

}
