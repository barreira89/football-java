package com.stevebarreira.football.repository;

import java.util.List;

import com.stevebarreira.football.model.PicksDTO;
import com.stevebarreira.football.model.UserWeekSummaryDTO;

public interface PicksRepositoryCustom {
	
	List<PicksDTO> findPicksByUsernameWithGameDetails(String username, Integer season);
	
	List<UserWeekSummaryDTO> getUserSummary (String username, Integer season);

}
