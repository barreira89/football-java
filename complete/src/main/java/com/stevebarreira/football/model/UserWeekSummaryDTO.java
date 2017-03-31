package com.stevebarreira.football.model;

public class UserWeekSummaryDTO {
	
	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private String username;
	private int weekNumber;
	private int wins;
	private int losses;
	private int season;
	
	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public UserWeekSummaryDTO(){
		this.wins = 0;
		this.losses = 0;
	};
	
	public void addWin(){
		wins ++;
	}
	public void addLoss(){
		losses ++;
	};

}
