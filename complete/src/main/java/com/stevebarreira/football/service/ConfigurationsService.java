package com.stevebarreira.football.service;
import java.util.List;

import com.stevebarreira.football.model.Configurations;
import com.stevebarreira.football.model.Logos;

public interface ConfigurationsService {
	
	List<Configurations> getAllConfigurations();
	
	Configurations findById(String id);
	
	List<Logos> getAllLogos();
	
	void testRest();
}
