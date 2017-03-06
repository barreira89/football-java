package com.stevebarreira.football.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.stevebarreira.football.model.PicksDTO;
import com.stevebarreira.football.model.UserWeekSummaryDTO;

@Service
public class UserSummaryUtility {


	public List<UserWeekSummaryDTO> createSummary (List<PicksDTO> userPicks){
		Map<Integer, List<PicksDTO>> userPicksByWeek = getUserPicksByWeek(userPicks);
		return summarizeUserPicks(userPicksByWeek);
		
	}
	
	private List<UserWeekSummaryDTO> summarizeUserPicks (Map<Integer, List<PicksDTO>> userPicksByWeek) {
		List<UserWeekSummaryDTO> userWeekSummaryList = new ArrayList<UserWeekSummaryDTO>();
		
		userPicksByWeek.forEach((k, v) -> {
			UserWeekSummaryDTO userWeekSummary = new UserWeekSummaryDTO();
			userWeekSummary.setWeekNumber(k);
			v.forEach(p -> {
				if(getGameResult(p)){
					userWeekSummary.addWin();
				} else {
					userWeekSummary.addLoss();
				}
			});
			userWeekSummaryList.add(userWeekSummary);
		});
		return userWeekSummaryList;	
	}
	
	private boolean getGameResult (PicksDTO userPick) {
		if(userPick.getGameDetails() != null){
			String userGamePick = userPick.getWinner();
			String actualGameWinner = userPick.getGameDetails().getWinner();
			if(compareStrings(userGamePick, actualGameWinner)){
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
	
	private static boolean compareStrings (String str1, String str2 ){
		 return (str1 == null ? str2 == null : str1.equals(str2));
	}
}
