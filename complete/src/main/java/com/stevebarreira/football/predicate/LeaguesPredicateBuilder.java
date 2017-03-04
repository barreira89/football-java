package com.stevebarreira.football.predicate;

public class LeaguesPredicateBuilder extends AbstractPredicateBuilder{

	@Override
	protected Predicate createPredicate(SearchCriteria searchCriteria) {
		return new LeaguesPredicate(searchCriteria);
	}

}
