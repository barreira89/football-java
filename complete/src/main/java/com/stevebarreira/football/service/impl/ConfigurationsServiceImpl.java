package com.stevebarreira.football.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stevebarreira.football.model.Configurations;
import com.stevebarreira.football.model.Games;
import com.stevebarreira.football.model.GamesDTO;
import com.stevebarreira.football.model.Logos;
import com.stevebarreira.football.model.Test;
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
	
	public void testRest(){
//		List<Games> superList = new ArrayList<Games>();
//		
//		RestTemplate restTemplate = new RestTemplate();
//		for (int i = 1; i < 10; i++){
//			ResponseEntity<Games[]> response = restTemplate.getForEntity("http://localhost:8080/api/games", Games[].class);
//			Games[] result = response.getBody();
//			superList.addAll(Arrays.asList(result));
//		}
//		
//		IntSummaryStatistics iss = superList.stream().collect(Collectors.summarizingInt(Games::getSeason));
//		System.out.println(iss);

	}
	

}
