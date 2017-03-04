package com.stevebarreira.football.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.stevebarreira.football.model.Games;
import com.stevebarreira.football.model.Leagues;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface LeaguesRepository extends MongoRepository<Leagues, String>, QueryDslPredicateExecutor<Leagues> {
	
	Leagues findById (String id);
}
