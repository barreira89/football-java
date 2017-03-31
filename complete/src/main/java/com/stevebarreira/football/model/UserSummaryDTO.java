package com.stevebarreira.football.model;

import java.util.List;

public class UserSummaryDTO {
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<UserWeekSummaryDTO> getUserWeekSummary() {
		return userWeekSummary;
	}

	public void setUserWeekSummary(List<UserWeekSummaryDTO> userWeekSummary) {
		this.userWeekSummary = userWeekSummary;
	}

	private String username;
	private List<UserWeekSummaryDTO> userWeekSummary;
	
	UserSummaryDTO(){}
	
	public UserSummaryDTO(String username, List<UserWeekSummaryDTO> userWeekSummary){
		this.username = username;
		this.userWeekSummary = userWeekSummary;
	}
	

}
