package com.stevebarreira.football.predicate;

import java.util.ArrayList;
import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

public class GamePredicateBuilder extends AbstractPredicateBuilder {

	@Override
	protected Predicate createPredicate(SearchCriteria searchCriteria) {
		return new GamePredicate(searchCriteria);
	}


	
	

}
