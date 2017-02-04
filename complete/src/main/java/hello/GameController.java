package hello;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
import com.querydsl.core.types.dsl.BooleanExpression;

//import hello.QGames;

@RestController
public class GameController {
		
	@Autowired 
	private GamesRepository gameRepository;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/games",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Games> getAllGames(@RequestParam MultiValueMap<String, String> params) {	
		BooleanExpression expression = createQuery(params);
		
		return (List<Games>) gameRepository.findAll(expression);
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
	
	//Move to Service;
	private BooleanExpression createQuery (MultiValueMap<String, String> params){
		GamePredicateBuilder builder = new GamePredicateBuilder();
		if(params.size() == 0){
			return null;
		}
		for (Entry<String, List<String>> entry : params.entrySet()){
			builder.with(entry.getKey(), entry.getValue().get(0));
		}
		return builder.build();

	}
	
}
