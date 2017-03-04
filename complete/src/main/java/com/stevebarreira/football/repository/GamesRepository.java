package com.stevebarreira.football.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.stevebarreira.football.model.Games;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface GamesRepository extends MongoRepository<Games, String>, QueryDslPredicateExecutor<Games> {

	List<Games> findBySeason(int season);
	
	List<Games> findByHomeOrVisitorOrSeason (String home, String visitor, int season);
}
