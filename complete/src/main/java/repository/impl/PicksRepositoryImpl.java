package repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;


import model.Picks;
import model.PicksDTO;
import repository.PicksRepositoryCustom;

public class PicksRepositoryImpl implements PicksRepositoryCustom {
	
	private final MongoTemplate mongoTemplate;
	
	@Autowired
	public PicksRepositoryImpl(MongoTemplate mongoTemplate){
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<PicksDTO> findPicksByUsernameWithGameDetails(String username) {
		LookupOperation lookupOperation = getLookUpOperation();
		MatchOperation matchOperation = getMatchOperation(username);
		return mongoTemplate.aggregate(Aggregation.newAggregation(
				matchOperation,
				lookupOperation
				), Picks.class, PicksDTO.class).getMappedResults();
	}
	
	private LookupOperation getLookUpOperation(){
		return Aggregation.lookup("games", "game", "_id", "gameDetails");
	}
	
	private MatchOperation getMatchOperation(String username){
		Criteria pickCriteria = Criteria.where("username").is(username); 
		return Aggregation.match(pickCriteria);
	}
	
}
