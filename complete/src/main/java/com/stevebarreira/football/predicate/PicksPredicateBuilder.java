package com.stevebarreira.football.predicate;

public class PicksPredicateBuilder extends AbstractPredicateBuilder{

	@Override
	protected Predicate createPredicate(SearchCriteria searchCriteria) {
		return new PicksPredicate(searchCriteria);
	}

}
