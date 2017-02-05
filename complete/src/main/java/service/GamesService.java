package service;
import java.util.List;

import org.springframework.util.MultiValueMap;

import model.Games;

public interface GamesService {
	
	List<Games> findAllGames();
	
	List<Games> findAllGamesByParams (MultiValueMap<String, String> queryParameters);
	
	

}
