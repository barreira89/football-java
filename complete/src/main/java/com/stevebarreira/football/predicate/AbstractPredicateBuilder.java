package com.stevebarreira.football.predicate;

import java.util.ArrayList;
import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

public abstract class AbstractPredicateBuilder implements PredicateBuilder {
	
	private List<SearchCriteria> params = new ArrayList<SearchCriteria>();
	
	public AbstractPredicateBuilder with(String key, Object value){
		params.add(new SearchCriteria(key, value));
		return null;
	}
	
	public BooleanExpression build(){
		if (params.size() == 0){
			return null;
		}
		List<BooleanExpression> predicates = new ArrayList<BooleanExpression>();
		Predicate predicate;
		
		for (SearchCriteria param : params) {
			predicate = createPredicate(param);
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
	
	protected abstract Predicate createPredicate (SearchCriteria searchCriteria);
	
}