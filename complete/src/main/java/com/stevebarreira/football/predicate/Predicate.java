package com.stevebarreira.football.predicate;

import com.querydsl.core.types.dsl.BooleanExpression;

public interface Predicate {

	public BooleanExpression getPredicate();
	
}
