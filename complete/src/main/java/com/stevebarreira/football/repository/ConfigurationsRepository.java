package com.stevebarreira.football.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stevebarreira.football.model.Configurations;

public interface ConfigurationsRepository extends MongoRepository<Configurations, String> {

	
}
