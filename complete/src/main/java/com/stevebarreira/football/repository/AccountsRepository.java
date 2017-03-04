package com.stevebarreira.football.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.stevebarreira.football.model.Accounts;
import com.stevebarreira.football.model.Games;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface AccountsRepository extends MongoRepository<Accounts, String>, QueryDslPredicateExecutor<Accounts> {
	
	Accounts findByUsername(String username);
}
