package com.stevebarreira.football.controller;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class RequestUtils {

	private static String APIPREFIX = "api/";
	
	public static  URI locationBuilder(String id, String resouce) {
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.pathSegment(APIPREFIX + resouce + "/{id}")
				.buildAndExpand(id).toUri();
		return location;
	}
}
