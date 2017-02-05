package model.impl;

import com.querydsl.core.types.dsl.PathBuilder;

import model.AbstractPredicate;
import model.Leagues;
import model.Predicate;
import model.SearchCriteria;

public class LeaguesPredicate extends AbstractPredicate implements Predicate {

	protected LeaguesPredicate(SearchCriteria criteria) {
		super(criteria);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected PathBuilder getPathBuilder() {
		return new PathBuilder<Leagues> (Leagues.class, "leagues");
	}

}
