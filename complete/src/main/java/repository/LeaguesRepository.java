package repository;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

import model.Games;
import model.Leagues;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface LeaguesRepository extends MongoRepository<Leagues, String>, QueryDslPredicateExecutor<Leagues> {
	
	Leagues findById (String id);
}
