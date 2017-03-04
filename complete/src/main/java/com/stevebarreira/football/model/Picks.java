package com.stevebarreira.football.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document
public class Picks {
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public double getSeason() {
		return season;
	}

	public void setSeason(double season) {
		this.season = season;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Id
	String id;
	String username;
	int week;
	String game;
	double season;
	String winner;
	
	Picks(){};
	
	Picks(String id, String username, int week, String game, double season, String winner){
		this.id = id;
		this.username = username;
		this.week = week;
		this.game = game;
		this.season = season;
		this.winner = winner;
	}
}
