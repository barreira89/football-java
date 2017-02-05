package model.impl;

import com.querydsl.core.types.dsl.PathBuilder;
import model.Games;
import model.AbstractPredicate;
import model.SearchCriteria;

public class GamePredicate extends AbstractPredicate {

	GamePredicate(SearchCriteria criteria) {
		super(criteria);
	}

	@Override
	protected PathBuilder getPathBuilder() {
		return new PathBuilder<Games> (Games.class, "games");
	}


}
