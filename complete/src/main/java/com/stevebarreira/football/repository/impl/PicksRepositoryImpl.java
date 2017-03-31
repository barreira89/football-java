package com.stevebarreira.football.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import com.stevebarreira.football.model.Picks;
import com.stevebarreira.football.model.PicksDTO;
import com.stevebarreira.football.model.UserWeekSummaryDTO;
import com.stevebarreira.football.repository.PicksRepositoryCustom;
import com.stevebarreira.football.service.impl.UserSummaryUtility;

public class PicksRepositoryImpl implements PicksRepositoryCustom {
	
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	private UserSummaryUtility userSummaryUtility;
	
	@Autowired
	public PicksRepositoryImpl(MongoTemplate mongoTemplate){
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<PicksDTO> findPicksByUsernameWithGameDetails(String username, Integer season) {
		return getPicksWithDetails(username, season);
	}
	
	private List<PicksDTO> getPicksWithDetails (String username, Integer season) {
		LookupOperation lookupOperation = getLookUpOperation();
		MatchOperation matchOperation = getMatchOperation(username, season);
		return mongoTemplate.aggregate(Aggregation.newAggregation(
				matchOperation,
				lookupOperation
				), Picks.class, PicksDTO.class).getMappedResults();
	}
	
	private LookupOperation getLookUpOperation(){
		return Aggregation.lookup("games", "game", "_id", "gameDetailList");
	}
	
	private MatchOperation getMatchOperation(String username, Integer season){
		Criteria pickCriteria = Criteria.where("username").is(username); 
		if(season != null){
			pickCriteria = Criteria.where("season").is(season.intValue()).andOperator(pickCriteria);
		}
		return Aggregation.match(pickCriteria);
	}

	@Override
	public List<UserWeekSummaryDTO> getUserSummary(String username, Integer season) {
		List<PicksDTO> userPicks = getPicksWithDetails(username, season);
		return userSummaryUtility.createSummary(userPicks, username);
	}
	
}
