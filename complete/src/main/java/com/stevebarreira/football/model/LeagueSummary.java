package com.stevebarreira.football.model;

import java.util.List;

public class LeagueSummary {
	
	private int weekNumber;
	private int season; 
	private List<UserWeekSummaryDTO> userWeekSummaries;	
	
	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public List<UserWeekSummaryDTO> getUserWeekSummaries() {
		return userWeekSummaries;
	}

	public void setUserWeekSummaries(List<UserWeekSummaryDTO> userWeekSummaries) {
		this.userWeekSummaries = userWeekSummaries;
	}
	
	LeagueSummary(){}
	
	public LeagueSummary(int weekNumber, int season, List<UserWeekSummaryDTO> userWeekSummaries){
		this.weekNumber = weekNumber;
		this.season = season;
		this.userWeekSummaries = userWeekSummaries;
	}
	
}
