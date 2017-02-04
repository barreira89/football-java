package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Games;
import repository.GamesRepository;
import service.impl.QueryBuilderServiceImpl;

//import hello.QGames;

@RestController
public class GameController {
		
	private static final String GAME = "GAMES";
	
	@Autowired 
	private GamesRepository gameRepository;
	
	@Autowired
	private QueryBuilderServiceImpl queryService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/games",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Games> getAllGames(@RequestParam MultiValueMap<String, String> queryParameters) {	
		//BooleanExpression expression = ;
		
		return (List<Games>) gameRepository.findAll(queryService.createQuery(queryParameters, GAME));
		//return  gameRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/games")
	public String createGame(@RequestBody Games game) {
		return gameRepository.save(game).id;
	}
	
	@RequestMapping("/games/{id}")
	public Games games(@PathVariable String id, @RequestBody Games game){
		return gameRepository.findOne(id);
	}
	
	
}
