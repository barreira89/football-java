package service;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.querydsl.core.types.dsl.BooleanExpression;

@Service
public interface QueryBuilderService {

	public BooleanExpression createQuery (MultiValueMap<String, String> queryParameters, String type);
}
