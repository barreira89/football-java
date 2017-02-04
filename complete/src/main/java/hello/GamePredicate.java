package hello;

import hello.QGames;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

public class GamePredicate {

	private SearchCriteria criteria;
	
	GamePredicate(SearchCriteria criteria){
		this.criteria = criteria;
	}
	
	public BooleanExpression getPredicate(){
		PathBuilder<Games> entityPath = new PathBuilder<Games> (Games.class, "games");
		
		if(isNumeric(criteria.getValue().toString())){
			int value = Integer.parseInt(criteria.getValue().toString());
			NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
			return path.eq(value);
		}
		else {
			StringPath path = entityPath.getString(criteria.getKey());
			return path.containsIgnoreCase(criteria.getValue().toString());
		}
		
		
	}
	
	private boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
}
