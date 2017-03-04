package com.stevebarreira.football.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.stevebarreira.football.model.Games;
import com.stevebarreira.football.model.Logos;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface LogosRepository extends MongoRepository<Logos, String> {

}
