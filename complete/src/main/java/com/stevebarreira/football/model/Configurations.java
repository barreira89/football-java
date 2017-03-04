package com.stevebarreira.football.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document
public class Configurations {

	@Id
	private String id;
	private String currentSeason;
	
	Configurations(String id, String currentSeason){
		this.id = id;
		this.currentSeason = currentSeason;
	}
	
	Configurations(){}
	
	
}
