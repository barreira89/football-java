package repository;

import java.util.List;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import model.Picks;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PicksRepository extends MongoRepository<Picks, String>, QueryDslPredicateExecutor<Picks> {

	List<Picks> findBySeason(int season);
	
}
