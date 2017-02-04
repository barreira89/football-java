package model.Impl;

import java.util.ArrayList;
import java.util.List;

import com.querydsl.core.types.dsl.BooleanExpression;

import model.AbstractPredicateBuilder;
import model.Predicate;
import model.SearchCriteria;

public class GamePredicateBuilder extends AbstractPredicateBuilder {

	@Override
	protected Predicate createPredicate(SearchCriteria searchCriteria) {
		return new GamePredicate(searchCriteria);
	}


	
	

}
