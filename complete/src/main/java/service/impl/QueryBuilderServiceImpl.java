package service.impl;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import com.querydsl.core.types.dsl.BooleanExpression;

import model.PredicateBuilder;
import service.QueryBuilderService;

@Service
public class QueryBuilderServiceImpl implements QueryBuilderService {

	public BooleanExpression createQuery (MultiValueMap<String, String> queryParameters, String type){
		PredicateBuilder builder = getPredicateBuilder(type);
		if(queryParameters.size() == 0){
			return null;
		}
		for (Entry<String, List<String>> entry : queryParameters.entrySet()){
			builder.with(entry.getKey(), entry.getValue().get(0));
		}
		return builder.build();

	}
	
	private PredicateBuilder getPredicateBuilder(String type){
		return PredicateFactory.getPredicate(type);
	}
	
}
