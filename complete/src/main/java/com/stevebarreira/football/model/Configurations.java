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
	private String configName;
	
	Configurations(String id, String currentSeason, String configName){
		this.id = id;
		this.currentSeason = currentSeason;
		this.configName = configName;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurrentSeason() {
		return currentSeason;
	}

	public void setCurrentSeason(String currentSeason) {
		this.currentSeason = currentSeason;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	Configurations(){}
	
	
}
