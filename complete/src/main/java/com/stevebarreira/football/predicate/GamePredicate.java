package com.stevebarreira.football.predicate;

import com.querydsl.core.types.dsl.PathBuilder;
import com.stevebarreira.football.model.Games;

public class GamePredicate extends AbstractPredicate {

	GamePredicate(SearchCriteria criteria) {
		super(criteria);
	}

	@Override
	protected PathBuilder getPathBuilder() {
		return new PathBuilder<Games> (Games.class, "games");
	}


}
