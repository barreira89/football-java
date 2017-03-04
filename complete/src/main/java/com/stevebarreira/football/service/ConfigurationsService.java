package com.stevebarreira.football.service;
import java.util.List;

import com.stevebarreira.football.model.Configurations;

public interface ConfigurationsService {
	
	List<Configurations> getAllConfigurations();
	
	Configurations findById(String id);
}
