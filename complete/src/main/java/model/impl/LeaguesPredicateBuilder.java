package model.impl;

import model.AbstractPredicateBuilder;
import model.Predicate;
import model.SearchCriteria;

public class LeaguesPredicateBuilder extends AbstractPredicateBuilder{

	@Override
	protected Predicate createPredicate(SearchCriteria searchCriteria) {
		return new LeaguesPredicate(searchCriteria);
	}

}
