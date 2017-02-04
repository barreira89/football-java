package hello;

import java.util.ArrayList;
import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

public class GamePredicateBuilder {
	
	private List<SearchCriteria> params = new ArrayList<SearchCriteria>();
	
	public GamePredicateBuilder(){
	}
	
	public GamePredicateBuilder with(String key, Object value){
		params.add(new SearchCriteria(key, value));
		return null;
	}
	
	public BooleanExpression build(){
		if (params.size() == 0){
			return null;
		}
		List<BooleanExpression> predicates = new ArrayList<BooleanExpression>();
		GamePredicate predicate;
		
		for (SearchCriteria param : params) {
			predicate = new GamePredicate(param);
			BooleanExpression expr = predicate.getPredicate();
			if (expr != null){
				predicates.add(expr);
			}
		}
		BooleanExpression result = predicates.get(0);
		for (int i = 1; i < predicates.size(); i++){
			result = result.and(predicates.get(i));
		}
		return result;
		
	}

}
