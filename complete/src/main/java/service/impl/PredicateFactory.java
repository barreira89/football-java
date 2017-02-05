package service.impl;

import model.PredicateBuilder;
import model.impl.GamePredicateBuilder;
import model.impl.LeaguesPredicateBuilder;
import model.Models;

public class PredicateFactory {

	public static PredicateBuilder getPredicate(Models type) {
		if (type == Models.GAMES){
			return new GamePredicateBuilder();
		} else if (type == Models.LEAGUES){
			return new LeaguesPredicateBuilder();
		} else {
			return null;
		}
		
	}
}
