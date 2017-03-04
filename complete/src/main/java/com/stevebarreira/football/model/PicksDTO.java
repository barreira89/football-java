package com.stevebarreira.football.model;

import java.util.List;

public class PicksDTO extends Picks {

	private Games gameDetails;
	
	private List<Games> gameDetailList;
	
	public void setGameDetailList(List<Games> gameDetailList) {
		this.gameDetailList = gameDetailList;
	}

	PicksDTO(){};
	
	public Games getGameDetails() {
		if(gameDetailList.size() > 0){
			return gameDetailList.get(0);
		} else {
			return null;
		}
	}

	public void setGameDetails(Games gameDetails) {
		this.gameDetails = gameDetails;
	}

}
