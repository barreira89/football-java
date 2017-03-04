package com.stevebarreira.football.service.impl;

import com.stevebarreira.football.model.Models;
import com.stevebarreira.football.predicate.GamePredicateBuilder;
import com.stevebarreira.football.predicate.LeaguesPredicateBuilder;
import com.stevebarreira.football.predicate.PicksPredicateBuilder;
import com.stevebarreira.football.predicate.PredicateBuilder;

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
