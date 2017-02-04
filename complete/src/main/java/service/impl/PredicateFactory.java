package service.impl;

import model.PredicateBuilder;
import model.Impl.GamePredicateBuilder;
import model.Impl.LeaguesPredicateBuilder;

public class PredicateFactory {

	public static PredicateBuilder getPredicate(String type) {
		if (type == "GAMES"){
			return new GamePredicateBuilder();
		} else if (type =="LEAGUES"){
			return new LeaguesPredicateBuilder();
		} else {
			return null;
		}
		
	}
}
