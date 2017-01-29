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

import com.querydsl.core.types.Predicate;

import hello.QGames;

@RestController
public class GameController {
	
	@Autowired
	QGames gameQuery;
	
	@Autowired 
	private GamesRepository gameRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/games",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Games> getAllGames(@RequestParam MultiValueMap<String, String> params) {
		QGames game = new QGames("games");
		
		int season = Integer.parseInt(params.getFirst("season"));
		Predicate predicate = game.season.eq(season);
		
		return (List<Games>) gameRepository.findAll(predicate);
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
	
	private QGames createQuery (MultiValueMap<String, String> params){
		QGames gameQuery = new QGames("games");
		
		if (params.getFirst("season")!= null){
			gameQuery.season.eq(Integer.parseInt(params.getFirst("season")));
		}
		
		return gameQuery;
		
	}
	
}
