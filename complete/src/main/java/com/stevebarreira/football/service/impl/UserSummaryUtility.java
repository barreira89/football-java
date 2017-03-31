package com.stevebarreira.football.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import com.stevebarreira.football.model.PicksDTO;
import com.stevebarreira.football.model.UserWeekSummaryDTO;

@Service
public class UserSummaryUtility {


	public List<UserWeekSummaryDTO> createSummary (List<PicksDTO> userPicks, String username){
		//Map<Integer, List<PicksDTO>> userPicksByWeek = getUserPicksByWeek(userPicks);
		Map<Integer, Map<Integer, List<PicksDTO>>> userPicksBySeasonAndWeek = getUserPicksByWeekAndSeason(userPicks);
		return summaryUserPicksSeason(userPicksBySeasonAndWeek);
		
	}
	
	private List<UserWeekSummaryDTO> summarizeUserPicks (Map<Integer, List<PicksDTO>> userPicksByWeek) {
		List<UserWeekSummaryDTO> userWeekSummaryList = new ArrayList<UserWeekSummaryDTO>();
		
		userPicksByWeek.forEach((k, v) -> {
			UserWeekSummaryDTO userWeekSummary = new UserWeekSummaryDTO();
			
			
			//TODO: Fix this
			String username = v.get(0) == null ? null : v.get(0).getUsername();
			double season =  v.get(0) == null ? null : v.get(0).getSeason();
			userWeekSummary.setSeason((int) season); 
			
			userWeekSummary.setWeekNumber(k);
			userWeekSummary.setUsername(username);
			
			
			v.forEach(p -> {
				if(didUserPickWinner(p)){
					userWeekSummary.addWin();
				} else {
					userWeekSummary.addLoss();
				}
			});
			userWeekSummaryList.add(userWeekSummary);
		});
		return userWeekSummaryList;	
	}
	
	private List<UserWeekSummaryDTO> summaryUserPicksSeason (Map<Integer, Map<Integer, List<PicksDTO>>> userPicksByWeekAndSeason){
		List<UserWeekSummaryDTO> userWeekSummaryList = new ArrayList<UserWeekSummaryDTO>();
		
		userPicksByWeekAndSeason.forEach((season, pickListByWeek) ->{
			pickListByWeek.forEach((week,pick)->{
				UserWeekSummaryDTO userWeekSummary = new UserWeekSummaryDTO();			
				//TODO: Fix this
				String username = pick.get(0) == null ? null : pick.get(0).getUsername();
				userWeekSummary.setSeason(season); 
				userWeekSummary.setWeekNumber(week);
				userWeekSummary.setUsername(username);
				
				pick.forEach(p -> {
					if(didUserPickWinner(p)){
						userWeekSummary.addWin();
					} else {
						userWeekSummary.addLoss();
					}
				});
				userWeekSummaryList.add(userWeekSummary);
				
			});
			
		});
		return userWeekSummaryList;
				
				
	}
	
	private boolean didUserPickWinner (PicksDTO userPick) {
		if(userPick.getGameDetails() != null){
			if(compareStrings(userPick.getWinner(), userPick.getGameDetails().getWinner())){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}
	
	private Map<Integer, List<PicksDTO>> getUserPicksByWeek (List<PicksDTO> userPicks){
		return userPicks
				.stream()
				.collect(Collectors.groupingBy(p -> p.getWeek()));
	}
	
	private Map<Integer, Map<Integer, List<PicksDTO>>> getUserPicksByWeekAndSeason (List<PicksDTO> userPicks){
		return userPicks
				.stream()
				.collect(Collectors.groupingBy(p -> (int)p.getSeason(), Collectors.groupingBy(p -> p.getWeek())));
	}
	
	private static boolean compareStrings (String str1, String str2 ){
		 return (str1 == null ? str2 == null : str1.equals(str2));
	}
}
