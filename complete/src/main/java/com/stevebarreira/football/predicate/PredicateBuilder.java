package com.stevebarreira.football.predicate;

import java.util.ArrayList;
import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

public interface PredicateBuilder {
	
	
	public PredicateBuilder with(String key, Object value);
	
	public BooleanExpression build();
	

}
