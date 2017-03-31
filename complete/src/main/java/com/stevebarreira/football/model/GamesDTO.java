package com.stevebarreira.football.model;

import java.util.List;

public class GamesDTO {
	
	private List<Games> games;

	public List<Games> getGames() {
		return games;
	}

	public void setGames(List<Games> games) {
		this.games = games;
	}
	
	public GamesDTO(){};
}
