package service;
import java.util.List;

import org.springframework.util.MultiValueMap;

import model.Leagues;

public interface LeagueService {

	public List<Leagues> findAllLeagues();
	
	public List<Leagues> findAllLeaguesByParams(MultiValueMap<String, String> queryParameters);
	
	public Leagues getLeagueById (String id);
}
