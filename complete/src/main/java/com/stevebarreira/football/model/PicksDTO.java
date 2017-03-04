package com.stevebarreira.football.model;

import java.util.List;

public class PicksDTO extends Picks{

	List<Games> gameDetails;

	PicksDTO(){};
	
	public List<Games> getGameDetails() {
		return gameDetails;
	}

	public void setGameDetails(List<Games> gameDetails) {
		this.gameDetails = gameDetails;
	}

}
