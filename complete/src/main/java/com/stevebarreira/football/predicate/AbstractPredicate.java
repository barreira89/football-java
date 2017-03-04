package com.stevebarreira.football.predicate;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

public abstract class AbstractPredicate implements Predicate{

private SearchCriteria criteria;
	
	protected AbstractPredicate(SearchCriteria criteria){
		this.criteria = criteria;
	}
	
	public BooleanExpression getPredicate(){
		PathBuilder entityPath = getPathBuilder();
		
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
	
	protected abstract PathBuilder getPathBuilder();
	
	private boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}  
}
