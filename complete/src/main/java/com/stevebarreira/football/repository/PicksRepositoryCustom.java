package com.stevebarreira.football.repository;

import java.util.List;

import com.stevebarreira.football.model.PicksDTO;

public interface PicksRepositoryCustom {
	
	List<PicksDTO> findPicksByUsernameWithGameDetails(String username);

}
