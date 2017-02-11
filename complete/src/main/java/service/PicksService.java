package service;
import java.util.List;

import org.springframework.util.MultiValueMap;

import model.Picks;
import model.PicksExpand;

public interface PicksService {

	public List<Picks> findAllPicks();
	
	public List<Picks> findAllPicksByParams(MultiValueMap<String, String> queryParameters);
	
	public Picks getPicksById (String id);
	
	public Picks addOrUpdatePick (Picks leagueToUpdate, String id);
	
//	public Picks createLeague (Picks league);
	
	public List<PicksExpand> findAllPicksWithGames();
	
}
