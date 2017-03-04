package com.stevebarreira.football.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stevebarreira.football.model.Configurations;
import com.stevebarreira.football.model.Logos;
import com.stevebarreira.football.repository.ConfigurationsRepository;
import com.stevebarreira.football.repository.LogosRepository;
import com.stevebarreira.football.service.ConfigurationsService;

@Service
public class ConfigurationsServiceImpl implements ConfigurationsService {

	@Autowired
	ConfigurationsRepository configurationRepository;
	
	@Autowired
	LogosRepository logosRepository;
	
	@Override
	public List<Configurations> getAllConfigurations() {
		return configurationRepository.findAll();
	}

	@Override
	public Configurations findById(String id) {
		return configurationRepository.findOne(id);
	}

	public List<Logos> getAllLogos() {
		return logosRepository.findAll();
	}
	
	

}
