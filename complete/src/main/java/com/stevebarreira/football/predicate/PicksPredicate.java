package com.stevebarreira.football.predicate;

import com.querydsl.core.types.dsl.PathBuilder;
import com.stevebarreira.football.model.Picks;

public class PicksPredicate extends AbstractPredicate implements Predicate {

	protected PicksPredicate(SearchCriteria criteria) {
		super(criteria);
	}

	@Override
	protected PathBuilder getPathBuilder() {
		return new PathBuilder<Picks> (Picks.class, "picks");
	}

}
