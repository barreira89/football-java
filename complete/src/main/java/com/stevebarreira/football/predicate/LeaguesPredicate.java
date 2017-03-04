package com.stevebarreira.football.predicate;

import com.querydsl.core.types.dsl.PathBuilder;
import com.stevebarreira.football.model.Leagues;

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
