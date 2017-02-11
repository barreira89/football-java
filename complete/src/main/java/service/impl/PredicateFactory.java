package service.impl;

import model.PredicateBuilder;
import model.impl.GamePredicateBuilder;
import model.impl.LeaguesPredicateBuilder;
import model.impl.PicksPredicateBuilder;
import model.Models;

public class PredicateFactory {

	public static PredicateBuilder getPredicate(Models type) {
		
		PredicateBuilder predicateBuilder = null;
		
		switch (type){
			case GAMES  :predicateBuilder = new GamePredicateBuilder();
						break;
			case LEAGUES:predicateBuilder = new LeaguesPredicateBuilder();
						break;
			case PICKS  :predicateBuilder = new PicksPredicateBuilder();
						break;
		}
		return predicateBuilder;
		

	}
}
