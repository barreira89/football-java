package com.stevebarreira.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stevebarreira.football.model.Configurations;
import com.stevebarreira.football.model.Logos;
import com.stevebarreira.football.service.ConfigurationsService;

@RestController
@RequestMapping("/api")
public class ConfigurationController {
	
	@Autowired
	ConfigurationsService configService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/configurations",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Configurations> getAllConfigurations(@RequestParam MultiValueMap<String, String> queryParameters) {	
		return configService.getAllConfigurations();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/logos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Logos> getAllLogos() {
		return configService.getAllLogos();
	}

}
