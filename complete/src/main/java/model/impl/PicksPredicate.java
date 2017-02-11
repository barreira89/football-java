package model.impl;

import com.querydsl.core.types.dsl.PathBuilder;

import model.AbstractPredicate;
import model.Picks;
import model.Predicate;
import model.SearchCriteria;

public class PicksPredicate extends AbstractPredicate implements Predicate {

	protected PicksPredicate(SearchCriteria criteria) {
		super(criteria);
	}

	@Override
	protected PathBuilder getPathBuilder() {
		return new PathBuilder<Picks> (Picks.class, "picks");
	}

}
