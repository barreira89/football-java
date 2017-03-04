package com.stevebarreira.football.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.stevebarreira.football.repository.PicksOnAfterLoad;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "nodetest1";
	}

	@Override
	@Bean
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return new MongoClient("localhost:27017");
	}
	
	@Bean
	public PicksOnAfterLoad picksOnAfterLoad() {
	    return new PicksOnAfterLoad();
	}

}
