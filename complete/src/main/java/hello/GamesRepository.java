package hello;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GamesRepository extends MongoRepository<Games, String>, QueryDslPredicateExecutor<Games> {

	List<Games> findBySeason(int season);
	
	@Query("{ 'season': ?0, 'home': ?1}")
	List<Games> findByQueryParams(int season, String home);
	
	List<Games> findByHomeOrVisitorOrSeason (String home, String visitor, int season);
}
