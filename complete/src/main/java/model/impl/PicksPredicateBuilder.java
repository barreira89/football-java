package model.impl;

import model.AbstractPredicateBuilder;
import model.Predicate;
import model.SearchCriteria;

public class PicksPredicateBuilder extends AbstractPredicateBuilder{

	@Override
	protected Predicate createPredicate(SearchCriteria searchCriteria) {
		return new PicksPredicate(searchCriteria);
	}

}
